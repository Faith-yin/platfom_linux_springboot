package com.ypf.service;

import com.ypf.entity.Admin;

import java.util.List;
import java.util.Map;

public interface IAdminService {

    //查询全部
    List<Admin> showAllAdmin();

    //条件查询：根据id查询
    List<Admin> findAdminById(int id);

    //条件查询：根据名称查询
    List<Admin> findAdminByName(String username);

    //条件查询：根据名称 和 密码查询
    List<Admin> findAdminByNameAndPassword(Admin admin);

    //模糊查询
    List<Admin> fuzzyFindAdmin(Map<String,Object> value);

    //模糊查询: 当前管理员信息
    List<Admin> fuzzyFindTheAdmin(Map<String,Object> value);

    //添加
    int addAdmin(Admin admin);

    //修改
    int updateAdmin(Admin admin);

    //删除
    int deleteAdmin(int id);

}
