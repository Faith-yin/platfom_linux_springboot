package com.ypf.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ypf.entity.Issues;
import com.ypf.service.impl.IssuesService;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @RequestMapping(value = "/showAllIssues",method = RequestMethod.POST)
    private JsonResult showAllIssues(@RequestBody Map<String,Object> params) {

        if(params.get("value") == null || params.get("value") == "") { //如果没有入参,就查询全部
            List<Object> list = issuesService.showAllIssues();
            return jsonResult.ok(list);
        } else { //如果有入参，就模糊查询
            List<Object> list1 = issuesService.fuzzyFindIssues(params);
            return jsonResult.ok(list1);
        }
    }


    /**
     * 查询全部：按阅读量降序排列
     */
    @ResponseBody
    @RequestMapping(value = "/showIssuesOrderByView",method = RequestMethod.GET)
    private JsonResult showIssuesOrderByView() {
        List<Object> list = issuesService.showIssuesOrderByView();
        return jsonResult.ok(list);
    }


    /**
     * 条件查询：根据id查询
     */
    @ResponseBody
    @RequestMapping(value = "/findIssuesById",method = RequestMethod.GET)
    private JsonResult findIssuesById(int id) {
        List<Object> list = issuesService.findIssuesById(id);
        return jsonResult.ok(list);
    }


    /**
     * 条件查询：根据提出者用户id查询
     */
    @ResponseBody
    @RequestMapping(value = "/findIssuesByUserId",method = RequestMethod.POST)
    private JsonResult findIssuesByUserId(@RequestBody Map<String,Object> params) {
        List<Object> list = issuesService.findIssuesByUserId(params);
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
        if(mark == 1) {
            List<Object> list = issuesService.findIssuesById(issues.getId());
            return jsonResult.ok(list);
        }
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteIssuesById/{id}",method = RequestMethod.DELETE)
    private JsonResult deleteIssuesById(@PathVariable int id) {
        int mark = issuesService.deleteIssuesById(id);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }

}
