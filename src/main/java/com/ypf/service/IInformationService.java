package com.ypf.service;

import com.ypf.entity.Information;

import java.util.List;

public interface IInformationService {

    //查询全部
    List<Object> showAllInformation();

    //条件查询：按照id查询
    List<Object> findInformationById(int id);

    //条件查询：按照管理员id查询
    List<Information> findInformationByAdminId(int adminId);

    //添加
    int addInformation(Information information);

    //修改
    int updateInformation(Information information);

    //删除
    int deleteInformation(int id);

}
