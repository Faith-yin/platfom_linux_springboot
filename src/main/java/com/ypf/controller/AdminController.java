package com.ypf.controller;

import com.ypf.entity.Admin;
import com.ypf.service.impl.AdminService;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    private JsonResult jsonResult;

    /**
     * 查询全部
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showAllAdmin",method = RequestMethod.POST)
    private JsonResult showAllAdmin(@RequestBody Map<String,Object> params) {
        if(params.get("value") == null || params.get("value") == "") { //如果没有入参,就查询全部
            List<Admin> list = adminService.showAllAdmin();
            return jsonResult.ok(list);
        } else { //如果有入参，就模糊查询
            List<Object> list1 = adminService.fuzzyFindAdmin(params);
            return jsonResult.ok(list1);
        }
    }


    /**
     * 添加
     * @param admin
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addAdmin",method = RequestMethod.POST)
    private JsonResult addAdmin(@RequestBody Admin admin) {
        List<Admin> list = adminService.findAdminByName(admin.getUsername());
        if(list != null && !list.isEmpty()) return jsonResult.errorMessage("该名称已存在");
        //要添加的此管理员名称在表中不存在
        int mark = adminService.addAdmin(admin);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/updateAdmin",method = RequestMethod.PUT)
    private JsonResult updateAdmin(@RequestBody Admin admin) {
        int mark = adminService.updateAdmin(admin);
        if(mark == 1) {
            List<Admin> list = adminService.findAdminById(admin.getId());
            return jsonResult.ok(list);
        }
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAdmin",method = RequestMethod.DELETE)
    private JsonResult deleteAdmin(@RequestBody Map<String,Object> params) {
        int mark = adminService.deleteAdmin(params);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }




}
