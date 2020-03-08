package com.ypf.controller;

import com.ypf.entity.IssuesComment;
import com.ypf.service.impl.IssuesCommentService;
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
@RequestMapping("/issuesComment")
public class IssuesCommentController {

    @Autowired
    private IssuesCommentService issuesCommentService;
    private JsonResult jsonResult;


    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping(value = "/showAllIssuesComment",method = RequestMethod.GET)
    private JsonResult showAllIssuesComment() {
        List<IssuesComment> list = issuesCommentService.showAllIssuesComment();
        return jsonResult.ok(list);
    }


    /**
     * 条件查询：根据归属问题issueId查询
     */
    @ResponseBody
    @RequestMapping(value = "/findIssuesCommentByIssuesId",method = RequestMethod.POST)
    private JsonResult findIssuesCommentByIssuesId(int issueId) {
        List<IssuesComment> list = issuesCommentService.findIssuesCommentByIssuesId(issueId);
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
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteIssuesComment",method = RequestMethod.DELETE)
    private JsonResult deleteIssuesComment(int id) {
        int mark = issuesCommentService.deleteIssuesComment(id);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }



}
