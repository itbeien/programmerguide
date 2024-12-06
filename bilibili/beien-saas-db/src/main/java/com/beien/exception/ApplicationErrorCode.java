package com.beien.exception;

import com.beien.exception.warnig.DtWarnTypeEnum;
import com.beien.exception.warnig.DtWarningLevelEnum;
import com.beien.exception.warnig.IDtWarnType;
import com.beien.exception.warnig.module.DtProductProjectEnum;
import com.beien.exception.warnig.module.IDtProductProject;

/**
 * <p>
 * Description:
 * </p>
 * @date 2023年5月21日
 * @author itbeien
 * @version 1.0
 * <p>
 * Copyright:Copyright(c)2023
 * </p>
 */
public enum ApplicationErrorCode implements IDtErrorCode {

	SYSTEM_ERROR(false, "SYS_ERROR_001", "系统异常，请联系管理员", DtWarningLevelEnum.RED,DtWarnTypeEnum.SYSTEM),

	SYSTEM_SUCCESS(true, "SYS_SUCCESS_001", "操作成功", DtWarningLevelEnum.GREEN,DtWarnTypeEnum.SYSTEM),

	SYSTEM_ACCESS_FORBIDDEN(false, "SYS_ACCESS_FORBIDDEN_001", "无操作权限", DtWarningLevelEnum.BLUE),

	SYSTEM_ACCESS_PARAM_ERROR(false, "SYS_ACCESS_PARAM_ERROR", "参数错误", DtWarningLevelEnum.BLUE),

	SYSTEM_UPPIC_ERROR(false, "SYS_ERROR_UP_0001", "上传图片类型错误", DtWarningLevelEnum.BLUE),

	SYSTEM_FILE_NOT_FOUND(false, "SYS_ERROR_FILE_0001", "文件不存在", DtWarningLevelEnum.BLUE),

	SYSTEM_PARTTION_DATA_ERROR(false, "SYS_ERROR_PARTITON_002", "该实体不存在分表信息，请查看配置", DtWarningLevelEnum.BLUE,DtWarnTypeEnum.SYSTEM),

	SYS_ERROR_EXPORT_FTP_ERROR(false, "SYS_ERROR_EXPORT_FTP_ERROR_0003", "上传至FTP失败", DtWarningLevelEnum.BLUE,DtWarnTypeEnum.SYSTEM),

	SYS_ERROR_CREATE_DIR(false, "SYS_ERROR_CREATE_DIR_0004", "创建目录失败", DtWarningLevelEnum.BLUE,DtWarnTypeEnum.SYSTEM),

	SYSTEM_JAVA_REFLECT_ERROR(false, "SYSTEM_JAVA_REFLECT_ERROR_0005", "反射工具类异常", DtWarningLevelEnum.BLUE,DtWarnTypeEnum.SYSTEM),

	SYS_ORDER_REPEAT_COMMIT_ORDER(false, "SYS_ORDER_REPEAT_COMMIT_ORDER_008", "订单重复提交", DtWarningLevelEnum.BLUE),

	SYS_REQUEST_REPEAT(false, "SYS_ORDER_REPEAT_COMMIT_ORDER_0009", "重复请求", DtWarningLevelEnum.BLUE),

	SYS_SERIVICE_OPERATE_NOT_FOUND(false, "SYS_ERROR_SERVICE_OPERATE_NOT_FOUND_0007", "业务运营商不存在或者状态不正确",
			DtWarningLevelEnum.YELLOW, DtWarnTypeEnum.SYSTEM),

	SYS_ERROR_REDIS_CACHE(false, "SYS_ERROR_REDIS_CACHE_0008", "缓存服务异常", DtWarningLevelEnum.RED,DtWarnTypeEnum.SYSTEM),

	SYS_SERVICE_OPERATE_BUSSNIESS_SUPPOET_IDCAR(false, "SYS_SERVICE_OPERATE_BUSSNIESS_SUPPOET_IDCAR_0010",
			"业态不支持身份证验证", DtWarningLevelEnum.YELLOW),

	SYS_TERMINAL_NOT_FOUND(false, "SYS_TERMINAL_NOT_FOUND_0011", "设备未找到", DtWarningLevelEnum.YELLOW),

	SYS_PARTITION_CONFIG_INIT(false, "SYS_PARTITION_CONFIG_INIT_0012", "分表初始化失败", DtWarningLevelEnum.YELLOW,DtWarnTypeEnum.SYSTEM),

	SYS_PARTITION_GET_INFO(false, "SYS_PARTITION_CONFIG_INIT_0013", "获取分区信息失败", DtWarningLevelEnum.YELLOW,DtWarnTypeEnum.SYSTEM),

	SYS_PARTITION_ERROR_PARAMETER(false, "SYS_PARTITION_ERROR_PARAMETER_0014", "获取分区参数不合法", DtWarningLevelEnum.YELLOW,DtWarnTypeEnum.SYSTEM),

