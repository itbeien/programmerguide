package cn.itbeien.pay.service;


import java.util.List;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
public interface IQrCodeService {

    public void createQR(Integer qrNumber,String qrCodeUrl,String qrLocation);

}
