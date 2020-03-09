package com.ypf.mapper;

import com.ypf.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleMapper {

    //查询全部
    List<Article> showAllArticle();

    //条件查询：按照id查询
    List<Article> findArticleById(int id);

    //添加
    int addArticle(Article article);

    //修改
    int updateArticle(Article article);

    //删除
    int deleteArticle(int id);

}
