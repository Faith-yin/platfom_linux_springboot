package com.ypf.service;

import com.ypf.entity.Video;

import java.util.List;
import java.util.Map;

public interface IVideoService {

    //查询全部: 审核已通过的
    List<Object> showAllVideo();

    //查询全部: 所有状态的
    List<Object> showVideo();

    //查询全部：按阅读量降序排列
    List<Object> showVideoOrderByView();

    //查询全部: 数目
    int showVideoNumber();

    //条件查询：按照video id查询 所有状态的
    List<Object> findVideoById(int id);

    //条件查询：按照user id查询 所有状态的
    List<Object> findVideoByUserId(Map<String,Object> params);

    //模糊查询: 审核已通过的
    List<Object> fuzzyFindVideo(Map<String,Object> params);

    //模糊查询: 所有状态的
    List<Object> fuzzyVideo(Map<String,Object> params);

    //添加
    int addVideo(Video video);

    //修改
    int updateVideo(Video video);

    //删除
    int deleteVideo(int id);

}
