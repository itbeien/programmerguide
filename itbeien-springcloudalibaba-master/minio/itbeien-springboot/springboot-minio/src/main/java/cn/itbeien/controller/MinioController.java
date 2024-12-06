package cn.itbeien.controller;

import cn.itbeien.config.MinioConfig;
import cn.itbeien.util.MinioClientUtil;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author beien
 * @date 2023-10-18 15:52
 * Copyright© 2023 beien
 */
@RestController
@RequestMapping("/file")
public class MinioController {

    @Autowired
    private MinioClientUtil minioClientUtil;

    /**
     * 上传文件
     * @param file
     * @param bucket
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, @RequestParam("bucket") String bucket) throws Exception {
        String path = minioClientUtil.upload(file,bucket);
        return path;
    }

    /**
     * 删除文件
     * @param path
     * @param bucket
     * @return
     * @throws Exception
     */
    @DeleteMapping("/delete")
    public String delete(@RequestParam("path") String path, @RequestParam("bucket") String bucket) throws Exception {
        String result = minioClientUtil.delete(path,bucket);
        return result;
    }
}
