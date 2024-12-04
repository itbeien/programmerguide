package cn.itbeien.enums;


/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
public enum CommandIDEnums {

    SignIn(0x80000001,"签到")
    ;
    private int command;
    private String desc;
    CommandIDEnums(int command, String desc){
        this.command = command;
        this.desc = desc;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
