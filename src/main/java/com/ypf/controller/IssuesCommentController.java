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
    @Autowired
    private IssuesService issuesService;


    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping(value = "/showAllIssuesComment",method = RequestMethod.POST)
    public JsonResult showAllIssuesComment(@RequestBody Map<String,Object> params) {
        if(params.get("value") == null || params.get("value") == "") { //如果没有入参,就查询全部
            List<Object> list = issuesCommentService.showAllIssuesComment();
            return JsonResult.ok(list);
        } else { //如果有入参，就模糊查询
            List<Object> list1 = issuesCommentService.fuzzyFindIssuesComment(params);
            return JsonResult.ok(list1);
        }
    }


    /**
     * 条件查询：根据归属问题issueId查询
     */
    @ResponseBody
    @RequestMapping(value = "/findIssuesCommentByIssuesId/{issueId}",method = RequestMethod.POST)
    public JsonResult findIssuesCommentByIssuesId(@PathVariable("issueId") int issueId) {
        List<Object> list = issuesCommentService.findIssuesCommentByIssuesId(issueId);
        return JsonResult.ok(list);
    }


    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "/addIssuesComment",method = RequestMethod.POST)
    public JsonResult addIssuesComment(@RequestBody IssuesComment issuesComment) {
        //添加评论
        int mark = issuesCommentService.addIssuesComment(issuesComment);
        if(mark == 1) {
            //更新对应issue问题下评论数目 +1
            int mark1 = issuesService.updateIssuesCommentNum(issuesComment.getIssueId());
            if(mark1 == 1) {
                return JsonResult.ok();
            }
        }
        return JsonResult.errorMessage("操作失败");
    }


    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/updateIssuesComment",method = RequestMethod.PUT)
    public JsonResult updateIssuesComment(@RequestBody IssuesComment issuesComment) {
        int mark = issuesCommentService.updateIssuesComment(issuesComment);
        if(mark == 1) return JsonResult.ok();
        return JsonResult.errorMessage("操作失败");
    }



    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteIssuesComment/{id}",method = RequestMethod.DELETE)
    public JsonResult deleteIssuesComment(@PathVariable int id) {
        int mark = issuesCommentService.deleteIssuesComment(id);
        if(mark == 1) return JsonResult.ok();
        return JsonResult.errorMessage("操作失败");
    }



}
