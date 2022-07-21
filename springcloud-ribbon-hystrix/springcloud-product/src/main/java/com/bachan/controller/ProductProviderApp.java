package com.bachan.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 *
 * 商品服务-提供者
 */
@SpringCloudApplication
public class ProductProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(ProductProviderApp.class, args);
    }
}
