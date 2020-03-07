package com.ypf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 视图文章信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private int id; //id
    private String title; //题目
    private String content; //内容
    private int userId; //作者用户id
    private Timestamp date; //上传时间
    private int viewCount; //浏览次数
    private int deleteFlag; //是否删除

}
