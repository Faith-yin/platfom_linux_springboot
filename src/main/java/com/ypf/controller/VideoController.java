package com.ypf.controller;

import com.ypf.entity.Video;
import com.ypf.service.impl.VideoService;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/video")
public class VideoController {


    @Autowired
    private VideoService videoService;
    private JsonResult jsonResult;


    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping(value = "/showAllVideo",method = RequestMethod.POST)
    private JsonResult showAllVideo(@RequestBody Map<String,Object> params) {
        if(params.get("value") == null || params.get("value") == "") { //如果没有入参,就查询全部
            List<Object> list = videoService.showAllVideo();
            return jsonResult.ok(list);
        } else { //如果有入参，就模糊查询
            List<Object> list1 = videoService.fuzzyFindVideo(params);
            return jsonResult.ok(list1);
        }
    }


    /**
     * 条件查询：按照id查询
     */
    @ResponseBody
    @RequestMapping(value = "/findVideoById",method = RequestMethod.GET)
    private JsonResult findVideoById(int id) {
        List<Object> list = videoService.findVideoById(id);
        return jsonResult.ok(list);
    }


    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "/addVideo",method = RequestMethod.POST)
    private JsonResult addVideo(@RequestBody Video video) {
        int mark = videoService.addVideo(video);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/updateVideo",method = RequestMethod.PUT)
    private JsonResult updateVideo(@RequestBody Video video) {
        int mark = videoService.updateVideo(video);
        if(mark == 1) {
            List<Object> list = videoService.findVideoById(video.getId());
            return jsonResult.ok(list);
        }
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteVideo",method = RequestMethod.DELETE)
    private JsonResult deleteVideo(@RequestBody Map<String,Object> params) {
        int mark = videoService.deleteVideo(params);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }




}
