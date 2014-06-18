package com.zzl.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzl.demo.common.consts.StatusCode;
import com.zzl.demo.common.utils.JsonUtil;
import com.zzl.demo.domain.user.User;
import com.zzl.demo.repository.interfaces.user.IUserRepository;
import com.zzl.demo.service.interfaces.user.IUserService;

/**
 * <p>
 * Title: 用户业务层实现类
 * </p>
 * <p>
 * <p>
 * Description: 用户业务层实现类
 * </p>
 * Author: servyou10
 * </p>
 * <p>
 * Copyright: 浙江龙山税友软件股份有限公司
 * </p>  
 * <p>
 * Create Time: 上午11:14:14
 * @version 1.0
 */
@Service
public class UserService implements IUserService {

    /**
     * 用户数据库操作实例
     */
    @Autowired
    private IUserRepository userRepository;
    
    /**
     * 登录检查
     * @see com.zzl.demo.service.interfaces.user.IUserService#checkLogin(java.lang.String)
     */
    @Override
    public String checkLogin(String params) {
        
        // 检查参数
        if (!JsonUtil.valid(params)) {
            return JsonUtil.resultToJson(StatusCode.STATUS_INVALID_JSON);
        }

        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("username", "String");
        paramsMap.put("password", "String");
        JSONObject paramsObj = JSONObject.fromObject(params);
        if (!JsonUtil.checkParams(paramsObj, paramsMap)) {
            return JsonUtil.resultToJson(StatusCode.STATUS_INVALID_PARAMS);
        }
        
        // 解析参数
        String username = paramsObj.getString("username");
        String password = paramsObj.getString("password");
        
        // 组装查询参数
        HashMap<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("username", username);
        paramMap.put("password", password);
        
        List<User> users = userRepository.select(paramMap);
        
        // 无查询结果
        if (null == users || users.isEmpty()) {
            return JsonUtil.resultToJson(StatusCode.GLOBAL_FAIL);
        }
        
        // 组装查询结果
        User user = users.get(0);
        JSONObject userObj = new JSONObject();
        
        userObj.put("id", user.getId());
        userObj.put("username", user.getUsername());
        userObj.put("password", user.getPassword());
        
        JSONObject result = JsonUtil.resultToJsonObj(StatusCode.GLOBAL_SUCCESS);
        result.put("user", userObj);
        
        return result.toString();
    }

    /**
     * 用户注册
     * @see com.zzl.demo.service.interfaces.user.IUserService#register(java.lang.String)
     */
    @Override
    public String register(String params) {
        
        // 检查参数
        if (!JsonUtil.valid(params)) {
            return JsonUtil.resultToJson(StatusCode.STATUS_INVALID_JSON);
        }

        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("username", "String");
        paramsMap.put("password", "String");
        JSONObject paramsObj = JSONObject.fromObject(params);
        if (!JsonUtil.checkParams(paramsObj, paramsMap)) {
            return JsonUtil.resultToJson(StatusCode.STATUS_INVALID_PARAMS);
        }
        
        // 解析参数
        String username = paramsObj.getString("username");
        String password = paramsObj.getString("password");
        
        // 检查用户名是否重复
        
        // 组装用户对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        
        // 执行注册
        userRepository.insert(user);
        
        // 返回结果
        return JsonUtil.resultToJson(StatusCode.GLOBAL_SUCCESS);
    }

}
