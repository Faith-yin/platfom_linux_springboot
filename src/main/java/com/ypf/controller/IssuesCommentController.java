package com.ypf.controller;

import com.ypf.entity.IssuesComment;
import com.ypf.service.impl.IssuesCommentService;
import com.ypf.service.impl.IssuesService;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/issuesComment")
public class IssuesCommentController {

    @Autowired
    private IssuesCommentService issuesCommentService;
    private JsonResult jsonResult;


    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping(value = "/showAllIssuesComment",method = RequestMethod.POST)
    private JsonResult showAllIssuesComment(@RequestBody Map<String,Object> params) {
        if(params.get("value") == null || params.get("value") == "") { //如果没有入参,就查询全部
            List<Object> list = issuesCommentService.showAllIssuesComment();
            return jsonResult.ok(list);
        } else { //如果有入参，就模糊查询
            List<Object> list1 = issuesCommentService.fuzzyFindIssuesComment(params);
            return jsonResult.ok(list1);
        }
    }


    /**
     * 条件查询：根据归属问题issueId查询
     */
    @ResponseBody
    @RequestMapping(value = "/findIssuesCommentByIssuesId/{issueId}",method = RequestMethod.POST)
    private JsonResult findIssuesCommentByIssuesId(@PathVariable("issueId") int issueId) {
        List<Object> list = issuesCommentService.findIssuesCommentByIssuesId(issueId);
        return jsonResult.ok(list);
    }


    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "/addIssuesComment",method = RequestMethod.POST)
    private JsonResult addIssuesComment(@RequestBody IssuesComment issuesComment) {
        int mark = issuesCommentService.addIssuesComment(issuesComment);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/updateIssuesComment",method = RequestMethod.PUT)
    private JsonResult updateIssuesComment(@RequestBody IssuesComment issuesComment) {
        int mark = issuesCommentService.updateIssuesComment(issuesComment);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }



    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteIssuesComment",method = RequestMethod.DELETE)
    private JsonResult deleteIssuesComment(@RequestBody Map<String,Object> params) {
        int mark = issuesCommentService.deleteIssuesComment(params);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }



}
