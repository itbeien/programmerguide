package com.beien;

/**
 * @author beien
 * @date 2023/3/5 16:20
 * Copyright© 2023 beien
 */
//发送的取消订单信息
public class OrderMsg {
    //用户id
    private int userId;
    public int getUserId() {
        return this.userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    //订单sn
    private String orderId;
    public String getOrderId() {
        return this.orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}


