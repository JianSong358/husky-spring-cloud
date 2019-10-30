package com.husky.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients(basePackages={"com.husky.cloud"})
@SpringBootApplication
public class Application6002 {
    public static void main(String[] args) {
        SpringApplication.run(Application6002.class,args) ;
    }
}
