package com.ypf.service.impl;

import com.ypf.util.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件上传服务器
 */
@Service
public class UploadFileService {

    @Value("${fastdfs_ip}")
    private String fastdfs_ip;


    // 视频上传服务器
    public String videoUpload(MultipartFile file) {
        String result = "";
        String fileType = file.getContentType();
        if(fileType.equals("video/mp4")) {
            if(file != null && file.getSize() > 0) {
                String filename = file.getOriginalFilename();
                String extname = filename.substring(filename.lastIndexOf(".")+1);
                FastDFSClient client = new FastDFSClient("classpath:/client.cfg");
                try {
                    String path = client.uploadFile(file.getBytes(),extname);
                    result = fastdfs_ip+path;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }


    //图片上传服务器
    public String imgUpload(MultipartFile file) {
        String result = "";
        String fileType = file.getContentType();
        if(fileType.equals("image/png") || fileType.equals("image/jpeg") || fileType.equals("image/jpg")) {
            if(file != null && file.getSize() > 0) {
                String filename = file.getOriginalFilename();
                String extname = filename.substring(filename.lastIndexOf(".")+1);
                FastDFSClient client = new FastDFSClient("classpath:/client.cfg");
                try {
                    String path = client.uploadFile(file.getBytes(),extname);
                    result = fastdfs_ip+path;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }



}
