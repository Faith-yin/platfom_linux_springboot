package com.ypf.service;

import com.ypf.entity.Article;

import java.util.List;
import java.util.Map;

public interface IArticleService {

    //查询全部
    List<Object> showAllArticle();

    //条件查询：按照id查询
    List<Object> findArticleById(int id);

    //模糊查询
    List<Object> fuzzyFindArticle(Map<String,Object> params);

    //添加
    int addArticle(Article article);

    //修改
    int updateArticle(Article article);

    //删除
    int deleteArticle(Map<String,Object> params);

}
