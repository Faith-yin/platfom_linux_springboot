package com.ypf.mapper;

import com.ypf.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    //查询全部
    List<User> showAllUser();

    //条件查询：根据用户名称查询
    List<User> findUserByName(String username);

    //条件查询：根据用户名称 和 用户密码查询
    List<User> findUserByNameAndPassword(User user);

    //添加
    int addUser(User user);

    //修改
    int updateUserByName(User user);

    //删除
    int deleteUserByName(String username);

}
