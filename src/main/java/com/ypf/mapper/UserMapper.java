package com.ypf.mapper;

import com.ypf.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    //查询全部
    List<User> showAllUser();

    //条件查询：根据用户名称查询
    List<User> findUserByName(String username);

    //条件查询：根据用户名称 和 用户密码查询
    List<User> findUserByNameAndPassword(User user);

    //模糊查询
    List<Object> fuzzyFindUser(Map<String,Object> params);

    //添加
    int addUser(User user);

    //修改
    int updateUserById(User user);

    //修改：重置密码
    int updateUserPassword(int id);

    //删除
    int deleteUserById(int id);

}
