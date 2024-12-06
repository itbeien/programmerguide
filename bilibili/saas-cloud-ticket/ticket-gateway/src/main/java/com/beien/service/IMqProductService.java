package com.beien.service;

/**
 * @author beien
 * @date 2023/3/11 9:35
 * Copyright© 2023 beien
 * 入园消息生产者服务类
 */
public interface IMqProductService {
    public void createMsg(String msg);
}
