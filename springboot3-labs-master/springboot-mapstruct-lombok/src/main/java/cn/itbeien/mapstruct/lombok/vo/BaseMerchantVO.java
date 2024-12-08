package cn.itbeien.mapstruct.lombok.vo;

import lombok.Data;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@Data
public class BaseMerchantVO {

    private String code;
    /**
     * 开户行名称
     */
    private String bankName;
    /**
     * 开户行行号
     */
    private String bankCode;
    /**
     * 银行卡账号
     */
    private String account;
    /**
     * 账号名称
     */
    private String accName;
    /**
     * 账号类型 00 个人 01对公
     */
    private String accType;

    /**
     * 法人身份证正面
     */
    private String rxm;
    /**
     * 法人身份证反面
     */
    private String ghm;
    /**
     * 证件类型
     */
    private String controlerLegalType;

    /**
     * 姓名
     */
    private String merLegal;
    /**
     * 证件号码
     */
    private String legalCode;
    /**
     * 证件有效期
     */
    private String legalValidity;

    /**
     * 营业执照
     */
    private String yyzz;

    /**
     * 商户类型 1个体 0企业
     */
    private String merType;

    /**
     * 公司规模
     */
    private String employeeNum;

    /**
     * 经营形态 连锁店01 普通店02
     */
    private String businForm;

    /**
     * 商户注册名称
     */
    private String regName;
    /**
     * 统一社会信用代码
     */
    private String merLic;
    /**
     * 营业执照有效期
     */
    private String licValidity;
    /**
     * 商户简称
     */
    private String merchantName;
    /**
     * 所属地区
     */
    private String address;

    /**
     * 注册地址
     */
    private String addressDetail;
    /**
     * 注册资本
     */
    private String capital;
    /**
     * 所属行业
     */
    private String industries;
    /**
     * 联系人电话
     */
    private String legalPhone;
    /**
     * 清算授权书
     */
    private String qssqs;
    /**
     * 收银台
     */
    private String syt;
    /**
     * 门头照
     */
    private String mtz;

    /**
     * 内部环境照
     */
    private String hjz;

    /**
     * 扣率
     */
    private String calcVal;
    /**
     * 图片信息
     */
    private String imgInfo;

    private String merchantNo;


}
