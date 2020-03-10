package com.ypf.service;

import com.ypf.entity.Issues;
import com.ypf.entity.IssuesComment;

import java.util.List;

public interface IIssuesCommentService {

    //查询全部
    List<Object> showAllIssuesComment();

    //条件查询：根据归属问题issueId查询
    List<Object> findIssuesCommentByIssuesId(int issueId);

    //添加
    int addIssuesComment(IssuesComment issuesComment);

    //删除
    int deleteIssuesComment(int id);

}
