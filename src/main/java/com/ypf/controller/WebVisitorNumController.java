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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    @RequestMapping(value = "/webVisitorNum",method = RequestMethod.GET)
    public Boolean updateWebNumById() {
        //判断当前表中最新日期字段是否今天日期
        WebVisitorNum webVisitorNum = webVisitorNumSerivce.findIdByNewDate();
        if (webVisitorNum == null) {
            //最新日期不是今天: 添加
            int mark = webVisitorNumSerivce.addWebNum();
            if (mark == 1) return true;
            return false;
        }
        //最新日期是今天：更新viewCount +1
        int mark1 = webVisitorNumSerivce.updateWebNum(webVisitorNum.getId());
        if (mark1 == 1) return true;
        return false;
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
