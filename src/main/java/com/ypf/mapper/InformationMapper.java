package com.ypf.mapper;

import com.ypf.entity.Information;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InformationMapper {

    //查询全部
    List<Object> showAllInformation();

    //条件查询：按照id查询
    List<Object> findInformationById(int id);

    //条件查询：按照管理员id查询
    List<Information> findInformationByAdminId(int adminId);

    //模糊查询
    List<Object> fuzzyFindInformation(Map<String,Object> params);

    //添加
    int addInformation(Information information);

    //修改
    int updateInformation(Information information);

    //删除
    int deleteInformation(Map<String,Object> params);


}
