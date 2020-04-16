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


    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping(value = "/showAllOutsidelink",method = RequestMethod.POST)
    public JsonResult showAllOutsidelink(@RequestBody Map<String,Object> params) {
        if(params.get("value") == null || params.get("value") == "") { //如果没有入参,就查询全部
            List<Object> list = outsidelinkService.showAllOutsidelink();
            return JsonResult.ok(list);
        } else { //如果有入参，就模糊查询
            List<Object> list1 = outsidelinkService.fuzzyFindOutsidelink(params);
            return JsonResult.ok(list1);
        }
    }


    /**
     * 条件查询：按照id查询
     */
    @ResponseBody
    @RequestMapping(value = "/findOutsidelinkById",method = RequestMethod.GET)
    public JsonResult findOutsidelinkById(int id) {
        List<Object> list = outsidelinkService.findOutsidelinkById(id);
        return JsonResult.ok(list);
    }


    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "/addOutsidelink",method = RequestMethod.POST)
    public JsonResult addOutsidelink(@RequestBody OutsideLink outsideLink) {
        int mark = outsidelinkService.addOutsidelink(outsideLink);
        if(mark == 1) return JsonResult.ok();
        return JsonResult.errorMessage("操作失败");
    }


    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/updateOutsidelink",method = RequestMethod.PUT)
    public JsonResult updateOutsidelink(@RequestBody OutsideLink outsideLink) {
        int mark = outsidelinkService.updateOutsidelink(outsideLink);
        if(mark == 1) {
            List<Object> list = outsidelinkService.findOutsidelinkById(outsideLink.getId());
            return JsonResult.ok(list);
        }
        return JsonResult.errorMessage("操作失败");
    }


    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOutsidelink/{id}",method = RequestMethod.DELETE)
    public JsonResult deleteOutsidelink(@PathVariable int id) {
        int mark = outsidelinkService.deleteOutsidelink(id);
        if(mark == 1) return JsonResult.ok();
        return JsonResult.errorMessage("操作失败");
    }



}
