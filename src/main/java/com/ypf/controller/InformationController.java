package com.ypf.controller;

import com.ypf.entity.Admin;
import com.ypf.entity.Information;
import com.ypf.service.impl.AdminService;
import com.ypf.service.impl.InformationService;
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
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private InformationService informationService;
    @Autowired
    private AdminService adminService;
    private JsonResult jsonResult;


    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping(value = "/showAllInformation",method = RequestMethod.POST)
    private JsonResult showAllInformation(@RequestBody Map<String,Object> params) {
        System.out.println("入参是-->"+params.get("value"));
        if(params.get("value") == null || params.get("value") == "") { //如果没有入参,就查询全部
            List<Object> list = informationService.showAllInformation();
            return jsonResult.ok(list);
        } else { //如果有入参，就模糊查询
            List<Object> list1 = informationService.fuzzyFindInformation(params);
            return jsonResult.ok(list1);
        }

    }


    /**
     *条件查询：按照id查询
     */
    @ResponseBody
    @RequestMapping(value = "/findInformationById",method = RequestMethod.GET)
    private JsonResult findInformationById(int id) {
        List<Object> list = informationService.findInformationById(id);
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
        if(mark == 1) {
            List<Object> list = informationService.findInformationById(information.getId());
            return jsonResult.ok(list);
        }
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
