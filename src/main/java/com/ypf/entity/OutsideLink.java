package com.ypf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 站外链接信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutsideLink {

    private int id; //id
    private String title; //题目
    private String content; //内容
    private String link; //链接
    private String author; //发布者
    private int viewCount; //浏览次数
    private int deleteFlag; //是否删除

}
