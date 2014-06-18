package com.zzl.demo.common.utils;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

/**
 * <p>
 * Title: session工具类
 * </p>
 * <p>
 * <p>
 * Description: 处理session的工具类
 * </p>
 * Author: servyou10
 * </p>
 * <p>
 * Copyright: 浙江龙山税友软件股份有限公司
 * </p>  
 * <p>
 * Create Time: 下午1:57:59
 * @version 1.0
 */
public class SessionUtil {
    
    /**
     * 登录后设置session信息
     * 
     * @param session
     * @param userObj
     */
    public static void setSession(HttpSession session, JSONObject userObj) {
        
        // 用户信息
        session.setAttribute("userId", userObj.getLong("id"));
        session.setAttribute("username", userObj.getString("username"));
    }

    /**
     * 从session中获取userId
     * 
     * @param session
     */
    public static Long getUserId(HttpSession session) {

        if (null == session) {
            return null;
        }

        return (Long) session.getAttribute("userId");
    }
}
