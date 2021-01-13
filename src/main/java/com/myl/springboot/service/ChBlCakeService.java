package com.myl.springboot.service;

import com.myl.springboot.entity.ChBlCakeEntity;
import com.myl.springboot.mapper.ChBlCakeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ChBlCakeService {
    @Autowired
    ChBlCakeMapper chBlCakeMapper;


    public String getCakeIdByPersonIdDate(ChBlCakeEntity chBlCakeEntity) {
        //1.先插入当日蛋糕数据:如果表中无数据则插入对应的数据；如果表中有数据则插入0条记录。
        Integer insertRow = chBlCakeMapper.insertCakeByPersonIdDate(chBlCakeEntity);
        if (null == insertRow) {
            //插入蛋糕不成功
            return "插入蛋糕数据失败！！！";
        }
        while (true) {
            //2.判断是否还有待发放的蛋糕
            ArrayList usableCakeList = chBlCakeMapper.selectTotalByPersonIdDate(chBlCakeEntity);
            if (null == usableCakeList || usableCakeList.isEmpty()) {
                //当日无待获取蛋糕
                return "当日无待获取蛋糕";
            }

            Integer updateRows = 0;//update成功的记录行数
            //3.判断输入的蛋糕编号是否为空：如果非空则根据蛋糕编号去获取指定蛋糕，如果指定蛋糕已被获取则随机拿一个蛋糕；如果无数据则随机获取一个蛋糕
            if (null == chBlCakeEntity.getCakeId() || 0 == chBlCakeEntity.getCakeId().length()) {
                if (usableCakeList.contains(chBlCakeEntity.getCakeId())) {
                    //根据蛋糕编号获取蛋糕
                    //释放上面select查询的锁，执行rollback语句
                    updateRows = chBlCakeMapper.updateCakeByPersonIdDateCakeid(chBlCakeEntity);
                }

            }
            if (updateRows.equals(1)) {
                return String.format("1%s进程获取到蛋糕%s", chBlCakeEntity.getTaskId(), chBlCakeEntity.getCakeId());
            }
            //随机获取蛋糕
            //释放上面select查询的锁，执行rollback语句
            chBlCakeEntity.setCakeId(usableCakeList.get(0).toString());
            updateRows = chBlCakeMapper.updateCakeByPersonIdDateCakeid(chBlCakeEntity);
            if (updateRows.equals(1)) {
                return String.format("2%s进程获取到蛋糕%s", chBlCakeEntity.getTaskId(), chBlCakeEntity.getCakeId());
            }
        }

    }

}
