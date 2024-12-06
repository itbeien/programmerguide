package com.beien.exception.warnig;

public enum DtWarnTypeEnum implements IDtWarnType {


	SYSTEM("system"),

	BUSSNISS("bussniss");

	private String name;

	DtWarnTypeEnum(String name) {
        this.name = name;
    }

	public String getName() {
		return name;
	}

    /**
     * 获取预警的类别
     * @return
     */
    @Override
    public String getWarnTypeName(){
        return this.name;
    }

}
