package com.ypf.controller;

import com.ypf.entity.Video;
import com.ypf.service.impl.VideoService;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/video")
public class VideoController {


    @Autowired
    private VideoService videoService;


    /**
     * 查询全部: 审核已通过的
     */
    @ResponseBody
    @RequestMapping(value = "/showAllVideo",method = RequestMethod.POST)
    public JsonResult showAllVideo(@RequestBody Map<String,Object> params) {
        if(params.get("value") == null || params.get("value") == "") { //如果没有入参,就查询全部
            List<Object> list = videoService.showAllVideo();
            return JsonResult.ok(list);
        } else { //如果有入参，就模糊查询
            List<Object> list1 = videoService.fuzzyFindVideo(params);
            return JsonResult.ok(list1);
        }
    }


    /**
     * 查询全部: 所有状态的
     */
    @ResponseBody
    @RequestMapping(value = "/showVideo",method = RequestMethod.POST)
    public JsonResult showVideo(@RequestBody Map<String,Object> params) {
        if(params.get("value") == null || params.get("value") == "") { //如果没有入参,就查询全部
            List<Object> list = videoService.showVideo();
            return JsonResult.ok(list);
        } else { //如果有入参，就模糊查询
            List<Object> list1 = videoService.fuzzyVideo(params);
            return JsonResult.ok(list1);
        }
    }


    /**
     * 查询全部：按阅读量降序排列
     */
    @ResponseBody
    @RequestMapping(value = "/showVideoOrderByView",method = RequestMethod.GET)
    public JsonResult showVideoOrderByView() {
        List<Object> list = videoService.showVideoOrderByView();
        return JsonResult.ok(list);
    }


    /**
     * 条件查询：按照video id查询 所有状态的
     */
    @ResponseBody
    @RequestMapping(value = "/findVideoById",method = RequestMethod.GET)
    public JsonResult findVideoById(int id) {
        List<Object> list = videoService.findVideoById(id);
        return JsonResult.ok(list);
    }


    /**
     * 条件查询：按照user id查询 所有状态的
     */
    @ResponseBody
    @RequestMapping(value = "/findVideoByUserId",method = RequestMethod.POST)
    public JsonResult findVideoByUserId(@RequestBody Map<String,Object> params) {
        List<Object> list = videoService.findVideoByUserId(params);
        return JsonResult.ok(list);
    }


    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "/addVideo",method = RequestMethod.POST)
    public JsonResult addVideo(@RequestBody Video video) {
        int mark = videoService.addVideo(video);
        if(mark == 1) return JsonResult.ok();
        return JsonResult.errorMessage("操作失败");
    }


    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/updateVideo",method = RequestMethod.PUT)
    public JsonResult updateVideo(@RequestBody Video video) {
        int mark = videoService.updateVideo(video);
        if(mark == 1) {
            List<Object> list = videoService.findVideoById(video.getId());
            return JsonResult.ok(list);
        }
        return JsonResult.errorMessage("操作失败");
    }


    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteVideo/{id}",method = RequestMethod.DELETE)
    public JsonResult deleteVideo(@PathVariable int id) {
        int mark = videoService.deleteVideo(id);
        if(mark == 1) return JsonResult.ok();
        return JsonResult.errorMessage("操作失败");
    }




}
