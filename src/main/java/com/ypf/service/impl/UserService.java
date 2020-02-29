package com.ypf.service.impl;

import com.ypf.entity.User;
import com.ypf.mapper.UserMapper;
import com.ypf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    //查询全部
    @Override
    public List<User> showAllUser() {
        List<User> list = userMapper.showAllUser();
        return list;
    }

    //条件查询：根据用户名称查询
    @Override
    public List<User> findUserByName(String username) {
        List<User> list = userMapper.findUserByName(username);
        return list;
    }

    //条件查询：根据用户名称 和 用户密码查询
    public List<User> findUserByNameAndPassword(User user) {
        List<User> list = userMapper.findUserByNameAndPassword(user);
        return list;
    }

    //添加
    @Override
    public int addUser(User user) {
        int mark = userMapper.addUser(user);
        return mark;
    }

    //修改
    @Override
    public int updateUserByName(User user) {
        int mark = userMapper.updateUserByName(user);
        return mark;
    }

    //删除
    @Override
    public int deleteUserById(int id) {
        int mark = userMapper.deleteUserById(id);
        return mark;
    }

}
