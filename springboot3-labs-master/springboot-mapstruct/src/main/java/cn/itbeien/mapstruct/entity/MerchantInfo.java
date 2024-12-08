package cn.itbeien.mapstruct.entity;


import java.math.BigDecimal;
import java.util.Date;

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

    public String getMercNo() {
        return mercNo;
    }

    public void setMercNo(String mercNo) {
        this.mercNo = mercNo;
    }

    public String getMercName() {
        return mercName;
    }

    public void setMercName(String mercName) {
        this.mercName = mercName;
    }

    public String getMercNickName() {
        return mercNickName;
    }

    public void setMercNickName(String mercNickName) {
        this.mercNickName = mercNickName;
    }

    public String getPublicKeyPath() {
        return publicKeyPath;
    }

    public void setPublicKeyPath(String publicKeyPath) {
        this.publicKeyPath = publicKeyPath;
    }

    public String getMercSignType() {
        return mercSignType;
    }

    public void setMercSignType(String mercSignType) {
        this.mercSignType = mercSignType;
    }

    public String getMercPrivateKey() {
        return mercPrivateKey;
    }

    public void setMercPrivateKey(String mercPrivateKey) {
        this.mercPrivateKey = mercPrivateKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMccId() {
        return mccId;
    }

    public void setMccId(String mccId) {
        this.mccId = mccId;
    }

    public String getMerArea() {
        return merArea;
    }

    public void setMerArea(String merArea) {
        this.merArea = merArea;
    }

    public String getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractPath() {
        return contractPath;
    }

    public void setContractPath(String contractPath) {
        this.contractPath = contractPath;
    }

    public String getMercBusiLic() {
        return mercBusiLic;
    }

    public void setMercBusiLic(String mercBusiLic) {
        this.mercBusiLic = mercBusiLic;
    }

    public String getLicValiDate() {
        return licValiDate;
    }

    public void setLicValiDate(String licValiDate) {
        this.licValiDate = licValiDate;
    }

    public String getBusiLicFileName() {
        return busiLicFileName;
    }

    public void setBusiLicFileName(String busiLicFileName) {
        this.busiLicFileName = busiLicFileName;
    }

    public String getLegalValidity() {
        return legalValidity;
    }

    public void setLegalValidity(String legalValidity) {
        this.legalValidity = legalValidity;
    }

    public String getCorpReptName() {
        return corpReptName;
    }

    public void setCorpReptName(String corpReptName) {
        this.corpReptName = corpReptName;
    }

    public String getCorpReptId() {
        return corpReptId;
    }

    public void setCorpReptId(String corpReptId) {
        this.corpReptId = corpReptId;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getFixedPhone() {
        return fixedPhone;
    }

    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCorpAddr() {
        return corpAddr;
    }

    public void setCorpAddr(String corpAddr) {
        this.corpAddr = corpAddr;
    }

    public String getOriPasswd() {
        return oriPasswd;
    }

    public void setOriPasswd(String oriPasswd) {
        this.oriPasswd = oriPasswd;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswdFlag() {
        return passwdFlag;
    }

    public void setPasswdFlag(String passwdFlag) {
        this.passwdFlag = passwdFlag;
    }

    public Integer getWrongCounts() {
        return wrongCounts;
    }

    public void setWrongCounts(Integer wrongCounts) {
        this.wrongCounts = wrongCounts;
    }

    public Date getLockedTime() {
        return lockedTime;
    }

    public void setLockedTime(Date lockedTime) {
        this.lockedTime = lockedTime;
    }

    public String getSendBillFlag() {
        return sendBillFlag;
    }

    public void setSendBillFlag(String sendBillFlag) {
        this.sendBillFlag = sendBillFlag;
    }

    public String getMercSettAcctType() {
        return mercSettAcctType;
    }

    public void setMercSettAcctType(String mercSettAcctType) {
        this.mercSettAcctType = mercSettAcctType;
    }

    public String getMercSettAcct() {
        return mercSettAcct;
    }

    public void setMercSettAcct(String mercSettAcct) {
        this.mercSettAcct = mercSettAcct;
    }

    public String getMercSettAcctNm() {
        return mercSettAcctNm;
    }

    public void setMercSettAcctNm(String mercSettAcctNm) {
        this.mercSettAcctNm = mercSettAcctNm;
    }

    public String getMercSettBank() {
        return mercSettBank;
    }

    public void setMercSettBank(String mercSettBank) {
        this.mercSettBank = mercSettBank;
    }

    public String getMercSettBankNm() {
        return mercSettBankNm;
    }

    public void setMercSettBankNm(String mercSettBankNm) {
        this.mercSettBankNm = mercSettBankNm;
    }

    public String getMercSettBankPro() {
        return mercSettBankPro;
    }

    public void setMercSettBankPro(String mercSettBankPro) {
        this.mercSettBankPro = mercSettBankPro;
    }

    public String getMercSettBankCity() {
        return mercSettBankCity;
    }

    public void setMercSettBankCity(String mercSettBankCity) {
        this.mercSettBankCity = mercSettBankCity;
    }

    public String getClearCycle() {
        return clearCycle;
    }

    public void setClearCycle(String clearCycle) {
        this.clearCycle = clearCycle;
    }

    public String getClearDate() {
        return clearDate;
    }

    public void setClearDate(String clearDate) {
        this.clearDate = clearDate;
    }

    public String getClearRate() {
        return clearRate;
    }

    public void setClearRate(String clearRate) {
        this.clearRate = clearRate;
    }

    public String getClearFlag() {
        return clearFlag;
    }

    public void setClearFlag(String clearFlag) {
        this.clearFlag = clearFlag;
    }

    public String getAgentNo() {
        return agentNo;
    }

    public void setAgentNo(String agentNo) {
        this.agentNo = agentNo;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getServicePhone() {
        return servicePhone;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getMercPicsPath() {
        return mercPicsPath;
    }

    public void setMercPicsPath(String mercPicsPath) {
        this.mercPicsPath = mercPicsPath;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getCreditAmt() {
        return creditAmt;
    }

    public void setCreditAmt(BigDecimal creditAmt) {
        this.creditAmt = creditAmt;
    }

    public String getMerMode() {
        return merMode;
    }

    public void setMerMode(String merMode) {
        this.merMode = merMode;
    }

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public String getBusiLicPath() {
        return busiLicPath;
    }

    public void setBusiLicPath(String busiLicPath) {
        this.busiLicPath = busiLicPath;
    }

    public String getMerIdRxm() {
        return merIdRxm;
    }

    public void setMerIdRxm(String merIdRxm) {
        this.merIdRxm = merIdRxm;
    }

    public String getMerIdGhm() {
        return merIdGhm;
    }

    public void setMerIdGhm(String merIdGhm) {
        this.merIdGhm = merIdGhm;
    }

    public String getMerSyt() {
        return merSyt;
    }

    public void setMerSyt(String merSyt) {
        this.merSyt = merSyt;
    }

    public String getMerHjz() {
        return merHjz;
    }

    public void setMerHjz(String merHjz) {
        this.merHjz = merHjz;
    }

    public String getMerMtz() {
        return merMtz;
    }

    public void setMerMtz(String merMtz) {
        this.merMtz = merMtz;
    }

    public BigDecimal getAllowAmt() {
        return allowAmt;
    }

    public void setAllowAmt(BigDecimal allowAmt) {
        this.allowAmt = allowAmt;
    }

    public BigDecimal getPaySingleLimitAmt() {
        return paySingleLimitAmt;
    }

    public void setPaySingleLimitAmt(BigDecimal paySingleLimitAmt) {
        this.paySingleLimitAmt = paySingleLimitAmt;
    }

    public BigDecimal getPayDailyLimitAmt() {
        return payDailyLimitAmt;
    }

    public void setPayDailyLimitAmt(BigDecimal payDailyLimitAmt) {
        this.payDailyLimitAmt = payDailyLimitAmt;
    }

    public String getPayFlag() {
        return payFlag;
    }

    public void setPayFlag(String payFlag) {
        this.payFlag = payFlag;
    }

    public BigDecimal getSingleLimitAmt() {
        return singleLimitAmt;
    }

    public void setSingleLimitAmt(BigDecimal singleLimitAmt) {
        this.singleLimitAmt = singleLimitAmt;
    }

    public BigDecimal getDailyLimitAmt() {
        return dailyLimitAmt;
    }

    public void setDailyLimitAmt(BigDecimal dailyLimitAmt) {
        this.dailyLimitAmt = dailyLimitAmt;
    }

    public String getBusinForm() {
        return businForm;
    }

    public void setBusinForm(String businForm) {
        this.businForm = businForm;
    }

    public String getApprovers() {
        return approvers;
    }

    public void setApprovers(String approvers) {
        this.approvers = approvers;
    }

    public String getLegalType() {
        return legalType;
    }

    public void setLegalType(String legalType) {
        this.legalType = legalType;
    }

    public String getImgInfo() {
        return imgInfo;
    }

    public void setImgInfo(String imgInfo) {
        this.imgInfo = imgInfo;
    }

    @Override
    public String toString() {
        return "MerchantInfo{" +
                "mercNo='" + mercNo + '\'' +
                ", mercName='" + mercName + '\'' +
                ", mercNickName='" + mercNickName + '\'' +
                ", publicKeyPath='" + publicKeyPath + '\'' +
                ", mercSignType='" + mercSignType + '\'' +
                ", mercPrivateKey='" + mercPrivateKey + '\'' +
                ", status='" + status + '\'' +
                ", linkman='" + linkman + '\'' +
                ", telphone='" + telphone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", mccId='" + mccId + '\'' +
                ", merArea='" + merArea + '\'' +
                ", employeeNum='" + employeeNum + '\'' +
                ", contractNo='" + contractNo + '\'' +
                ", contractPath='" + contractPath + '\'' +
                ", mercBusiLic='" + mercBusiLic + '\'' +
                ", licValiDate='" + licValiDate + '\'' +
                ", busiLicFileName='" + busiLicFileName + '\'' +
                ", legalValidity='" + legalValidity + '\'' +
                ", corpReptName='" + corpReptName + '\'' +
                ", corpReptId='" + corpReptId + '\'' +
                ", postCode='" + postCode + '\'' +
                ", fixedPhone='" + fixedPhone + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", corpAddr='" + corpAddr + '\'' +
                ", oriPasswd='" + oriPasswd + '\'' +
                ", passwd='" + passwd + '\'' +
                ", passwdFlag='" + passwdFlag + '\'' +
                ", wrongCounts=" + wrongCounts +
                ", lockedTime=" + lockedTime +
                ", sendBillFlag='" + sendBillFlag + '\'' +
                ", mercSettAcctType='" + mercSettAcctType + '\'' +
                ", mercSettAcct='" + mercSettAcct + '\'' +
                ", mercSettAcctNm='" + mercSettAcctNm + '\'' +
                ", mercSettBank='" + mercSettBank + '\'' +
                ", mercSettBankNm='" + mercSettBankNm + '\'' +
                ", mercSettBankPro='" + mercSettBankPro + '\'' +
                ", mercSettBankCity='" + mercSettBankCity + '\'' +
                ", clearCycle='" + clearCycle + '\'' +
                ", clearDate='" + clearDate + '\'' +
                ", clearRate='" + clearRate + '\'' +
                ", clearFlag='" + clearFlag + '\'' +
                ", agentNo='" + agentNo + '\'' +
                ", manager='" + manager + '\'' +
                ", servicePhone='" + servicePhone + '\'' +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", updateTime=" + updateTime +
                ", updater='" + updater + '\'' +
                ", mercPicsPath='" + mercPicsPath + '\'' +
                ", remark='" + remark + '\'' +
                ", creditAmt=" + creditAmt +
                ", merMode='" + merMode + '\'' +
                ", capital=" + capital +
                ", busiLicPath='" + busiLicPath + '\'' +
                ", merIdRxm='" + merIdRxm + '\'' +
                ", merIdGhm='" + merIdGhm + '\'' +
                ", merSyt='" + merSyt + '\'' +
                ", merHjz='" + merHjz + '\'' +
                ", merMtz='" + merMtz + '\'' +
                ", allowAmt=" + allowAmt +
                ", paySingleLimitAmt=" + paySingleLimitAmt +
                ", payDailyLimitAmt=" + payDailyLimitAmt +
                ", payFlag='" + payFlag + '\'' +
                ", singleLimitAmt=" + singleLimitAmt +
                ", dailyLimitAmt=" + dailyLimitAmt +
                ", businForm='" + businForm + '\'' +
                ", approvers='" + approvers + '\'' +
                ", legalType='" + legalType + '\'' +
                ", imgInfo='" + imgInfo + '\'' +
                '}';
    }
}