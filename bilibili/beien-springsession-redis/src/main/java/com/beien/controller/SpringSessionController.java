package com.beien.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
@RestController
@RequestMapping("/springSession")
public class SpringSessionController {
    @GetMapping("/setSession")
    public String setSession(HttpSession session, @RequestParam("name") String name, @RequestParam("value") String value)
    {
        session.setAttribute(name,value);
        return "设置成功,sessionID为"+session.getId();
    }
    @GetMapping("/getSession")
    public String getSession(HttpSession session, @RequestParam("name") String name)
    {
        String attribute = (String) session.getAttribute(name);
        System.out.println(attribute);
        return "获取成功,sessionID为"+session.getId()+"值为："+attribute;
    }
}