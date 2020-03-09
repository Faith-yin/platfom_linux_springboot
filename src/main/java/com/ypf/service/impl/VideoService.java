package com.ypf.service.impl;

import com.ypf.entity.Video;
import com.ypf.mapper.VideoMapper;
import com.ypf.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VideoService implements IVideoService {


    @Autowired
    private VideoMapper videoMapper;

    //查询全部
    @Override
    public List<Video> showAllVideo() {
        List<Video> list = videoMapper.showAllVideo();
        return list;
    }

    //条件查询：按照id查询
    @Override
    public List<Video> findVideoById(int id) {
        List<Video> list = videoMapper.findVideoById(id);
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
