package com.bo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.bo.mapper")
@EnableScheduling
@EnableSwagger2
//@EnableConfigurationProperties
public class boBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(boBlogApplication.class,args);
    }
}
