package com.zzl.demo.web.controller.login;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzl.demo.common.consts.StatusCode;
import com.zzl.demo.common.utils.SessionUtil;
import com.zzl.demo.service.interfaces.user.IUserService;
import com.zzl.demo.web.vo.UserVo;

/**
 * <p>
 * Title: 登录、注册控制层
 * </p>
 * <p>
 * <p>
 * Description: 登录、注册的web接口
 * </p>
 * Author: zzl
 * </p>
 * <p>
 * Copyright: 浙江龙山税友软件股份有限公司
 * </p>  
 * <p>
 * Create Time: 上午10:39:23
 * @version 1.0
 */
@Controller
@RequestMapping("/")
public class LoginController {
    
    /**
     * 用户业务层实例
     */
    @Autowired
    private IUserService userService;
    
    /**
     * 默认跳转至登录页
     * @return 页面url
     */
    @RequestMapping("/")
    public String home() {
        return "home";
    }
    
    /**
     * 用户登录
     * @param UserVo 用户业务对象
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute UserVo vo, HttpSession session) {
        
        // 组装查询参数
        JSONObject params = new JSONObject();
        params.put("username", vo.getUsername());
        params.put("password", vo.getPassword());
        
        // 检查登录
        String result = userService.checkLogin(params.toString());
        
        // 解析检查结果
        JSONObject resultObj = JSONObject.fromObject(result);
        
        // 登录失败
        if (resultObj.getInt("status") != StatusCode.GLOBAL_SUCCESS) {
            model.addAttribute("error", true);
            return "home";
        }
        
        // 登录成功，设置session信息
        SessionUtil.setSession(session, resultObj.getJSONObject("user"));
        
        // 跳转到主页
        return "main/main";
    }
    
    /**
     * 用户注册
     * @param body 请求消息体
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(Model model, @RequestBody String body) {
        
        // 执行注册
        return userService.register(body);
    }
}
