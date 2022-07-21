package com.bachan.order.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 订单调用商品服务
 */

@FeignClient(name = "nacos-product",fallback = OrderFeign.OrderFeignFallbackFactory.class)
public interface OrderFeign {
    @GetMapping(value = "/getProductInfo/{productId}")
    public String getProductInfo(@PathVariable("productId") String productId);

//    static class HystrixClientFallback implements OrderFeign {
//        @Override
//        public String getProductInfo(String productId) {
//            return "fallback; reason was:  服务忙，稍后重试" ;
//        }
//    }

    @Slf4j
    @Component
    class OrderFeignFallbackFactory implements FallbackFactory<OrderFeign>{

        @Override
        public OrderFeign create(Throwable cause) {
            log.error("调用异常："+ cause.toString());
            return new OrderFeign() {
                @Override
                public String getProductInfo(String string) {
                    return "开启断路-fallback; reason was: "+ cause;
                }
            };
        }
    }
}
