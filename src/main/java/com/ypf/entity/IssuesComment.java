package com.ypf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * issues问题评论信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssuesComment {

    private int id; //id
    private int issueId; //issue问题id
    private String username; //评论用户名
    private String date; //评论日期
    private String content; //评论内容

}
