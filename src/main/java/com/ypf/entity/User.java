package com.ypf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * 普通用户信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id; //用户id
    private String username; //用户名称
    private String password; //用户密码
    private String sex; //用户性别
    @JsonFormat(pattern = "yyyy-MM-dd",  timezone="GMT+8")
    private Date birthday; //用户生日
    private String description; //用户描述
    private int deleteFlag; //是否删除
    private String photo; //用户头像

}
