package cn.itbeien.common.util.qr;

import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 */
public class MatrixToImageWriterWithLogo {
    private static final MatrixToImageConfig config = new MatrixToImageConfig();

    private MatrixToImageWriterWithLogo() {
    }

    public static BufferedImage toBufferedImage(BitMatrix matrix,MatrixToImageConfig config) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y,  (matrix.get(x, y) ? config.getPixelOnColor() : config.getPixelOffColor()));
            }
        }
        return image;
    }

    public static void writeToPath(BitMatrix matrix, String format, Path path, Path logoPath) throws IOException {
        OutputStream os = new FileOutputStream(path.toFile());
        writeToStream(matrix,format,os,logoPath,config);
    }


    public static void writeToPath(BitMatrix matrix, String format, Path path, Path logoPath, MatrixToImageConfig config) throws IOException {
        OutputStream os = new FileOutputStream(path.toFile());
        writeToStream(matrix,format,os,logoPath,config);
    }

    public static void writeToPath(BitMatrix matrix, String format, Path path, URL logoUrl) throws IOException {
        OutputStream os = new FileOutputStream(path.toFile());
        writeToStream(matrix,format,os,logoUrl,config);
    }

    public static void writeToPath(BitMatrix matrix, String format, Path path, URL logoUrl,MatrixToImageConfig config) throws IOException {
        OutputStream os = new FileOutputStream(path.toFile());
        writeToStream(matrix,format,os,logoUrl,config);
    }


    public static void writeToStream(BitMatrix matrix, String format, OutputStream stream, Path logoPath) throws IOException {
        writeToStream(matrix, format, stream, logoPath,config);
    }


    public static void writeToStream(BitMatrix matrix, String format, OutputStream stream, Path logoPath,MatrixToImageConfig config) throws IOException {
        BufferedImage image = toBufferedImage(matrix,config);
        //设置logo图标
        BufferedImage bi = ImageIO.read(logoPath.toFile());
        image = logoMatrix(image,bi);

        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }

    public static void writeToStream(BitMatrix matrix, String format, OutputStream stream, URL logoUrl) throws IOException {
        writeToStream(matrix,format,stream,logoUrl,config);
    }


    public static void writeToStream(BitMatrix matrix, String format, OutputStream stream, URL logoUrl,MatrixToImageConfig config) throws IOException {
        BufferedImage image = toBufferedImage(matrix,config);
        //设置logo图标
        BufferedImage bi = ImageIO.read(logoUrl);
        image = logoMatrix(image,bi);

        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }


    /**
     * 设置 logo
     * @param matrixImage 源二维码图片
     * @return 返回带有logo的二维码图片
     */
    private static BufferedImage logoMatrix(BufferedImage matrixImage, BufferedImage logo) {
        //读取二维码图片，并构建绘图对象
        Graphics2D g2 = matrixImage.createGraphics();

        int matrixWidth = matrixImage.getWidth();
        int matrixHeigh = matrixImage.getHeight();

        //绘制
        g2.drawImage(logo, matrixWidth / 5 * 2, matrixHeigh / 5 * 2, matrixWidth / 5, matrixHeigh / 5, null);
        BasicStroke stroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        // 设置笔画对象
        g2.setStroke(stroke);
        //指定弧度的圆角矩形
        RoundRectangle2D.Float round = new RoundRectangle2D.Float(matrixWidth / 5 * 2, matrixHeigh / 5 * 2, matrixWidth / 5, matrixHeigh / 5, 20, 20);
        g2.setColor(Color.white);
        // 绘制圆弧矩形
        g2.draw(round);

        //设置logo 有一道灰色边框
        BasicStroke stroke2 = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        // 设置笔画对象
        g2.setStroke(stroke2);
        RoundRectangle2D.Float round2 = new RoundRectangle2D.Float(matrixWidth / 5 * 2 + 2, matrixHeigh / 5 * 2 + 2, matrixWidth / 5 - 4, matrixHeigh / 5 - 4, 20, 20);
        g2.setColor(new Color(128, 128, 128));
        // 绘制圆弧矩形
        g2.draw(round2);
        g2.dispose();
        matrixImage.flush();
        return matrixImage;
    }
}


