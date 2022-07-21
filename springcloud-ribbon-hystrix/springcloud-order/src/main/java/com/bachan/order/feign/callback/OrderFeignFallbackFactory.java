package com.bachan.order.feign.callback;

import com.bachan.order.feign.OrderFeign;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Hystrix断路器
 */

@Component
@Slf4j
public class OrderFeignFallbackFactory implements FallbackFactory<OrderFeign> {
    @Override
    public OrderFeign create(Throwable throwable) {
        log.error(throwable.toString());
        return new OrderFeign() {
            @Override
            public String getProductInfo(String productId) {
                return "fallback; reason was: "+ throwable;
            }
        };
    }
}
