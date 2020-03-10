package com.ypf.service.impl;

import com.ypf.entity.Issues;
import com.ypf.mapper.IssuesMapper;
import com.ypf.service.IIssuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IssuesService implements IIssuesService {

    @Autowired
    private IssuesMapper issuesMapper;

    //查询全部
    @Override
    public List<Object> showAllIssues() {
        List<Object> list = issuesMapper.showAllIssues();
        return list;
    }

    //条件查询：根据id查询
    @Override
    public List<Object> findIssuesById(int id) {
        List<Object> list = issuesMapper.findIssuesById(id);
        return list;
    }

    //条件查询：根据提出者用户id查询
    @Override
    public List<Issues> findIssuesByUserId(int id) {
        List<Issues> list = issuesMapper.findIssuesByUserId(id);
        return list;
    }

    //添加
    @Override
    public int addIssues(Issues issues) {
        int mark = issuesMapper.addIssues(issues);
        return mark;
    }

    //修改
    @Override
    public int updateIssues(Issues issues) {
        int mark = issuesMapper.updateIssues(issues);
        return mark;
    }

    //删除
    @Override
    public int deleteIssuesById(int id) {
        int mark = issuesMapper.deleteIssuesById(id);
        return mark;
    }


}
