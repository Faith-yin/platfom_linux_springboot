package com.ypf.controller;

import com.ypf.entity.User;
import com.ypf.service.impl.UserService;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    private JsonResult jsonResult;


    /**
     * 查询全部
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showAllUser",method = RequestMethod.GET)
    private JsonResult list() {
        List<User> list = userService.showAllUser();
        return jsonResult.ok(list);
    }


    /**
     * 添加
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    private JsonResult addUser(User user) {
        //校验要修改的用户名称是否已存在
        List<User> list = userService.findUserByName(user.getUsername());
        if(list != null && !list.isEmpty()) return jsonResult.errorMessage("该名称已存在");
        int mark = userService.addUser(user);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 修改
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateUserByName",method = RequestMethod.PUT)
    private JsonResult updateUserByName(User user) {
        //校验要修改的用户名称是否已存在
        List<User> list = userService.findUserByName(user.getUsername());
        if(list != null && !list.isEmpty()) return jsonResult.errorMessage("该名称已存在");
        int mark = userService.updateUserByName(user);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 删除
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteUserByName",method = RequestMethod.DELETE)
    private JsonResult deleteUserByName(String username) {
        int mark = userService.deleteUserByName(username);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }

}
