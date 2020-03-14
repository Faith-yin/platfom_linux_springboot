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
     * 条件查询：根据id查询
     */
    @ResponseBody
    @RequestMapping(value = "/findIssuesById",method = RequestMethod.GET)
    private JsonResult findIssuesById(int id) {
        List<Object> list = issuesService.findIssuesById(id);
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
    @RequestMapping(value = "/deleteIssuesById",method = RequestMethod.DELETE)
    private JsonResult deleteIssuesById(@RequestBody Map<String,Object> params) {
        int mark = issuesService.deleteIssuesById(params);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }

}
