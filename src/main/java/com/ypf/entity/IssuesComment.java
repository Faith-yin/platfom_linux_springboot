package com.ypf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * issues问题评论信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssuesComment {

    private int id; //id
    private int issueId; //issue问题id
    private int userId; //评论者用户id
    private Timestamp date; //评论日期
    private String content; //评论内容
    private int deleteFlag; //是否删除

}
