package com.ypf.service.impl;

import com.ypf.entity.Article;
import com.ypf.mapper.ArticleMapper;
import com.ypf.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    //查询全部
    @Override
    public List<Article> showAllArticle() {
        List<Article> list = articleMapper.showAllArticle();
        return list;
    }

    //条件查询
    @Override
    public List<Article> findArticleById(int id) {
        List<Article> list = articleMapper.findArticleById(id);
        return list;
    }

    //添加
    @Override
    public int addArticle(Article article) {
        int mark = articleMapper.addArticle(article);
        return mark;
    }

    //修改
    @Override
    public int updateArticle(Article article) {
        int mark = articleMapper.updateArticle(article);
        return mark;
    }

    //删除
    @Override
    public int deleteArticle(int id) {
        int mark = articleMapper.deleteArticle(id);
        return mark;
    }

}
