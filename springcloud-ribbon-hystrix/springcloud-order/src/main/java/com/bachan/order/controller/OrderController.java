package com.bachan.order.controller;

import com.bachan.order.feign.OrderFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消费者-订单服务
 */
@RestController
@Slf4j
public class OrderController {
    @Autowired(required = false)
    private OrderFeign orderFeign;

    @GetMapping("/getProduct/{productId}")
    public String getProduct(@PathVariable("productId") String id){
        String response = orderFeign.getProductInfo(id);
        log.info("调用服务结束： "+ response);
        return response;
    }
}
