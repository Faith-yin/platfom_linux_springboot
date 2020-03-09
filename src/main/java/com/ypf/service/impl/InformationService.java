package com.ypf.service.impl;

import com.ypf.entity.Information;
import com.ypf.mapper.InformationMapper;
import com.ypf.service.IInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InformationService implements IInformationService {

    @Autowired
    private InformationMapper informationMapper;

    //查询全部
    @Override
    public List<Information> showAllInformation() {
        List<Information> list = informationMapper.showAllInformation();
        return list;
    }

    //条件查询：按照id查询
    @Override
    public  List<Information> findInformationById(int id) {
        List<Information> list = informationMapper.findInformationById(id);
        return list;
    }

    //条件查询：按照管理员id查询
    @Override
    public List<Information> findInformationByAdminId(int adminId) {
        List<Information> list = informationMapper.findInformationByAdminId(adminId);
        return list;
    }

    //添加
    @Override
    public int addInformation(Information information) {
        int mark = informationMapper.addInformation(information);
        return mark;
    }

    //修改
    @Override
    public int updateInformation(Information information) {
        int mark = informationMapper.updateInformation(information);
        return mark;
    }

    //删除
    @Override
    public int deleteInformation(int id) {
        int mark = informationMapper.deleteInformation(id);
        return mark;
    }


}
