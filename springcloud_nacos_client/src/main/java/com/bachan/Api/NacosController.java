package com.bachan.Api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RefreshScope
public class NacosController {
    @Value("${user.name}")
    private String userName;


    @GetMapping("/getConfig")
    public String getConfig() {
        log.info("从nacos-server读取的数据=>>>>>： {}", userName);
        return userName;
    }
}
