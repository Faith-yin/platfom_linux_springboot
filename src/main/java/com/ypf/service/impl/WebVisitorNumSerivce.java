package com.ypf.service.impl;

import com.ypf.entity.WebVisitorNum;
import com.ypf.mapper.WebVisitorNumMapper;
import com.ypf.service.IWebVisitorNumSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: 殷鹏飞
 * @Date: 2020/4/3 10:22
 * @Decription: 网站访问量信息
 */
@Service
@Transactional
public class WebVisitorNumSerivce implements IWebVisitorNumSerivce {

    @Autowired
    private WebVisitorNumMapper webVisitorNumMapper;


    //查询全部
    @Override
    public List<Object> showAllWebNum() {
        List<Object> list = webVisitorNumMapper.showAllWebNum();
        return list;
    }


    //查找最新日期的数据
    @Override
    public List<Object> findIdByNewDate() {
        List<Object> list = webVisitorNumMapper.findIdByNewDate();
        return list;
    }


    //添加
    @Override
    public int addWebNum(WebVisitorNum webVisitorNum) {
        int mark = webVisitorNumMapper.addWebNum(webVisitorNum);
        return mark;
    }


    //修改
    @Override
    public int updateWebNum(WebVisitorNum webVisitorNum) {
        int mark = webVisitorNumMapper.updateWebNum(webVisitorNum);
        return mark;
    }


}
