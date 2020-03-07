package com.ypf.controller;

import com.ypf.entity.Article;
import com.ypf.service.impl.ArticleService;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    private JsonResult jsonResult;


    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping(value = "/showAllArticle",method = RequestMethod.GET)
    private JsonResult showAllArticle() {
        List<Article> list = articleService.showAllArticle();
        return jsonResult.ok(list);
    }


    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
    private JsonResult addArticle(Article article) {
        int mark = articleService.addArticle(article);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/updateArticle",method = RequestMethod.PUT)
    private JsonResult updateArticle(Article article) {
        int mark = articleService.updateArticle(article);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteArticle",method = RequestMethod.DELETE)
    private JsonResult deleteArticle(int id) {
        int mark = articleService.deleteArticle(id);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }

}
