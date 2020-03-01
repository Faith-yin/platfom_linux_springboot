package com.ypf.service.impl;

import com.ypf.entity.IssuesComment;
import com.ypf.mapper.IssuesCommentMapper;
import com.ypf.service.IIssuesCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IssuesCommentService implements IIssuesCommentService {

    @Autowired
    private IssuesCommentMapper issuesCommentMapper;

    //查询全部
    @Override
    public List<IssuesComment> showAllIssuesComment() {
        List<IssuesComment> list = issuesCommentMapper.showAllIssuesComment();
        return list;
    }

    //条件查询：根据归属问题issueId查询
    @Override
    public List<IssuesComment> findIssuesCommentByIssuesId(int issueId) {
        List<IssuesComment> list = issuesCommentMapper.findIssuesCommentByIssuesId(issueId);
        return list;
    }

    //添加
    @Override
    public int addIssuesComment(IssuesComment issuesComment) {
        int mark = issuesCommentMapper.addIssuesComment(issuesComment);
        return mark;
    }

    //删除
    @Override
    public int deleteIssuesComment(int id) {
        int mark = issuesCommentMapper.deleteIssuesComment(id);
        return mark;
    }


}
