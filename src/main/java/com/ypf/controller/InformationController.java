package com.ypf.controller;

import com.ypf.entity.Information;
import com.ypf.service.impl.InformationService;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private InformationService informationService;
    private JsonResult jsonResult;


    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping(value = "/showAllInformation",method = RequestMethod.GET)
    private JsonResult showAllInformation() {
        List<Information> list = informationService.showAllInformation();
        return jsonResult.ok(list);
    }


    /**
     * 条件查询：按照管理员id查询
     */
    @ResponseBody
    @RequestMapping(value = "/findInformationByAdminId",method = RequestMethod.POST)
    private JsonResult findInformationByAdminId(int adminId) {
        List<Information> list = informationService.findInformationByAdminId(adminId);
        return jsonResult.ok(list);
    }


    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "/addInformation",method = RequestMethod.POST)
    private JsonResult addInformation(@RequestBody Information information) {
        int mark = informationService.addInformation(information);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/updateInformation",method = RequestMethod.PUT)
    private JsonResult updateInformation(@RequestBody Information information) {
        int mark = informationService.updateInformation(information);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteInformation",method = RequestMethod.DELETE)
    private JsonResult deleteInformation(int id) {
        int mark = informationService.deleteInformation(id);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


}
