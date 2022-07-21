package com.bachan.order;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单服务-消费者
 */
@SpringCloudApplication
@EnableFeignClients
public class OrderConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerApp.class, args);
    }
}
