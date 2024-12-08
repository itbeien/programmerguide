package cn.itbeien.mapstruct.lombok.test;


import cn.itbeien.mapstruct.lombok.convert.MerchantConvert;
import cn.itbeien.mapstruct.lombok.entity.MerchantInfo;
import cn.itbeien.mapstruct.lombok.vo.MerchantInfoVO;
import cn.itbeien.mapstruct.lombok.vo.SmallMerchantVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * MapStruct 是一个对象属性映射工具,主要用于解决数据模型之间不通用的情况。用于对象与对象之间转换
 * 对象属性值拷贝工具
 * Copyright© 2024 itbeien
 */
@SpringBootTest
public class MapStructTest {

    @Test
    public void test(){
        //vo和实体类属性名称不相同
        SmallMerchantVO smallMerchantVO = new SmallMerchantVO();
        smallMerchantVO.setRegName("华润万家");
        smallMerchantVO.setMerchantName("华润万家");
        smallMerchantVO.setAccName("itbeien");
        smallMerchantVO.setAddress("中国深圳");
        smallMerchantVO.setBusinForm("test");

        MerchantInfo merchantInfo = MerchantConvert.INSTANCE.convertMerchant(smallMerchantVO);
        System.out.println(merchantInfo);


        //vo和实体类属性名称相同
        MerchantInfoVO merchantInfoVO = new MerchantInfoVO();
        merchantInfoVO.setMercNo("88888888");
        merchantInfoVO.setMercName("万象城");
        MerchantInfo merchantInfoOther = MerchantConvert.INSTANCE.convertMerchant(merchantInfoVO);
        System.out.println(merchantInfoOther);
    }
}
