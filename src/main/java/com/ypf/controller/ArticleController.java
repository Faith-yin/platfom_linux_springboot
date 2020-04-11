package com.ypf.controller;

import com.ypf.entity.Article;
import com.ypf.service.impl.ArticleService;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    private JsonResult jsonResult;


    /**
     * 查询全部: 审核已通过的
     */
    @ResponseBody
    @RequestMapping(value = "/showAllArticle",method = RequestMethod.POST)
    private JsonResult showAllArticle(@RequestBody Map<String,Object> params) {
        if(params.get("value") == null || params.get("value") == "") { //如果没有入参,就查询全部
            List<Object> list = articleService.showAllArticle();
            return jsonResult.ok(list);
        } else { //如果有入参，就模糊查询
            List<Object> list1 = articleService.fuzzyFindArticle(params);
            return jsonResult.ok(list1);
        }
    }


    /**
     * 查询全部: 所有状态的
     */
    @ResponseBody
    @RequestMapping(value = "/showArticle",method = RequestMethod.POST)
    private JsonResult showArticle(@RequestBody Map<String,Object> params) {
        if(params.get("value") == null || params.get("value") == "") { //如果没有入参,就查询全部
            List<Object> list = articleService.showArticle();
            return jsonResult.ok(list);
        } else { //如果有入参，就模糊查询
            List<Object> list1 = articleService.fuzzyArticle(params);
            return jsonResult.ok(list1);
        }
    }


    /**
     * 查询全部：按阅读量降序排列
     */
    @ResponseBody
    @RequestMapping(value = "/showArticleOrderByView",method = RequestMethod.GET)
    private JsonResult showArticleOrderByView() {
        List<Object> list = articleService.showArticleOrderByView();
        return jsonResult.ok(list);
    }


    /**
     * 条件查询：按照文章id查询 所有状态的
     */
    @ResponseBody
    @RequestMapping(value = "/findArticleById",method = RequestMethod.POST)
    private JsonResult findArticleById(int id) {
        List<Object> list = articleService.findArticleById(id);
        return jsonResult.ok(list);
    }


    /**
     * 条件查询：按照用户id查询 所有状态的
     */
    @ResponseBody
    @RequestMapping(value = "/findArticleByUserId",method = RequestMethod.POST)
    private JsonResult findArticleByUserId(@RequestBody Map<String,Object> params) {
        List<Object> list = articleService.findArticleByUserId(params);
        return jsonResult.ok(list);
    }


    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
    private JsonResult addArticle(@RequestBody Article article) {
        int mark = articleService.addArticle(article);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/updateArticle",method = RequestMethod.PUT)
    private JsonResult updateArticle(@RequestBody Article article) {
        int mark = articleService.updateArticle(article);
        if(mark == 1) {
            List<Object> list = articleService.findArticleById(article.getId());
            return jsonResult.ok(list);
        }
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteArticle/{id}",method = RequestMethod.DELETE)
    private JsonResult deleteArticle(@PathVariable int id) {
        int mark = articleService.deleteArticle(id);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


}
