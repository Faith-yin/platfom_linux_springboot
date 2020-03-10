package com.ypf.mapper;

import com.ypf.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {

    //查询全部
    List<Admin> showAllAdmin();

    //条件查询：根据id查询
    List<Admin> findAdminById(int id);

    //条件查询：根据名称查询
    List<Admin> findAdminByName(String username);

    //添加
    int addAdmin(Admin admin);

}
