package cn.itbeien.mapstruct.vo;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getRxm() {
        return rxm;
    }

    public void setRxm(String rxm) {
        this.rxm = rxm;
    }

    public String getGhm() {
        return ghm;
    }

    public void setGhm(String ghm) {
        this.ghm = ghm;
    }

    public String getControlerLegalType() {
        return controlerLegalType;
    }

    public void setControlerLegalType(String controlerLegalType) {
        this.controlerLegalType = controlerLegalType;
    }

    public String getMerLegal() {
        return merLegal;
    }

    public void setMerLegal(String merLegal) {
        this.merLegal = merLegal;
    }

    public String getLegalCode() {
        return legalCode;
    }

    public void setLegalCode(String legalCode) {
        this.legalCode = legalCode;
    }

    public String getLegalValidity() {
        return legalValidity;
    }

    public void setLegalValidity(String legalValidity) {
        this.legalValidity = legalValidity;
    }

    public String getYyzz() {
        return yyzz;
    }

    public void setYyzz(String yyzz) {
        this.yyzz = yyzz;
    }

    public String getMerType() {
        return merType;
    }

    public void setMerType(String merType) {
        this.merType = merType;
    }

    public String getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getBusinForm() {
        return businForm;
    }

    public void setBusinForm(String businForm) {
        this.businForm = businForm;
    }

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public String getMerLic() {
        return merLic;
    }

    public void setMerLic(String merLic) {
        this.merLic = merLic;
    }

    public String getLicValidity() {
        return licValidity;
    }

    public void setLicValidity(String licValidity) {
        this.licValidity = licValidity;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getIndustries() {
        return industries;
    }

    public void setIndustries(String industries) {
        this.industries = industries;
    }

    public String getLegalPhone() {
        return legalPhone;
    }

    public void setLegalPhone(String legalPhone) {
        this.legalPhone = legalPhone;
    }

    public String getQssqs() {
        return qssqs;
    }

    public void setQssqs(String qssqs) {
        this.qssqs = qssqs;
    }

    public String getSyt() {
        return syt;
    }

    public void setSyt(String syt) {
        this.syt = syt;
    }

    public String getMtz() {
        return mtz;
    }

    public void setMtz(String mtz) {
        this.mtz = mtz;
    }

    public String getHjz() {
        return hjz;
    }

    public void setHjz(String hjz) {
        this.hjz = hjz;
    }

    public String getCalcVal() {
        return calcVal;
    }

    public void setCalcVal(String calcVal) {
        this.calcVal = calcVal;
    }

    public String getImgInfo() {
        return imgInfo;
    }

    public void setImgInfo(String imgInfo) {
        this.imgInfo = imgInfo;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }
}
