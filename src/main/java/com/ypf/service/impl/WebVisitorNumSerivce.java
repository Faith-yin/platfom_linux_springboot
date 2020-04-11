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
    public WebVisitorNum findIdByNewDate() {
        WebVisitorNum webVisitorNum = webVisitorNumMapper.findIdByNewDate();
        return webVisitorNum;
    }


    //添加
    @Override
    public int addWebNum() {
        int mark = webVisitorNumMapper.addWebNum();
        return mark;
    }


    //修改
    @Override
    public int updateWebNum(int id) {
        int mark = webVisitorNumMapper.updateWebNum(id);
        return mark;
    }


}
