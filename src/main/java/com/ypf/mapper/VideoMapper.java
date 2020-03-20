package com.ypf.mapper;

import com.ypf.entity.Video;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface VideoMapper {

    //查询全部: 审核已通过的
    List<Object> showAllVideo();

    //查询全部: 所有状态的
    List<Object> showVideo();

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
