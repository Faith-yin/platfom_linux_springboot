package com.ypf.controller;

import com.ypf.entity.OutsideLink;
import com.ypf.service.impl.OutsidelinkService;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/outsidelink")
public class OutsidelinkController {

    @Autowired
    private OutsidelinkService outsidelinkService;
    private JsonResult jsonResult;


    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping(value = "/showAllOutsidelink",method = RequestMethod.GET)
    private JsonResult showAllOutsidelink() {
        List<OutsideLink> list = outsidelinkService.showAllOutsidelink();
        return jsonResult.ok(list);
    }


    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "/addOutsidelink",method = RequestMethod.POST)
    private JsonResult addOutsidelink(OutsideLink outsideLink) {
        int mark = outsidelinkService.addOutsidelink(outsideLink);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/updateOutsidelink",method = RequestMethod.PUT)
    private JsonResult updateOutsidelink(OutsideLink outsideLink) {
        int mark = outsidelinkService.updateOutsidelink(outsideLink);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOutsidelink",method = RequestMethod.DELETE)
    private JsonResult deleteOutsidelink(int id) {
        int mark = outsidelinkService.deleteOutsidelink(id);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }



}