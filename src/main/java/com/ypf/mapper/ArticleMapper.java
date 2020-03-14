package com.ypf.mapper;

import com.ypf.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface ArticleMapper {

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
