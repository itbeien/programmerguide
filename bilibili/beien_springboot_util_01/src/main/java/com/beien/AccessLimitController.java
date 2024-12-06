package com.beien;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleSelectJoin;
import com.beien.annotation.AccessLimit;
import com.beien.view.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author beien
 * @date 2023-05-19 19:35
 * Copyright© 2023 beien
 */
@RestController
@RequestMapping("/accessLimit")
@Slf4j
public class AccessLimitController {

    @GetMapping("/test")
    @AccessLimit(limit = 4,time = 10)
    @ResponseBody
    public Object test(HttpServletRequest request, @RequestParam String name){
        Message message = new Message();
        message.setCode(200);
        message.setMessage(name + " hello world!!!");
        return message;
    }
}
