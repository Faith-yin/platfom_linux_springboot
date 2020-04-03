package com.ypf.mapper;

import com.ypf.entity.OutsideLink;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OutsidelinkMapper {

    //查询全部
    List<Object> showAllOutsidelink();

    //查询全部: 数目
    int showOutsidelinkNumber();

    //条件查询：按照id查询
    List<Object> findOutsidelinkById(int id);

    //模糊查询
    List<Object> fuzzyFindOutsidelink(Map<String,Object> params);

    //添加
    int addOutsidelink(OutsideLink outsideLink);

    //修改
    int updateOutsidelink(OutsideLink outsideLink);

    //删除
    int deleteOutsidelink(int id);

}
