package com.ypf.controller;

import com.ypf.entity.Admin;
import com.ypf.service.impl.AdminService;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    @RequestMapping(value = "/showAllAdmin",method = RequestMethod.GET)
    private JsonResult showAllAdmin() {
        List<Admin> list = adminService.showAllAdmin();
        return JsonResult.ok(list);
    }


    /**
     * 添加
     * @param admin
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addAdmin",method = RequestMethod.POST)
    private JsonResult addAdmin(Admin admin) {
        List<Admin> list = adminService.findAdminByName(admin.getUsername());
        if(list != null && !list.isEmpty()) return jsonResult.errorMessage("该名称已存在");
        //要添加的此管理员名称在表中不存在
        int mark = adminService.addAdmin(admin);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }

}
