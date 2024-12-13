package cn.itbeien.canal.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@Data
@ToString
public class SysUser implements Serializable {
    private String id;
    private String name;
    private Integer age;
    private String email;
}

