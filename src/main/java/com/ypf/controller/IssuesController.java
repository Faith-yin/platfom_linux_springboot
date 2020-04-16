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


    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping(value = "/showAllIssues",method = RequestMethod.POST)
    public JsonResult showAllIssues(@RequestBody Map<String,Object> params) {

        if(params.get("value") == null || params.get("value") == "") { //如果没有入参,就查询全部
            List<Object> list = issuesService.showAllIssues();
            return JsonResult.ok(list);
        } else { //如果有入参，就模糊查询
            List<Object> list1 = issuesService.fuzzyFindIssues(params);
            return JsonResult.ok(list1);
        }
    }


    /**
     * 查询全部：按阅读量降序排列
     */
    @ResponseBody
    @RequestMapping(value = "/showIssuesOrderByView",method = RequestMethod.GET)
    public JsonResult showIssuesOrderByView() {
        List<Object> list = issuesService.showIssuesOrderByView();
        return JsonResult.ok(list);
    }


    /**
     * 条件查询：根据id查询
     */
    @ResponseBody
    @RequestMapping(value = "/findIssuesById",method = RequestMethod.GET)
    public JsonResult findIssuesById(int id) {
        List<Object> list = issuesService.findIssuesById(id);
        return JsonResult.ok(list);
    }


    /**
     * 条件查询：根据提出者用户id查询
     */
    @ResponseBody
    @RequestMapping(value = "/findIssuesByUserId",method = RequestMethod.POST)
    public JsonResult findIssuesByUserId(@RequestBody Map<String,Object> params) {
        List<Object> list = issuesService.findIssuesByUserId(params);
        return JsonResult.ok(list);
    }


    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "/addIssues",method = RequestMethod.POST)
    public JsonResult addIssues(@RequestBody Issues issues) {
        int mark = issuesService.addIssues(issues);
        if(mark == 1) return JsonResult.ok();
        return JsonResult.errorMessage("操作失败");
    }


    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/updateIssues",method = RequestMethod.PUT)
    public JsonResult updateIssues(@RequestBody Issues issues) {
        int mark = issuesService.updateIssues(issues);
        if(mark == 1) {
            List<Object> list = issuesService.findIssuesById(issues.getId());
            return JsonResult.ok(list);
        }
        return JsonResult.errorMessage("操作失败");
    }


    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteIssuesById/{id}",method = RequestMethod.DELETE)
    public JsonResult deleteIssuesById(@PathVariable int id) {
        int mark = issuesService.deleteIssuesById(id);
        if(mark == 1) return JsonResult.ok();
        return JsonResult.errorMessage("操作失败");
    }

}
