package com.ypf.service;

import com.ypf.entity.User;

import java.util.List;

public interface IUserService {

    //查询全部
    List<User> showAllUser();

    //条件查询：根据用户名称查询
    List<User> findUserByName(String username);

    //条件查询：根据用户名称 和 用户密码查询
    List<User> findUserByNameAndPassword(User user);

    //添加
    int addUser(User user);

    //修改
    int updateUserById(User user);

    //删除
    int deleteUserById(int id);

}
