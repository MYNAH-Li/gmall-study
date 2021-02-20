package com.mynah.gmall.product.controller;


import com.mynah.gmall.common.result.Result;
import org.apache.commons.io.FilenameUtils;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("admin/product")
public class UploadFileController {


    @Value(value = "${img.url}")
    private String imgUrl;

    @PostMapping("fileUpload")
    public Result fileUpload(MultipartFile file) throws Exception{


        //获取文件的绝对路径
        String path = ClassUtils.getDefaultClassLoader().
                getResource("fdfs_client.comnf").getPath();
        //1、运用全局客户端传入配置文件
        ClientGlobal.init(path);

        //2、上传连接请求
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();

        //3、链接存储节点storage
        StorageClient1 storageClient1 = new StorageClient1(trackerServer,null);

        //4、上传文件
        String s = storageClient1.upload_file1
                (file.getBytes(), FilenameUtils.getExtension(file.getOriginalFilename()),null);

        return Result.ok(imgUrl + s);
    }
}
