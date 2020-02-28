package com.ypf.util;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 统一返回数据格式
 */
public class JsonResult {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应状态码
    private Integer status;
    // 响应消息
    private String message;
    // 响应中的数据
    private Object data;
    // 不使用
    private String ok;

    public static JsonResult build(Integer status, String message, Object data) {
        return new JsonResult(status, message, data);
    }

    /**
     * 成功操作，有返参
     * @param data
     * @return
     */
    public static JsonResult ok(Object data) {
        return new JsonResult(data);
    }

    /**
     * 成功操作，无返参
     * @return
     */
    public static JsonResult ok() {
        return new JsonResult(null);
    }

    /**
     * 失败调用
     * @param message
     * @return
     */
    public static JsonResult errorMessage(String message) {
        return new JsonResult(500, message, null);
    }

    public JsonResult() {}



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

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }


    /**
     * 将json结果集转化为JSONResult对象,需要转换的对象是一个类
     */
    public static JsonResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, JsonResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("message").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     */
    public static JsonResult format(String json) {
        try {
            return MAPPER.readValue(json, JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Object是集合转化,需要转换的对象是一个list
     */
    public static JsonResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("message").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }


}