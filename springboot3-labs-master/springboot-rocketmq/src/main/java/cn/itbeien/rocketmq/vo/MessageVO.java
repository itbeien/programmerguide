package cn.itbeien.rocketmq.vo;

import lombok.Data;


/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@Data
public class MessageVO {
    private Integer id;
    private String msg;

    public MessageVO(Integer id,String msg){
        this.id = id;
        this.msg = msg;
    }
}
