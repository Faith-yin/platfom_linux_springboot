package com.ypf.mapper;

import com.ypf.entity.WebVisitorNum;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: 殷鹏飞
 * @Date: 2020/4/3 10:15
 * @Decription: 网站访问量信息
 */
@Repository
public interface WebVisitorNumMapper {

    //查询全部
    List<Object> showAllWebNum();

    //查找最新日期的数据
    List<Object> findIdByNewDate();


    //添加
    int addWebNum(WebVisitorNum webVisitorNum);

    //修改
    int updateWebNum(WebVisitorNum webVisitorNum);

}
