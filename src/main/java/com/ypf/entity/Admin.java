package com.ypf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
