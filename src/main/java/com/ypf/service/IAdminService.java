package com.ypf.service;

import com.ypf.entity.Admin;

import java.util.List;

public interface IAdminService {

    //查询全部
    List<Admin> showAllAdmin();

    //条件查询：根据名称查询
    List<Admin> findAdminByName(String username);

    //添加
    int addAdmin(Admin admin);

}
