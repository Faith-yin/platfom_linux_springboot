package com.ypf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 最新信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Information {

    private int id; //id
    private String title; //题目
    private String content; //内容
    private int adminId; //发布者管理员id
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",  timezone="GMT+8")
    private Timestamp date; //上传日期
    private int viewCount; //浏览次数
    private int deleteFlag; //是否删除

}
