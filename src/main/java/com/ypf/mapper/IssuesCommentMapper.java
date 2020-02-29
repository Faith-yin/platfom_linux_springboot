package com.ypf.mapper;


import com.ypf.entity.IssuesComment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssuesCommentMapper {

    //查询全部
    List<IssuesComment> showAllIssuesComment();

    //条件查询：根据归属问题issueId查询
    List<IssuesComment> findIssuesCommentByIssuesId(int id);

    //删除
    int deleteIssuesComment(int issueId);

}
