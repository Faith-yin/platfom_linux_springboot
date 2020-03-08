package com.ypf.controller;

import com.ypf.entity.Issues;
import com.ypf.service.impl.IssuesService;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/issues")
public class IssuesController {

    @Autowired
    private IssuesService issuesService;
    private JsonResult jsonResult;


    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping(value = "/showAllIssues",method = RequestMethod.GET)
    private JsonResult showAllIssues() {
        List<Issues> list = issuesService.showAllIssues();
        return jsonResult.ok(list);
    }


    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "/addIssues",method = RequestMethod.POST)
    private JsonResult addIssues(@RequestBody Issues issues) {
        int mark = issuesService.addIssues(issues);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/updateIssues",method = RequestMethod.PUT)
    private JsonResult updateIssues(@RequestBody Issues issues) {
        int mark = issuesService.updateIssues(issues);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteIssuesById",method = RequestMethod.DELETE)
    private JsonResult deleteIssuesById(int id) {
        int mark = issuesService.deleteIssuesById(id);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }

}
