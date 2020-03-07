package com.ypf.service;

import com.ypf.entity.Article;

import java.util.List;

public interface IArticleService {

    //查询全部
    List<Article> showAllArticle();

    //添加
    int addArticle(Article article);

    //修改
    int updateArticle(Article article);

    //删除
    int deleteArticle(int id);

}
