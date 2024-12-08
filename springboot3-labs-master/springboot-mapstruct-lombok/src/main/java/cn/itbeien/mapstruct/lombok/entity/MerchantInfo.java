package cn.itbeien.mapstruct.lombok.entity;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MerchantInfo {
    private String mercNo;

    private String mercName;

    private String mercNickName;

    private String publicKeyPath;

    private String mercSignType;

    private String mercPrivateKey;

    private String status;

    private String linkman;

    private String telphone;

    private String email;

    private String address;

    private String mccId;

    private String merArea;

    private String employeeNum;

    private String contractNo;

    private String contractPath;

    private String mercBusiLic;

    private String licValiDate;

    private String busiLicFileName;

    private String legalValidity;

    private String corpReptName;

    private String corpReptId;

    private String postCode;

    private String fixedPhone;

    private String province;

    private String city;

    private String corpAddr;

    private String oriPasswd;

    private String passwd;

    private String passwdFlag;

    private Integer wrongCounts;

    private Date lockedTime;

    private String sendBillFlag;

    private String mercSettAcctType;

    private String mercSettAcct;

    private String mercSettAcctNm;

    private String mercSettBank;

    private String mercSettBankNm;

    private String mercSettBankPro;

    private String mercSettBankCity;

    private String clearCycle;

    private String clearDate;

    //费率
    private String clearRate;

    private String clearFlag;

    private String agentNo;

    private String manager;

    private String servicePhone;

    private Date createTime;

    private String creator;

    private Date updateTime;

    private String updater;

    private String mercPicsPath;

    private String remark;

    private BigDecimal creditAmt;

    private String merMode;

    private Integer capital;

    private String busiLicPath;

    private String merIdRxm;

    private String merIdGhm;

    private String merSyt;

    private String merHjz;

    private String merMtz;

    private BigDecimal allowAmt;

    private BigDecimal paySingleLimitAmt;

    private BigDecimal payDailyLimitAmt;

    private String payFlag;

    private BigDecimal singleLimitAmt;

    private BigDecimal dailyLimitAmt;

    private String businForm;

    private String approvers;

    private String legalType;
    /**
     * 用于存储图片json格式
     */
    private String imgInfo;


}