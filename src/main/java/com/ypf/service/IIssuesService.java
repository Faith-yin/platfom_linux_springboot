package com.ypf.service;

import com.ypf.entity.Issues;

import java.util.List;
import java.util.Map;

public interface IIssuesService {

    //查询全部
    List<Object> showAllIssues();

    //条件查询：根据id查询
    List<Object> findIssuesById(int id);

    //条件查询：根据提出者用户id查询
    List<Object> findIssuesByUserId(Map<String,Object> params);

    //模糊查询
    List<Object> fuzzyFindIssues(Map<String,Object> params);

    //添加
    int addIssues(Issues issues);

    //修改
    int updateIssues(Issues issues);

    //修改：更新评论数目
    int updateIssuesCommentNum(int id);

    //删除
    int deleteIssuesById(int id);

}
