package com.ypf.controller;

import com.ypf.service.impl.UploadFileService;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/uploadFile")
public class UploadFileController {

    @Autowired
    private UploadFileService uploadFileService;
    private JsonResult jsonResult;


    /**
     * 视频上传服务器接口
     */
    @ResponseBody
    @RequestMapping(value = "/uploadVideo",method = RequestMethod.POST)
    private JsonResult uploadVideo(@RequestParam("file")MultipartFile file) throws Exception {
        String str = uploadFileService.videoUpload(file);
        return jsonResult.ok(str);
    }


    /**
     * 图片上传服务器接口
     */
    @ResponseBody
    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    private JsonResult uploadImg(@RequestParam("file")MultipartFile file) throws Exception {
        String str = uploadFileService.imgUpload(file);
        return jsonResult.ok(str);
    }




}
