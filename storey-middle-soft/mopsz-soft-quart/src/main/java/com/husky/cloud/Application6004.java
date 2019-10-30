package com.husky.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages={"com.husky.cloud"})
@MapperScan(basePackages = {"com.husky.cloud.mapper"})
public class Application6004 {
    public static void main(String[] args) {
        SpringApplication.run(Application6004.class,args) ;
    }
}
