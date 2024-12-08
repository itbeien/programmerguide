package cn.itbeien.mapstruct.lombok.enums;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
public enum MerModeEnum {
    //商户类型（0-企业 1-个体户 2-个人）
    ENTERPRISE("0","企业"),
    SELF_EMPLOYED("1","个体户"),
    PERSON("2","个人")
    ;
    private String code;
    private String desc;

    MerModeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
