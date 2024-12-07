package cn.itbeien.common.util.qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 */
@Slf4j
public class QrcodeUtil {

    private final static String FILE_FORMAT = "png";

    /**
     * 输出到指定路径
     */
    public static void createQrCodeToPath(BitMatrix bitMatrix, Path path) throws IOException {
        MatrixToImageWriter.writeToPath(bitMatrix, FILE_FORMAT, path);
        log.info("createQrCodeToPath ok...");
    }


    /**
     * 输出到指定路径
     */
    public static void createQrCodeToPath(BitMatrix bitMatrix, Path path, Color front,Color background) throws IOException {
        MatrixToImageConfig config = new MatrixToImageConfig(front.getRGB(), background.getRGB());
        MatrixToImageWriter.writeToPath(bitMatrix, FILE_FORMAT, path,config);
        log.info("createQrCodeToPath ok...");
    }

    /**
     * 输出到流
     */
    public static void createQrCodeToStream(BitMatrix bitMatrix, OutputStream stream) throws IOException {
        MatrixToImageWriter.writeToStream(bitMatrix, FILE_FORMAT, stream);
        log.info("createQrCodeTo ok...");
    }

    /**
     * 输出到流
     */
    public static void createQrCodeToStream(BitMatrix bitMatrix, OutputStream stream,Color front,Color background) throws IOException {
        MatrixToImageConfig config = new MatrixToImageConfig(front.getRGB(), background.getRGB());
        MatrixToImageWriter.writeToStream(bitMatrix, FILE_FORMAT, stream,config);
        log.info("createQrCodeTo ok...");
    }

    /**
     * 创建附带本地路径的logo的二维码，到指定路径
     * @throws IOException
     */
    public static void createLogoQrCodeToPath(BitMatrix bitMatrix,Path codePath,Path logoPath)throws IOException{
        MatrixToImageWriterWithLogo.writeToPath(bitMatrix,FILE_FORMAT,codePath,logoPath);
    }

    /**
     * 创建附带url路径的logo的二维码，到指定路径
     * @throws IOException
     */
    public static void createLogoQrCodeToPath(BitMatrix bitMatrix, Path codePath, URL logoUrl)throws IOException{
        MatrixToImageWriterWithLogo.writeToPath(bitMatrix,FILE_FORMAT,codePath,logoUrl);
    }


    /**
     * 创建附带本地路径的logo的二维码，到输出流
     */
    public static void createLogoQrCodeToStream(BitMatrix bitMatrix,OutputStream os,Path logoPath)throws IOException{
        MatrixToImageWriterWithLogo.writeToStream(bitMatrix,FILE_FORMAT,os,logoPath);
    }

    /**
     * 创建附带本地路径的logo的二维码，到指定路径
     */
    public static void createLogoQrCodeToPath(BitMatrix bitMatrix,Path codePath,Path logoPath,Color front,Color background)throws IOException{
        MatrixToImageConfig config = new MatrixToImageConfig(front.getRGB(), background.getRGB());
        MatrixToImageWriterWithLogo.writeToPath(bitMatrix,FILE_FORMAT,codePath,logoPath,config);
    }

    /**
     * 创建附带url路径的logo的二维码，到指定路径
     */
    public static void createLogoQrCodeToPath(BitMatrix bitMatrix, Path codePath, URL logoUrl, Color front, Color background)throws IOException{
        MatrixToImageConfig config = new MatrixToImageConfig(front.getRGB(), background.getRGB());
        MatrixToImageWriterWithLogo.writeToPath(bitMatrix,FILE_FORMAT,codePath,logoUrl,config);
    }

    /**
     * 创建附带本地路径的logo的二维码，到输出流
     */
    public static void createLogoQrCodeToStream(BitMatrix bitMatrix,OutputStream os,Path logoPath,Color front,Color background)throws IOException{
        MatrixToImageConfig config = new MatrixToImageConfig(front.getRGB(), background.getRGB());
        MatrixToImageWriterWithLogo.writeToStream(bitMatrix,FILE_FORMAT,os,logoPath,config);
    }


    /**
     *
     * @param content 二维码中的内容
     * @param file 图片存储的磁盘路径
     *  http://www.csdn.net
     *  对应的是注册商户，跳转支付H5页面的controller中方法的地址
     *             (域名或者IP需要能外网访问)
     * http://883l1832q6.vicp.fun/system/route?code=10001
     *
     *
     */
    public static void createQr(String content,Path file){
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
            log.error("创建二维码异常:",e);
        }
    }


    /**
     * 批量创建二维码
     * @param content 二维码中的内容
     * @param file 图片存储的磁盘路径
     *  http://www.csdn.net
     *  对应的是注册商户，跳转支付H5页面的controller中方法的地址
     *             (域名或者IP需要能外网访问)
     * http://883l1832q6.vicp.fun/system/route?code=10001
     *
     *
     */
    public static void createBatchQr(String content,Path file,Integer number){
        int width=500;
        int height=500;
        String format ="png";

        //定义二维码参数
        Map hashMap = new HashMap();
        hashMap.put(EncodeHintType.CHARACTER_SET,"UTF-8");
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hashMap.put(EncodeHintType.MARGIN,2);

        try {
            for(int i=0;i<number;i++){
                BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height);
                MatrixToImageWriter.writeToPath(bitMatrix,format,file);
            }
        }catch (Exception e){
            log.error("创建二维码异常:",e);
        }
    }

}
