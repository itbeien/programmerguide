package cn.itbeien.util;

import cn.itbeien.config.MinioConfig;
import io.minio.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author beien
 * @date 2023-10-18 15:14
 * Copyright© 2023 beien
 */
@Component
@Slf4j
public class MinioClientUtil {
    @Autowired
    private MinioClient minioClient;

    @Autowired
    private MinioConfig minioConfig;

    private static final int DEFAULT_EXPIRY_TIME = 7 * 24 * 3600;

    /**
     * 上传文件
     * @param file
     * @param bucket
     * @return
     * @throws Exception
     */
    public String upload(MultipartFile file,String bucket) throws Exception {
        String path = file.getOriginalFilename();
        minioClient.putObject(PutObjectArgs.builder()
                // 存储桶
                .bucket(bucket)
                // 文件名
                .object(path)
                // 文件内容
                .stream(file.getInputStream(), file.getSize(), -1)
                // 文件类型
                .contentType(file.getContentType()).build());
        return String.format("上传成功: %s/%s/%s", minioConfig.getEndpoint()+":"+minioConfig.getPort(), bucket, path);
    }

    /**
     * 删除文件
     * @param path
     * @param bucket
     * @return
     * @throws Exception
     */
    public String delete(String path,String bucket) throws Exception {
        minioClient.removeObject(RemoveObjectArgs.builder()
                // 存储桶
                .bucket(bucket)
                // 文件名
                .object(path).build());
        return String.format("删除成功：%s/%s/%s", minioConfig.getEndpoint()+":"+minioConfig.getPort(), bucket, path);
    }

}
