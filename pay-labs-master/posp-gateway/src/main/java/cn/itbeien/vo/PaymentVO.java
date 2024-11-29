package cn.itbeien.vo;

import com.alibaba.fastjson2.JSON;
import lombok.Data;
import lombok.ToString;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 */
@Data
@ToString
public class PaymentVO {
    /**
     * 支付金额 H5页面传入
     */
    private String amount;
    /**
     * 支付产品标识 后台获取
     */
    private String productCode;

    /**
     * 支付方式(场景) 后台获取
     */
    private String payType;

    /**
     * 交易码  后台获取
     * pay  支付
     * refund 退款
     */
    private String interfaceCode;
    /**
     * 二维码code H5页面
     */
    private String qrCode;
    /**
     * 支付产品标识
     */
    private String userAngent;
    /**
     * 商户编码
     */
    private String merchantCode;
    /**
     * 订单的备注
     */
    private String orderRemark;

    private String orderTime;
    /**
     * 终端类型
     */
    private String termType;

    public static void main(String[] args) {
        PaymentVO paymentVO = new PaymentVO();
        paymentVO.setAmount("100.00");
        paymentVO.setMerchantCode("1000001");
        paymentVO.setPayType("js");
        paymentVO.setInterfaceCode("pay");

        System.out.println(JSON.toJSONString(paymentVO));
    }

}
