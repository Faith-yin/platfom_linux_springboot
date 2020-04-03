package com.ypf.controller;

import com.ypf.service.impl.*;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 殷鹏飞
 * @Date: 2020/4/3 13:43
 * @Decription: 查询每个表中的数据总计条数
 */
@Controller
@RequestMapping("/findTableTotal")
public class FindTableTotal {

    @Autowired
    private InformationService informationService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private IssuesService issuesService;
    @Autowired
    private OutsidelinkService outsidelinkService;
    private JsonResult jsonResult;

    /**
     * 总计数目
     */
    @ResponseBody
    @RequestMapping(value = "/findTotal",method = RequestMethod.GET)
    private JsonResult findTotal() {
        int informationNumber = informationService.showInformationNumber();
        int articleNumber = articleService.showArticleNumber();
        int videoNumber = videoService.showVideoNumber();
        int issuesNumber = issuesService.showIssuesNumber();
        int outsidelinkNumber = outsidelinkService.showOutsidelinkNumber();
        //定义list集合
        List<Map<Object, Object>> list = new ArrayList<>();
        //定义text数组
        String[] arrText = {"公告","文章","课程视频","Issues","站外学习链接"};
        //定义value数组
        int[] arrValue = {informationNumber,articleNumber,videoNumber,issuesNumber,outsidelinkNumber};
        for (int i= 0; i < 5; i++) {
            //定义map集合
            Map<Object,Object> map = new HashMap<>();
            map.put("text",arrText[i]);
            map.put("number",arrValue[i]);
            list.add(map);
        }
        return jsonResult.ok(list);

//        map.put("公告",informationNumber);
//        map.put("文章",articleNumber);
//        map.put("课程视频",videoNumber);
//        map.put("Issues",issuesNumber);
//        map.put("站外学习链接",outsidelinkNumber);
//        List<Object> list = new ArrayList<Object>();
//        return jsonResult.ok(map);


    }










}
