package com.ypf.mapper;

import com.ypf.entity.IssuesComment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IssuesCommentMapper {

    //查询全部
    List<Object> showAllIssuesComment();

    //条件查询：根据归属问题issueId查询
    List<Object> findIssuesCommentByIssuesId(int issueId);

    //模糊查询
    List<Object> fuzzyFindIssuesComment(Map<String,Object> params);

    //添加
    int addIssuesComment(IssuesComment issuesComment);

    //修改
    int updateIssuesComment(IssuesComment issuesComment);

    //删除
    int deleteIssuesComment(int id);

}
