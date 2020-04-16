package com.ypf.controller;

import com.ypf.entity.Admin;
import com.ypf.service.impl.AdminService;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 查询全部
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showAllAdmin",method = RequestMethod.POST)
    public JsonResult showAllAdmin(@RequestBody Map<String,Object> params) {
        if((int) params.get("id") == 1000) { //如果是超级管理员，返回全部管理员信息
            if(params.get("value") == null || params.get("value") == "") { //如果没有入参,就查询全部
                List<Admin> list = adminService.showAllAdmin();
                return JsonResult.ok(list);
            } else { //如果有入参，就模糊查询
                List<Admin> list1 = adminService.fuzzyFindAdmin(params);
                return JsonResult.ok(list1);
            }
        } else { //如果不是超级管理员，只返回当前管理员信息
            if(params.get("value") == null || params.get("value") == "") { //如果没有入参,就查询全部
                List<Admin> list2 = adminService.findAdminById((int) params.get("id"));
                return JsonResult.ok(list2);
            } else { //如果有入参，就模糊查询
                List<Admin> list3 = adminService.fuzzyFindTheAdmin(params);
                return JsonResult.ok(list3);
            }
        }

    }


    /**
     * 条件查询: 根据管理员id查询
     */
    @ResponseBody
    @RequestMapping(value = "/findAdminById",method = RequestMethod.POST)
    private JsonResult findAdminById() {
        return JsonResult.ok();
    }


    /**
     * 条件查询：根据名称 和 密码查询
     */
    @ResponseBody
    @RequestMapping(value = "/findAdminByNameAndPassword",method = RequestMethod.POST)
    public JsonResult findAdminByNameAndPassword(@RequestBody Admin admin) {
        List<Admin> list = adminService.findAdminByNameAndPassword(admin);
        //检验查询的用户名和密码是否已注册
        //未注册时：
        if(list == null || list.isEmpty()) return JsonResult.errorMessage("管理员名称或密码输入错误");
        //已注册：
        return JsonResult.ok(list);
    }


    /**
     * 添加
     * @param admin
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addAdmin",method = RequestMethod.POST)
    public JsonResult addAdmin(@RequestBody Admin admin) {
        List<Admin> list = adminService.findAdminByName(admin.getUsername());
        if(list != null && !list.isEmpty()) return JsonResult.errorMessage("该名称已存在");
        //要添加的此管理员名称在表中不存在
        int mark = adminService.addAdmin(admin);
        if(mark == 1) return JsonResult.ok();
        return JsonResult.errorMessage("操作失败");
    }


    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/updateAdmin",method = RequestMethod.PUT)
    public JsonResult updateAdmin(@RequestBody Admin admin) {
        //校验要修改的用户名称是否已存在
        List<Admin> list = adminService.findAdminByName(admin.getUsername());
        if(list != null && !list.isEmpty()) return JsonResult.errorMessage("该名称已存在");
        //不存在时
        int mark = adminService.updateAdmin(admin);
        if(mark == 1) return JsonResult.ok();
        return JsonResult.errorMessage("操作失败");


    }


    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAdmin/{id}",method = RequestMethod.DELETE)
    public JsonResult deleteAdmin(@PathVariable int id) {
        int mark = adminService.deleteAdmin(id);
        if(mark == 1) return JsonResult.ok();
        return JsonResult.errorMessage("操作失败");
    }




}
