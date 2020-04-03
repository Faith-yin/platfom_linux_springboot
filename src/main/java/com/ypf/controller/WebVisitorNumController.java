package com.ypf.controller;

import com.alibaba.fastjson.JSON;
import com.ypf.entity.WebVisitorNum;
import com.ypf.service.impl.WebVisitorNumSerivce;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author: 殷鹏飞
 * @Date: 2020/4/3 10:27
 * @Decription: 网站访问量信息
 */
@Controller
@RequestMapping("/webVisitorNum")
public class WebVisitorNumController {

    @Autowired
    private WebVisitorNumSerivce webVisitorNumSerivce;
    private JsonResult jsonResult;


    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping(value = "/showAllWebNum",method = RequestMethod.GET)
    private JsonResult showAllWebNum() {
        List<Object> list = webVisitorNumSerivce.showAllWebNum();
        return jsonResult.ok(list);
    }


    /**
     * 更新数据viewCount访问量字段 +1
     */
    @ResponseBody
    @RequestMapping(value = "/updateWebNumById",method = RequestMethod.POST)
    private JsonResult updateWebNumById(@RequestBody WebVisitorNum webVisitorNum) {
        //判断当前表中最新日期字段是否今天日期
        List<Object> list = webVisitorNumSerivce.findIdByNewDate();
        if (list == null || list.size() ==0 ) {
            //最新日期不是今天: 添加
            int mark = webVisitorNumSerivce.addWebNum(webVisitorNum);
            if (mark == 1) return jsonResult.ok();
            return jsonResult.errorMessage("操作失败");
        }
        //最新日期是今天：更新viewCount +1
        int mark1 = webVisitorNumSerivce.updateWebNum((WebVisitorNum) list.get(0));
        if (mark1 == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }



//    /**
//     * 添加
//     */
//    @ResponseBody
//    @RequestMapping(value = "/addWebNum",method = RequestMethod.POST)
//    private JsonResult addWebNum(@RequestBody WebVisitorNum webVisitorNum) {
//        int mark = webVisitorNumSerivce.addWebNum(webVisitorNum);
//        if(mark == 1) return jsonResult.ok();
//        return jsonResult.errorMessage("操作失败");
//    }
//
//
//    /**
//     * 修改
//     */
//    @ResponseBody
//    @RequestMapping(value = "/updateWebNum",method = RequestMethod.PUT)
//    private JsonResult updateWebNum(@RequestBody WebVisitorNum webVisitorNum) {
//        int mark = webVisitorNumSerivce.updateWebNum(webVisitorNum);
//        if (mark == 1) return jsonResult.ok();
//        return jsonResult.errorMessage("操作失败");
//    }







}
