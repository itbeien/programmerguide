package cn.itbeien.mapstruct.lombok.convert;


import cn.itbeien.mapstruct.lombok.entity.MerchantInfo;
import cn.itbeien.mapstruct.lombok.vo.BaseMerchantVO;
import cn.itbeien.mapstruct.lombok.vo.MerchantInfoVO;
import cn.itbeien.mapstruct.lombok.vo.SmallMerchantVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@Mapper
public interface MerchantConvert {


    MerchantConvert INSTANCE = Mappers.getMapper(MerchantConvert.class);

    MerchantInfo convertMerchant(MerchantInfoVO merchantInfoVO);

    @Mappings({
            @Mapping(source = "regName", target = "mercName"),
            @Mapping(source = "merchantName",target = "mercNickName"),
            @Mapping(source = "merLegal",target = "linkman"),
            @Mapping(source = "industries",target = "mccId"),
            @Mapping(source = "address",target = "merArea"),
            @Mapping(source = "employeeNum",target = "employeeNum",defaultValue = "1"),
            @Mapping(source = "merLegal",target = "corpReptName"),
            @Mapping(source = "legalCode",target = "corpReptId"),
            @Mapping(source = "address",target = "province"),
            @Mapping(source = "address",target = "city"),
            @Mapping(source = "addressDetail",target = "corpAddr"),
            @Mapping(source = "accType",target = "mercSettAcctType"),
            @Mapping(source = "account",target = "mercSettAcct"),
            @Mapping(source = "accName",target = "mercSettAcctNm"),
            @Mapping(source = "bankCode",target = "mercSettBank"),
            @Mapping(source = "bankName",target = "mercSettBankNm"),
            @Mapping(target = "merMode", expression = "java( cn.itbeien.mapstruct.lombok.enums.MerModeEnum.PERSON.getCode() )"),
            @Mapping(source = "capital",target = "capital",defaultValue = "10"),
            @Mapping(source = "rxm",target = "merIdRxm"),
            @Mapping(source = "ghm",target = "merIdGhm"),
            @Mapping(source = "syt",target = "merSyt"),
            @Mapping(source = "hjz",target = "merHjz"),
            @Mapping(source = "mtz",target = "merMtz"),
            @Mapping(source = "businForm",target = "businForm",defaultValue = "02"),
            @Mapping(source = "controlerLegalType",target = "legalType"),
            @Mapping(source = "imgInfo",target = "imgInfo"),
            @Mapping(source = "calcVal",target = "clearRate"),
            @Mapping(target = "createTime",expression = "java( new java.util.Date() )"),
    })
    MerchantInfo convertMerchant(SmallMerchantVO smallMerchantVO);


    @Mappings({
            @Mapping(source = "regName", target = "mercName"),
            @Mapping(source = "merchantName",target = "mercNickName"),
            @Mapping(source = "merLegal",target = "linkman"),
            @Mapping(source = "legalPhone",target = "telphone"),
            @Mapping(source = "industries",target = "mccId"),
            @Mapping(source = "address",target = "merArea"),
            @Mapping(source = "employeeNum",target = "employeeNum",defaultValue = "1"),
            @Mapping(source = "merLegal",target = "corpReptName"),
            @Mapping(source = "legalCode",target = "corpReptId"),
            @Mapping(source = "address",target = "province"),
            @Mapping(source = "address",target = "city"),
            @Mapping(source = "addressDetail",target = "corpAddr"),
            @Mapping(source = "accType",target = "mercSettAcctType"),
            @Mapping(source = "account",target = "mercSettAcct"),
            @Mapping(source = "accName",target = "mercSettAcctNm"),
            @Mapping(source = "bankCode",target = "mercSettBank"),
            @Mapping(source = "bankName",target = "mercSettBankNm"),
            @Mapping(source = "merType", target = "merMode"),
            @Mapping(source = "capital",target = "capital",defaultValue = "10"),
            @Mapping(source = "rxm",target = "merIdRxm"),
            @Mapping(source = "ghm",target = "merIdGhm"),
            @Mapping(source = "syt",target = "merSyt"),
            @Mapping(source = "hjz",target = "merHjz"),
            @Mapping(source = "mtz",target = "merMtz"),
            @Mapping(source = "yyzz",target = "busiLicFileName"),
            @Mapping(source = "merLic",target = "mercBusiLic"),
            @Mapping(source = "licValidity",target = "licValiDate"),
            @Mapping(source = "businForm",target = "businForm",defaultValue = "02"),
            @Mapping(source = "controlerLegalType",target = "legalType"),
            @Mapping(source = "imgInfo",target = "imgInfo"),
            @Mapping(source = "calcVal",target = "clearRate"),
            @Mapping(target = "createTime",expression = "java( new java.util.Date() )"),
    })
    MerchantInfo convertMerchant(BaseMerchantVO baseMerchantVO);
}
