package com.zzl.demo.common.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

/**
 * <p>
 * Title: 处理json的工具类
 * </p>
 * <p>
 * <p>
 * Description: 处理json的工具类
 * </p>
 * Author: zzl
 * </p>
 * <p>
 * Copyright: 浙江龙山税友软件股份有限公司
 * </p>  
 * <p>
 * Create Time: 下午1:13:48
 * @version 1.0
 */
public class JsonUtil {

    /**
     * 根据状态码组装返回结果
     * @param statusCode 状态码
     * @return json字符串
     */
    public static String resultToJson(int statusCode) {
        JSONObject result = new JSONObject();
        result.put("status", statusCode);
        return result.toString();
    }
    
    /**
     * 根据状态码组装返回结果
     * @param statusCode 状态码
     * @return json对象
     */
    public static JSONObject resultToJsonObj(int statusCode) {
        JSONObject result = new JSONObject();
        result.put("status", statusCode);
        return result;
    }
    
    /**
     * 验证字符串是否为json格式
     * 
     * @param json 待验证的字符串
     * @return 是否通过校验
     */
    public static boolean valid(String json) {
        if(null == json) {
            return false;
        }
        
        try {
            JSONObject.fromObject(json);
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    /**
     * 检查json中是否含有指定参数
     * @param json json字符串
     * @param paramsMap 参数集合
     * @return 检查结果
     */
    public static boolean checkParams(JSONObject json, Map<String, String> paramsMap) {
        if(null == json || null == paramsMap) {
            return false;
        }
        
        Iterator<Entry<String, String>> iter = paramsMap.entrySet().iterator();
        while(iter.hasNext()) {
            Entry<String, String> entry = iter.next();
            String param = entry.getKey();
            String paramType = entry.getValue();
            
            if(!json.has(param)) {
                return false;
            }
            
            if(!checkParamValid(json.getString(param), paramType)) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * 检查参数的数据类型是否合法
     * @param param 参数名
     * @param paramType 参数数据类型
     * @return 校验结果
     */
    private static boolean checkParamValid(String param, String paramType) {
        if(null == param || null == paramType) {
            return false;
        }
        
        try {
            if("String".equals(paramType)) {
                return true;
            }
            if("Long".equals(paramType)) {
                Long.parseLong(param);
                return true;
            }
            if("Integer".equals(paramType)) {
                Integer.parseInt(param);
                return true;
            }
            if("Double".equals(paramType)) {
                Double.parseDouble(param);
                return true;
            }
            if("Boolean".equals(paramType)) {
                Boolean.parseBoolean(param);
                return true;
            }
            
        } catch (NumberFormatException e) {
            // TODO log
        }
        
        return false;
    }
}
