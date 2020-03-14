package com.ypf.service;

import com.ypf.entity.Video;

import java.util.List;
import java.util.Map;

public interface IVideoService {

    //查询全部
    List<Object> showAllVideo();

    //条件查询：按照id查询
    List<Object> findVideoById(int id);

    //模糊查询
    List<Object> fuzzyFindVideo(Map<String,Object> params);

    //添加
    int addVideo(Video video);

    //修改
    int updateVideo(Video video);

    //删除
    int deleteVideo(Map<String,Object> params);

}
