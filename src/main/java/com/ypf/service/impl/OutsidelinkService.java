package com.ypf.service.impl;

import com.ypf.entity.OutsideLink;
import com.ypf.mapper.OutsidelinkMapper;
import com.ypf.service.IOutsidelinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class OutsidelinkService implements IOutsidelinkService {

    @Autowired
    private OutsidelinkMapper outsidelinkMapper;

    //查询全部
    @Override
    public List<OutsideLink> showAllOutsidelink() {
        List<OutsideLink> list = outsidelinkMapper.showAllOutsidelink();
        return list;
    }

    //添加
    @Override
    public int addOutsidelink(OutsideLink outsideLink) {
        int mark = outsidelinkMapper.addOutsidelink(outsideLink);
        return mark;
    }

    //修改
    @Override
    public int updateOutsidelink(OutsideLink outsideLink) {
        int mark = outsidelinkMapper.updateOutsidelink(outsideLink);
        return mark;
    }

    //删除
    @Override
    public int deleteOutsidelink(int id) {
        int mark = outsidelinkMapper.deleteOutsidelink(id);
        return mark;
    }

}
