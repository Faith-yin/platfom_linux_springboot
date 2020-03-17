package com.ypf.controller;

import com.ypf.entity.OutsideLink;
import com.ypf.service.impl.OutsidelinkService;
import com.ypf.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/outsidelink")
public class OutsidelinkController {

    @Autowired
    private OutsidelinkService outsidelinkService;
    private JsonResult jsonResult;


    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping(value = "/showAllOutsidelink",method = RequestMethod.POST)
    private JsonResult showAllOutsidelink(@RequestBody Map<String,Object> params) {
        if(params.get("value") == null || params.get("value") == "") { //如果没有入参,就查询全部
            List<Object> list = outsidelinkService.showAllOutsidelink();
            return jsonResult.ok(list);
        } else { //如果有入参，就模糊查询
            List<Object> list1 = outsidelinkService.fuzzyFindOutsidelink(params);
            return jsonResult.ok(list1);
        }
    }


    /**
     * 条件查询：按照id查询
     */
    @ResponseBody
    @RequestMapping(value = "/findOutsidelinkById",method = RequestMethod.GET)
    private JsonResult findOutsidelinkById(int id) {
        List<Object> list = outsidelinkService.findOutsidelinkById(id);
        return jsonResult.ok(list);
    }


    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "/addOutsidelink",method = RequestMethod.POST)
    private JsonResult addOutsidelink(@RequestBody OutsideLink outsideLink) {
        int mark = outsidelinkService.addOutsidelink(outsideLink);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/updateOutsidelink",method = RequestMethod.PUT)
    private JsonResult updateOutsidelink(@RequestBody OutsideLink outsideLink) {
        int mark = outsidelinkService.updateOutsidelink(outsideLink);
        if(mark == 1) {
            List<Object> list = outsidelinkService.findOutsidelinkById(outsideLink.getId());
            return jsonResult.ok(list);
        }
        return jsonResult.errorMessage("操作失败");
    }


    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOutsidelink/{id}",method = RequestMethod.DELETE)
    private JsonResult deleteOutsidelink(@PathVariable int id) {
        int mark = outsidelinkService.deleteOutsidelink(id);
        if(mark == 1) return jsonResult.ok();
        return jsonResult.errorMessage("操作失败");
    }



}
