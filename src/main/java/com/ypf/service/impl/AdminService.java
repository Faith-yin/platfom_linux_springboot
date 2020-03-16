package com.ypf.service.impl;

import com.ypf.entity.Admin;
import com.ypf.mapper.AdminMapper;
import com.ypf.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdminService implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    //查询全部
    @Override
    public List<Admin> showAllAdmin() {
        List<Admin> list = adminMapper.showAllAdmin();
        return list;
    }

    //条件查询：根据id查询
    @Override
    public List<Admin> findAdminById(int id) {
        List<Admin> list = adminMapper.findAdminById(id);
        return list;
    }

    //条件查询：根据名称查询
    @Override
    public List<Admin> findAdminByName(String username) {
        List<Admin> list = adminMapper.findAdminByName(username);
        return list;
    }

    //条件查询：根据名称 和 密码查询
    @Override
    public List<Admin> findAdminByNameAndPassword(Admin admin) {
        List<Admin> list = adminMapper.findAdminByNameAndPassword(admin);
        return list;
    }


    //模糊查询
    @Override
    public List<Object> fuzzyFindAdmin(Map<String,Object> value) {
        List<Object> list = adminMapper.fuzzyFindAdmin(value);
        return list;
    }


    //添加
    @Override
    public int addAdmin(Admin admin) {
        int mark = adminMapper.addAdmin(admin);
        return mark;
    }


    //修改
    @Override
    public int updateAdmin(Admin admin) {
        int mark = adminMapper.updateAdmin(admin);
        return mark;
    }


    //删除
    @Override
    public int deleteAdmin(Map<String,Object> params) {
        int mark = adminMapper.deleteAdmin(params);
        return mark;
    }


}
