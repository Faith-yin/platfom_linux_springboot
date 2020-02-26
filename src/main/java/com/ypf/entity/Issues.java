package com.ypf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * issues问题列表信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Issues {

    private int id; //id
    private String title; //题目
    private Date date; //提出日期
    private int viewCount; //浏览次数
    private String presenter; //提出者
    private int deleteFlag; //是否删除


}
