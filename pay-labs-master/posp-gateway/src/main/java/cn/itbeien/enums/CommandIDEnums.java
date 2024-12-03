package cn.itbeien.enums;

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
