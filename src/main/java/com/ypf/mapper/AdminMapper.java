package com.ypf.mapper;

import com.ypf.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminMapper {

    //查询全部
    List<Admin> showAllAdmin();

    //条件查询：根据id查询
    List<Admin> findAdminById(int id);

    //条件查询：根据名称查询
    List<Admin> findAdminByName(String username);

    //模糊查询
    List<Object> fuzzyFindAdmin(Map<String,Object> value);

    //添加
    int addAdmin(Admin admin);

    //修改
    int updateAdmin(Admin admin);

    //删除
    int deleteAdmin(Map<String,Object> params);

}
