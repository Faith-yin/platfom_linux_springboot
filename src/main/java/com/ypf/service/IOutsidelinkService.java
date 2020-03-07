package com.ypf.service;

import com.ypf.entity.OutsideLink;

import java.util.List;

public interface IOutsidelinkService {

    //查询全部
    List<OutsideLink> showAllOutsidelink();

    //添加
    int addOutsidelink(OutsideLink outsideLink);

    //修改
    int updateOutsidelink(OutsideLink outsideLink);

    //删除
    int deleteOutsidelink(int id);

}
