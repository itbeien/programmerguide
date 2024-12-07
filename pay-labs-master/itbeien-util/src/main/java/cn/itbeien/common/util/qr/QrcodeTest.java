package cn.itbeien.common.util.qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 */
public class QrcodeTest {
    //测试网络logo图片生成二维码
    //@Test
    public void fun01() throws IOException {
        Path path = Paths.get("D:\\creator\\creation\\code\\itbeien\\backend\\dtpay\\QR\\a.png");
        URL url = new URL("logo的网络地址");
        BitMatrix matrix = BitMatrixBuilder.create().setContent("https://www.csdn.net/").build();
        QrcodeUtil.createLogoQrCodeToPath(matrix,path,url);
        System.out.println("ok");
    }

    //测试本地logo图片生成二维码
    //@Test
    public void fun02() throws IOException {
        Path path = Paths.get("D:\\creator\\creation\\code\\itbeien\\backend\\dtpay\\QR\\a2.png");
        Path path2 = Paths.get("D:\\creator\\creation\\code\\itbeien\\backend\\dtpay\\QR\\logo.png");
        BitMatrix matrix = BitMatrixBuilder.create().setContent("https://www.csdn.net/").build();
        QrcodeUtil.createLogoQrCodeToPath(matrix,path,path2);
        System.out.println("ok");
    }



    //测试修改背景色
    //@Test
    public void fun03() throws IOException {
        Path path = Paths.get("D:\\creator\\creation\\code\\itbeien\\backend\\dtpay\\QR\\a3.png");
        Path path2 = Paths.get("D:\\creator\\creation\\code\\itbeien\\backend\\dtpay\\QR\\logo.png");
        BitMatrix matrix = BitMatrixBuilder.create().setContent("https://www.csdn.net/").build();
        QrcodeUtil.createLogoQrCodeToPath(matrix,path,path2, Color.GRAY,Color.ORANGE);
        System.out.println("ok");
    }

    /**
     * 生成普通二维码
     * @throws IOException
     */
    //@Test
    public void fun04() throws IOException {
        String content="http://www.csdn.net";//写入到二维码中的内容
        Path file = new File("D:\\creator\\creation\\code\\itbeien\\backend\\dtpay\\QR\\itdatong.png").toPath();
        createQr(content,file);
    }

    /**
     * 创建普通二维码
     * @param content
     * @param file
     */
    public void createQr(String content,Path file){
        int width=500;
        int height=500;
        String format ="png";

        //定义二维码参数
        Map hashMap = new HashMap();
        hashMap.put(EncodeHintType.CHARACTER_SET,"UTF-8");
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hashMap.put(EncodeHintType.MARGIN,2);

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height);
            MatrixToImageWriter.writeToPath(bitMatrix,format,file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
