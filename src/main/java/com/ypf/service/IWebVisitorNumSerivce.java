package com.ypf.service;

import com.ypf.entity.WebVisitorNum;

import java.util.List;
import java.util.Map;

/**
 * @Author: 殷鹏飞
 * @Date: 2020/4/3 10:20
 * @Decription: 网站访问量信息
 */
public interface IWebVisitorNumSerivce {

    //查询全部
    List<Object> showAllWebNum();

    //查找最新日期的数据
    WebVisitorNum findIdByNewDate();

    //添加
    int addWebNum();

    //修改
    int updateWebNum(int id);

}
