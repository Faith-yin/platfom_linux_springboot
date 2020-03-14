package com.ypf.service.impl;

import com.ypf.entity.Article;
import com.ypf.mapper.ArticleMapper;
import com.ypf.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    //查询全部
    @Override
    public List<Object> showAllArticle() {
        List<Object> list = articleMapper.showAllArticle();
        return list;
    }

    //条件查询：根据id查询
    @Override
    public List<Object> findArticleById(int id) {
        List<Object> list = articleMapper.findArticleById(id);
        return list;
    }

    //模糊查询
    @Override
    public List<Object> fuzzyFindArticle(Map<String,Object> params) {
        List<Object> list = articleMapper.fuzzyFindArticle(params);
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
    public int deleteArticle(Map<String,Object> params) {
        int mark = articleMapper.deleteArticle(params);
        return mark;
    }

}
