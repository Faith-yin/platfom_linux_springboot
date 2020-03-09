package com.ypf.service;

import com.ypf.entity.Issues;

import java.util.List;

public interface IIssuesService {

    //查询全部
    List<Issues> showAllIssues();

    //条件查询：根据id查询
    List<Issues> findIssuesById(int id);

    //条件查询：根据提出者用户id查询
    List<Issues> findIssuesByUserId(int id);

    //添加
    int addIssues(Issues issues);

    //修改
    int updateIssues(Issues issues);

    //删除
    int deleteIssuesById(int id);

}
