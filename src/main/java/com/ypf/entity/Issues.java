package com.ypf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * issues问题列表信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Issues {

    private int id; //id
    private String title; //题目
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",  timezone="GMT+8")
    private Timestamp date; //提出时间
    private int viewCount; //浏览次数
    private int userId; //提出者用户id
    private int deleteFlag; //是否删除


}
