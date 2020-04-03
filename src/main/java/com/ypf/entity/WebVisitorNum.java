package com.ypf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @Author: 殷鹏飞
 * @Date: 2020/4/3 10:04
 * @Decription: 网站访问量信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebVisitorNum {

    private int id; //id
    @JsonFormat(pattern = "yyyy-MM-dd",  timezone="GMT+8")
    private Timestamp date; //日期
    private int viewCount; //访问次数

}
