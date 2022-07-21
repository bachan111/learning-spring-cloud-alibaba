package com.bachan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProviderController {

    @GetMapping(value = "/getProductInfo/{productId}")
    public String getProductInfo(@PathVariable("productId") String productId){
        log.info("请求进来啦");
        try {
            Thread.sleep(5000);
        }catch (Exception e){

        }
        return "Hello Nacos Discovery " + productId;
    }
}
