package com.ypf.mapper;

import com.ypf.entity.OutsideLink;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutsidelinkMapper {

    //查询全部
    List<OutsideLink> showAllOutsidelink();

    //添加
    int addOutsidelink(OutsideLink outsideLink);

    //修改
    int updateOutsidelink(OutsideLink outsideLink);

    //删除
    int deleteOutsidelink(int id);

}
