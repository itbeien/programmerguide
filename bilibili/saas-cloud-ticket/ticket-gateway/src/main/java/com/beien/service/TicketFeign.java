package com.beien.service;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author beien
 * @date 2023/5/14
 * Copyright© 2023 beien
 */
//@FeignClient(name = "ticket-server",fallback = TicketServiceFallback.class, configuration = FeignConfiguration.class)
@FeignClient(value = "ticket-server")
public interface TicketFeign {
    @RequestMapping(value = "/ticket",method = RequestMethod.GET)
    String orderFromClient(@RequestParam(value = "name") String name);
}
/*class FeignConfiguration {
    @Bean
    public TicketServiceFallback echoServiceFallback() {
        return new TicketServiceFallback();
    }
}*/

