package com.alsocity.equipment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : 小凡
 * @date : create in 2021/7/21 13:07
 * description :
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class EquipmentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EquipmentServiceApplication.class,args);
    }
}
