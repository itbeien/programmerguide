package cn.itbeien.enums;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * 维护服务地址的枚举类
 */
public enum ServiceInstanceEnum {
    PayServiceURL("/api/pay","支付微服务url"),
    SIGN("/api/sign","支付微服务-签到url")
    ;
    private String code;
    private String desc;
    ServiceInstanceEnum(String code, String desc){
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