	SYS_ERROR_INTERFACE_OPERATE_TYPE(false, "SYS_ERROR_INTERFACE_OPERATE_TYPE_0015", "错误的业务接口操作类型", DtWarningLevelEnum.YELLOW),

	SYS_ERROR_ENCRYPT_SINGED(false, "SYS_ERROR_ENCRYPT_SINGED_0016", "签名加密错误", DtWarningLevelEnum.ORANGE,DtWarnTypeEnum.SYSTEM),

	EXCEL_EXPORT_NUM_ERROR(false, "EXCEL_ERROR_001", "excel导出异常，超过系统允许最大导出数量限制:", DtWarningLevelEnum.BLUE),

	CAN_NOT_FOUND_DAY_ACCOUNT_CHECK_BEGIN_REPORT(false, "DAY_ACCOUNT_CHECK_ERROR_001", "找不到期初分销商日对账报表数据!", DtWarningLevelEnum.RED, DtWarnTypeEnum.SYSTEM),

	DATE_FORMAT_ERROR(false, "DATE_ERROR_001", "日期格式异常", DtWarningLevelEnum.BLUE),

	IMAGE_TO_BYTE_ERROR(false, "IMAGE_TO_BYTE_ERROR_001", "图片解析异常", DtWarningLevelEnum.BLUE,DtWarnTypeEnum.SYSTEM),


    MICRO_SERVER_ORDER_OC_INVOKE_ERROR(false, "MICRO_SERVER_OC_001", "OC服务调用异常", DtWarningLevelEnum.YELLOW),

    SYS_ILLEGAL_ARGUMENT(false, "SYS_ILLEGAL_ARGUMENT_017", "参数无效", DtWarningLevelEnum.RED, DtWarnTypeEnum.SYSTEM),

    SYS_METHOD_NOT_IMPLEMENT(false, "SYS_METHOD_NOT_IMPLEMENT_018", "方法还未实现", DtWarningLevelEnum.ORANGE, DtWarnTypeEnum.SYSTEM),

    COMPRESS_EXPORT_NULL_ERROE(false, "COMPRESS_001", "导出凭证信息为空", DtWarningLevelEnum.BLUE),

    COMPRESS_NUM_ERROR(false, "COMPRESS_002", "文件导出异常，超过系统允许最大导出数量限制", DtWarningLevelEnum.BLUE),

    TENANT_NOT_FOUND_ERROR(false, "TENANT_NOT_FOUND_ERROR_001", "请配置租户信息,业务运营商编号未找到对应数据源配置", DtWarningLevelEnum.BLUE,DtWarnTypeEnum.SYSTEM),
    DATASOURCE_NOT_FOUND_ERROR(false, "DATASOURCE_NOT_FOUND_ERROR_001", "数据源未创建成功,请检查数据库连接信息", DtWarningLevelEnum.BLUE,DtWarnTypeEnum.SYSTEM),
	;
    private String selfDefineCode;

    private String message;

    private DtWarningLevelEnum warningLevelEnum;

    private boolean successFlag;

    private IDtWarnType warnType;


    ApplicationErrorCode(boolean successFlag, String selfDefineCode, String message,
                         DtWarningLevelEnum warningLevelEnum) {
        this.selfDefineCode = selfDefineCode;
        this.message = message;
        this.warningLevelEnum = warningLevelEnum;
        this.successFlag = successFlag;
        this.warnType = DtWarnTypeEnum.BUSSNISS;
    }

    ApplicationErrorCode(boolean successFlag, String selfDefineCode, String message,
                DtWarningLevelEnum warningLevelEnum, IDtWarnType warnType) {
        this.selfDefineCode = selfDefineCode;
        this.message = message;
        this.warningLevelEnum = warningLevelEnum;
        this.successFlag = successFlag;
        this.warnType = warnType;
    }

    /**
     * 方法用途: <br>
     * 实现步骤: <br>
     *
     * @return
     */
    @Override
    public String getSelfDefineCode() {
        return selfDefineCode;
    }

    /**
     * 方法用途: <br>
     * 实现步骤: <br>
     *
     * @return
     */
    @Override
    public IDtProductProject getErroCodePrefix() {
        return DtProductProjectEnum.DT_TOURISM_SC;
    }

    /**
     * 方法用途: <br>
     * 实现步骤: <br>
     *
     * @return
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * 方法用途: <br>
     * 实现步骤: <br>
     *
     * @return
     */
    @Override
    public DtWarningLevelEnum getWarningLevel() {
        return warningLevelEnum;    }

    /**
     * 方法用途: <br>
     * 实现步骤: <br>
     *
     * @return
     */
    @Override
    public boolean getSuccessFlag() {
        return successFlag;
    }

    @Override
    public IDtWarnType getWarnType() {
        return warnType;
    }
}
