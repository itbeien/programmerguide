package cn.itbeien.common.util.qr;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 */
public class BitMatrixBuilder {
    /**
     * 具体内容
     */
    private String content;

    /**
     * 宽度，像素
     */
    private int widthPx = 300;

    /**
     * 高度，像素
     */
    private int heightPx = 300;

    /**
     * 编码
     */
    private Charset charset = StandardCharsets.UTF_8;

    /**
     * 纠错等级，等级越高存储信息越少
     */
    private ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.M;

    /**
     * 边距
     */
    private int margin = 2;

    public static BitMatrixBuilder customer() {
        return new BitMatrixBuilder();
    }

    public BitMatrix build() {
        HashMap<EncodeHintType, Object> hits = new HashMap<>(4);
        hits.put(EncodeHintType.CHARACTER_SET, charset);
        //纠错等级，纠错等级越高存储信息越少
        hits.put(EncodeHintType.ERROR_CORRECTION, errorCorrectionLevel);
        //边距
        hits.put(EncodeHintType.MARGIN, margin);
        try {
            return new MultiFormatWriter().encode(this.content,
                    BarcodeFormat.QR_CODE, this.widthPx, this.heightPx, hits);
        } catch (WriterException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static BitMatrixDefault create(){
        return new BitMatrixDefault();
    }

    public BitMatrixBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public BitMatrixBuilder setWidthPx(int widthPx) {
        this.widthPx = widthPx;
        return this;
    }

    public BitMatrixBuilder setHeightPx(int heightPx) {
        this.heightPx = heightPx;
        return this;
    }

    public BitMatrixBuilder setCharset(Charset charset) {
        this.charset = charset;
        return this;
    }

    public BitMatrixBuilder setErrorCorrectionLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        this.errorCorrectionLevel = errorCorrectionLevel;
        return this;
    }

    public BitMatrixBuilder setMargin(int margin) {
        this.margin = margin;
        return this;
    }



    public static class BitMatrixDefault{
        private String content;

        public BitMatrixDefault setContent(String s){
            this.content = s;
            return this;
        }

        public BitMatrix build() {
            return new BitMatrixBuilder().setContent(this.content).build();
        }
    }
}
