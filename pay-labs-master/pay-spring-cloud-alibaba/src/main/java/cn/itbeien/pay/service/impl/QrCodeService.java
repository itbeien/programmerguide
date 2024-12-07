package cn.itbeien.pay.service.impl;



import cn.itbeien.common.util.Base64Util;
import cn.itbeien.common.util.DtUtil;
import cn.itbeien.common.util.qr.QrcodeUtil;
import cn.itbeien.pay.service.IQrCodeService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.util.Date;
/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@Service
public class QrCodeService implements IQrCodeService {
    /**
     *
     * @param qrNumber  创建聚合二维码的数量
     * @param qrCodeContent 聚合二维码中的内容
     * @param baseQrLocation 聚合二维码存放的物理路径
     * @return
     * @throws Exception
     */
    @Override
    public void createQR(Integer qrNumber,String qrCodeContent,String baseQrLocation) {

        for(int i=0;i<qrNumber;i++){//批量创建聚合二维码

            String qrCode = DtUtil.uuid();
            String qrCodeBase64 = null;
            try {
                qrCodeBase64 = Base64Util.encodeBase64(qrCode.getBytes());

                //二维码内容为域名地址+base64的二维码编号
                //system.qrcode.url=http://外网域名/pay/auth?code=%s
                String  content = String.format(qrCodeContent,qrCodeBase64);
                //qrcode_location=D:\dtpay\qrimg\%s

                String qrLocation = String.format(baseQrLocation+"/"+qrCode+".png");
                Path file = new File(qrLocation).toPath();
                QrcodeUtil.createQr(content,file);

                String profile = "/profile/"+qrCode+".png";//qr访问路径

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
