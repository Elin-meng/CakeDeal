package com.myl.springboot.controller;

import com.myl.springboot.entity.ChBlCakeEntity;
import com.myl.springboot.service.ChBlCakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

@RestController
public class ChBlCakeController {
    @Autowired
    private ChBlCakeService chBlCakeService;

    @RequestMapping("/getTotal")
    public String getTotal(String personId, int cakeDate,String cakeId) {
        ChBlCakeEntity chBlCakeEntity = new ChBlCakeEntity();
        chBlCakeEntity.setPersonId(personId);
        chBlCakeEntity.setCakeDate(cakeDate);
        chBlCakeEntity.setCakeId(cakeId);
        chBlCakeEntity.setTaskId(getProcessID());
        return  chBlCakeService.getCakeIdByPersonIdDate(chBlCakeEntity);
    }

    public static final String getProcessID() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getName());
        return runtimeMXBean.getName();
    }
}
