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

    //查询全部: 审核已通过的
    @Override
    public List<Object> showAllArticle() {
        List<Object> list = articleMapper.showAllArticle();
        return list;
    }

    //查询全部: 所有状态的
    @Override
    public List<Object> showArticle() {
        List<Object> list = articleMapper.showArticle();
        return list;
    }

    //查询全部：按阅读量降序排列
    @Override
    public List<Object> showArticleOrderByView(){
        List<Object> list = articleMapper.showArticleOrderByView();
        return list;
    }

    //查询全部: 数目
    @Override
    public int showArticleNumber() {
        int number = articleMapper.showArticleNumber();
        return number;
    }

    //条件查询：按照文章id查询 所有状态的
    @Override
    public List<Object> findArticleById(int id) {
        List<Object> list = articleMapper.findArticleById(id);
        return list;
    }

    //条件查询：按照用户id查询 所有状态的
    @Override
    public List<Object> findArticleByUserId(Map<String,Object> params) {
        List<Object> list = articleMapper.findArticleByUserId(params);
        return list;
    }

    //模糊查询: 审核已通过的
    @Override
    public List<Object> fuzzyFindArticle(Map<String,Object> params) {
        List<Object> list = articleMapper.fuzzyFindArticle(params);
        return list;
    }

    //模糊查询: 所有状态的
    @Override
    public List<Object> fuzzyArticle(Map<String, Object> params) {
        List<Object> list = articleMapper.fuzzyArticle(params);
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
