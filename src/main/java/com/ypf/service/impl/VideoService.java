package com.ypf.service.impl;

import com.ypf.entity.Video;
import com.ypf.mapper.VideoMapper;
import com.ypf.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class VideoService implements IVideoService {


    @Autowired
    private VideoMapper videoMapper;

    //查询全部: 审核已通过的
    @Override
    public List<Object> showAllVideo() {
        List<Object> list = videoMapper.showAllVideo();
        return list;
    }

    //查询全部: 所有状态的
    @Override
    public List<Object> showVideo() {
        List<Object> list = videoMapper.showVideo();
        return list;
    }

    //查询全部：按阅读量降序排列
    @Override
    public List<Object> showVideoOrderByView(){
        List<Object> list = videoMapper.showVideoOrderByView();
        return list;
    }

    //查询全部: 数目
    @Override
    public int showVideoNumber() {
        int number = videoMapper.showVideoNumber();
        return number;
    }

    //条件查询：按照video id查询 所有状态的
    @Override
    public List<Object> findVideoById(int id) {
        List<Object> list = videoMapper.findVideoById(id);
        return list;
    }

    //条件查询：按照user id查询 所有状态的
    public List<Object> findVideoByUserId(Map<String,Object> params) {
        List<Object> list = videoMapper.findVideoByUserId(params);
        return list;
    }

    //模糊查询: 审核已通过的
    @Override
    public List<Object> fuzzyFindVideo(Map<String,Object> params) {
        List<Object> list = videoMapper.fuzzyFindVideo(params);
        return list;
    }

    //模糊查询: 所有状态的
    @Override
    public List<Object> fuzzyVideo(Map<String,Object> params) {
        List<Object> list = videoMapper.fuzzyVideo(params);
        return list;
    }

    //添加
    @Override
    public int addVideo(Video video) {
        int mark = videoMapper.addVideo(video);
        return mark;
    }

    //修改
    @Override
    public int updateVideo(Video video) {
        int mark = videoMapper.updateVideo(video);
        return mark;
    }

    //删除
    @Override
    public int deleteVideo(int id) {
        int mark = videoMapper.deleteVideo(id);
        return mark;
    }



}
