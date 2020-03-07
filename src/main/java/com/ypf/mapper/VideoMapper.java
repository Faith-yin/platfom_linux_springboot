package com.ypf.mapper;

import com.ypf.entity.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {

    //查询全部
    List<Video> showAllVideo();

    //添加
    int addVideo(Video video);

    //修改
    int updateVideo(Video video);

    //删除
    int deleteVideo(int id);

}