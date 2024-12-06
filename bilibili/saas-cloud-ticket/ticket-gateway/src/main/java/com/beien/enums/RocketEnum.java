package com.beien.enums;

/**
 * @author beien
 * @date 2023/3/5 16:10
 * Copyright© 2023 beien
 * 消息服务配置枚举
 */
public enum RocketEnum {

    NAME_SERVER("NAME_SERVER ","139.9.46.7:9876"),
    TOPIC("TOPIC","beien-rocketmq-test");

    private String code;
    private String value;

    private RocketEnum(String code, String value){
        this.code = code;
        this.value = value;
    }
    private RocketEnum(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
