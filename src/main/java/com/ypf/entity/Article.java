package com.ypf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",  timezone="GMT+8")
    private Timestamp date; //上传时间
    private int viewCount; //浏览次数
    private int deleteFlag; //是否删除
    private int checkStatus; //审核标志：3未通过，2通过，1审核中(默认)

}
