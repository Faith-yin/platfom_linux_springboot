package com.ypf.controller;

import com.ypf.entity.Admin;
import com.ypf.entity.Information;
import com.ypf.service.impl.AdminService;
import com.ypf.service.impl.InformationService;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private InformationService informationService;


    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping(value = "/showAllInformation",method = RequestMethod.POST)
    public JsonResult showAllInformation(@RequestBody Map<String,Object> params) {
        if(params.get("value") == null || params.get("value") == "") { //如果没有入参,就查询全部
            List<Object> list = informationService.showAllInformation();
            return JsonResult.ok(list);
        } else { //如果有入参，就模糊查询
            List<Object> list1 = informationService.fuzzyFindInformation(params);
            return JsonResult.ok(list1);
        }
    }


    /**
     *条件查询：按照id查询
     */
    @ResponseBody
    @RequestMapping(value = "/findInformationById",method = RequestMethod.GET)
    public JsonResult findInformationById(int id) {
        List<Object> list = informationService.findInformationById(id);
        return JsonResult.ok(list);
    }


    /**
     * 条件查询：按照管理员id查询
     */
    @ResponseBody
    @RequestMapping(value = "/findInformationByAdminId",method = RequestMethod.POST)
    public JsonResult findInformationByAdminId(int adminId) {
        List<Information> list = informationService.findInformationByAdminId(adminId);
        return JsonResult.ok(list);
    }


    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "/addInformation",method = RequestMethod.POST)
    public JsonResult addInformation(@RequestBody Information information) {
        int mark = informationService.addInformation(information);
        if(mark == 1) return JsonResult.ok();
        return JsonResult.errorMessage("操作失败");
    }


    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/updateInformation",method = RequestMethod.PUT)
    public JsonResult updateInformation(@RequestBody Information information) {
        int mark = informationService.updateInformation(information);
        if(mark == 1) {
            List<Object> list = informationService.findInformationById(information.getId());
            return JsonResult.ok(list);
        }
        return JsonResult.errorMessage("操作失败");
    }


    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteInformation/{id}",method = RequestMethod.DELETE)
    public JsonResult deleteInformation(@PathVariable("id") int id) {
        int mark = informationService.deleteInformation(id);
        if(mark == 1) return JsonResult.ok();
        return JsonResult.errorMessage("操作失败");
    }


}
