package com.ypf.service.impl;

import com.ypf.entity.Admin;
import com.ypf.mapper.AdminMapper;
import com.ypf.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    //添加
    @Override
    public int addAdmin(Admin admin) {
        int mark = adminMapper.addAdmin(admin);
        return mark;
    }

}
