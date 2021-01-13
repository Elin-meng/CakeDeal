package com.myl.springboot.mapper;

import com.myl.springboot.entity.ChBlCakeEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface ChBlCakeMapper {
    ChBlCakeEntity getInfoByPersonIdDate(int cakeDate);

    ArrayList selectTotalByPersonIdDate(ChBlCakeEntity chBlCakeEntity);

    Integer insertCakeByPersonIdDate(ChBlCakeEntity chBlCakeEntity);

    Integer updateCakeByPersonIdDateCakeid(ChBlCakeEntity chBlCakeEntity);
}
