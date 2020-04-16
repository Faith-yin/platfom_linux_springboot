package com.ypf.util;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 统一返回数据格式
 */
@Setter
@Getter
@NoArgsConstructor
public class JsonResult {

    // 响应状态码
    private Integer status;
    // 响应消息
    private String message;
    // 响应中的数据
    private Object data;


    /**
     * 成功操作，有返参
     */
    public static JsonResult ok(Object data) {
        return new JsonResult(data);
    }

    /**
     * 成功操作，无返参
     */
    public static JsonResult ok() {
        return new JsonResult(null);
    }

    /**
     * 失败调用
     */
    public static JsonResult errorMessage(String message) {
        return new JsonResult(500, message, null);
    }


    public JsonResult(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public JsonResult(Object data) {
        this.status = 200;
        this.message = "OK";
        this.data = data;
    }


}