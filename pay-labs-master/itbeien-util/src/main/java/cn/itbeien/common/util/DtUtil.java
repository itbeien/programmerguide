package cn.itbeien.common.util;

import java.util.Random;
import java.util.UUID;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
public class DtUtil {

    public static String uuid(){
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        String uuidNoHyphenStr = uuidStr.replaceAll("-", "");
        return uuidNoHyphenStr;
    }

    public static Integer random(){
        Random random = new Random();
        int randomNumber = 100000 + random.nextInt(900000); // 生成一个6位数，范围在100000到999999之间
        return randomNumber;
    }
}
