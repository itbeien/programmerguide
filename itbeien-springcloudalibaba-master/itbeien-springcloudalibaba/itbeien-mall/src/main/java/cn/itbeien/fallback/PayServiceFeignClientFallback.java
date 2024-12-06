package cn.itbeien.fallback;

import cn.itbeien.service.CallPayService;

/**
 * @author beien
 * @date 2024-04-10 21:05
 * Copyright© 2024 beien
 */
public class PayServiceFeignClientFallback implements CallPayService {
    private Throwable throwable;

    public PayServiceFeignClientFallback(Throwable throwable) {
        this.throwable = throwable;
    }
    @Override
    public String doPay() {
        return "fallback:" + throwable.getClass().getSimpleName();
    }
}
