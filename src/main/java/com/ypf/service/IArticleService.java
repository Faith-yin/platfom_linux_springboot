package com.ypf.service;

import com.ypf.entity.Article;

import java.util.List;
import java.util.Map;

public interface IArticleService {

    //查询全部: 审核已通过的
    List<Object> showAllArticle();

    //查询全部: 所有状态的
    List<Object> showArticle();

    //查询全部：按阅读量降序排列
    List<Object> showArticleOrderByView();

    //查询全部: 数目
    int showArticleNumber();

    //条件查询：按照文章id查询 所有状态的
    List<Object> findArticleById(int id);

    //条件查询：按照用户id查询 所有状态的
    List<Object> findArticleByUserId(Map<String,Object> params);

    //模糊查询: 审核已通过的
    List<Object> fuzzyFindArticle(Map<String,Object> params);

    //模糊查询: 所有状态的
    List<Object> fuzzyArticle(Map<String,Object> params);

    //添加
    int addArticle(Article article);

    //修改
    int updateArticle(Article article);

    //删除
    int deleteArticle(int id);

}
