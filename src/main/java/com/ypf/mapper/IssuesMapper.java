package com.ypf.mapper;

import com.ypf.entity.Issues;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IssuesMapper {

    //查询全部
    List<Object> showAllIssues();

    //条件查询：根据id查询
    List<Object> findIssuesById(int id);

    //条件查询：根据提出者用户id查询
    List<Issues> findIssuesByUserId(int id);

    //模糊查询
    List<Object> fuzzyFindIssues(Map<String,Object> params);

    //添加
    int addIssues(Issues issues);

    //修改
    int updateIssues(Issues issues);

    //删除
    int deleteIssuesById(Map<String,Object> params);

}
