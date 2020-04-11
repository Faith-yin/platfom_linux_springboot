package com.ypf.controller;

import com.ypf.entity.User;
import com.ypf.service.impl.UserService;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private WebVisitorNumController webVisitorNumController;
    private JsonResult jsonResult;



    /**
     * 查询全部
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showAllUser",method = RequestMethod.POST)
    private JsonResult showAllUser(@RequestBody Map<String,Object> params) {
        if(params.get("value") == null || params.get("value") == "") { //如果没有入参,就查询全部
            List<User> list = userService.showAllUser();
            return jsonResult.ok(list);
        } else { //如果有入参，就模糊查询
            List<Object> list1 = userService.fuzzyFindUser(params);
            return jsonResult.ok(list1);
        }
    }


    /**
     * 条件查询：根据用户名称 和 用户密码查询
     */
    @ResponseBody
    @RequestMapping(value = "/findUserByNameAndPassword",method = RequestMethod.POST)
    private JsonResult findUserByNameAndPassword(@RequestBody User user) {
        List<User> list = userService.findUserByNameAndPassword(user);
        //检验查询的用户名和密码是否已注册
        //未注册时：
        if(list == null || list.isEmpty()) return jsonResult.errorMessage("用户名或密码输入错误");
        //已注册：添加访问量+1
        Boolean mark = webVisitorNumController.updateWebNumById();
        if (mark) return jsonResult.ok(list);
        return jsonResult.errorMessage("增加访问量出错");

    }


    /**
     * 添加
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    private JsonResult addUser(@RequestBody User user) {
        //校验要修改的用户名称是否已存在
        List<User> list = userService.findUserByName(user.getUsername());
        if(list != null && !list.isEmpty()) return jsonResult.errorMessage("该名称已存在");
        //不存在时
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
    @RequestMapping(value = "/updateUserById",method = RequestMethod.PUT)
    private JsonResult updateUserById(@RequestBody User user) {
        //校验要修改的用户名称是否已存在
        List<User> list = userService.findUserByName(user.getUsername());
        if(list != null && !list.isEmpty()) return jsonResult.errorMessage("该名称已存在");
        //不存在时
        int mark = userService.updateUserById(user);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 修改：重置密码
     */
    @ResponseBody
    @RequestMapping(value = "/updateUserPassword/{id}",method = RequestMethod.PUT)
    private JsonResult updateUserPassword(@PathVariable int id) {
        int mark = userService.updateUserPassword(id);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteUserById/{id}",method = RequestMethod.DELETE)
    private JsonResult deleteUserById(@PathVariable int id) {
        int mark = userService.deleteUserById(id);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }

}
