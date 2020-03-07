package com.ypf.mapper;

import com.ypf.entity.Information;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationMapper {

    //查询全部
    List<Information> showAllInformation();

    //条件查询：按照管理员id查询
    List<Information> findInformationByAdminId(int adminId);

    //添加
    int addInformation(Information information);

    //修改
    int updateInformation(Information information);

    //删除
    int deleteInformation(int id);


}