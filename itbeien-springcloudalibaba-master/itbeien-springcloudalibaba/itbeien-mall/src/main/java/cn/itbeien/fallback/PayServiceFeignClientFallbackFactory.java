package cn.itbeien.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author beien
 * @date 2024-04-10 21:06
 * Copyright© 2024 beien
 */
@Component
public class PayServiceFeignClientFallbackFactory implements FallbackFactory<PayServiceFeignClientFallback> {

    @Override
    public PayServiceFeignClientFallback create(Throwable throwable) {
        // 可以给 PayServiceFeignClientFallback 提供具体的 throwable 异常
        return new PayServiceFeignClientFallback(throwable);
    }
}
