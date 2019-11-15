package com.xdy.bitcoin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@MapperScan("com.xdy.bitcoin.dao")
@EnableDiscoveryClient
@EnableScheduling
public class BitcoinApplication {
    public static void main(String[] args) {
        SpringApplication.run(BitcoinApplication.class, args);
    }
}
