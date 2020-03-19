package com.ypf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 管理员信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    private int id; //id
    private String username; //名称
    private String password; //密码
    private String photo; //头像
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",  timezone="GMT+8")
    private Timestamp lastLoginTime; //最后登录时间

}
