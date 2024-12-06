package com.beien.exception.warnig.module;

/**
 * <p>Description: </p>
 * @date 2023年5月22日
 * @author itbeien
 * @version 1.0
 * <p>Copyright:Copyright(c)2023</p>
 */
public enum DtProductProjectEnum implements IDtProductProject {

	DT_TOURISM_SC("MT.SC", "大同旅行"),

	DT_TOURISM_YB("MT.YB", "大同游伴"),

	DT_TOURISM_DY("MT.DY", "大同导眼"),

	DT_TOURISM_SL("MT.SL", "大同景区地面系统"),

	DT_TOURISM_YKT("MT.YKT", "一卡通"),

	DT_TOURISM_LH("MT.LH", "租赁储物平台"),

	DT_TOURISM_CRM("MT.CRM", "CRM平台"),

	DT_TOURISM_DC("MT.DC", "数据中心"),

	DT_TOURISM_TAX("MT.TAX", "发票服务"),

	DT_TOURISM_FC("MT.FC", "旅游人脸平台"),

	DT_BASE_COMPONENT("MT.COMPONENT", "基础组件"),

	DT_MALL_MANAGER("MT.MM", "商城管理后台")


	;
	/**
	 * 产品线项目组内部编码
	 */
	private String projectCode;

	/**
	 * 产品线项目内部名称
	 */
	private String projectName;

	DtProductProjectEnum(String projectCode, String projectName) {
		this.projectCode = projectCode;
		this.projectName = projectName;
	}

	/**
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @return
	 */
	public String getDtProductProjectCode() {
		return projectCode;
	}

	/**
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @return
	 */
	public String getDtProductProjectName() {
		return projectName;
	}

}
