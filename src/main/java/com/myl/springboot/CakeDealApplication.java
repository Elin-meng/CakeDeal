package com.myl.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.myl.springboot.mapper")//扫描的mapper
@SpringBootApplication
public class CakeDealApplication {

    public static void main(String[] args) {
        SpringApplication.run(CakeDealApplication.class, args);
    }

}
