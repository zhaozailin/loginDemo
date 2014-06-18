package com.zzl.demo.service.interfaces.user;
/**
 * <p>
 * Title: 用户业务层接口
 * </p>
 * <p>
 * <p>
 * Description: 用户业务层相关接口
 * </p>
 * Author: zzl
 * </p>
 * <p>
 * Copyright: 浙江龙山税友软件股份有限公司
 * </p>  
 * <p>
 * Create Time: 上午11:08:00
 * @version 1.0
 */
public interface IUserService {
    
    /**
     * 登录检查
     * @param params
     * {
     *  username:x --- 用户名
     *  password:x --- 密码
     * }
     * @return
     * {
     *  status:x --- 1:成功，0:失败，1001:不是有效的json格式，1002:不是有效的参数
     *  user:
     *  {
     *   id:x --- 用户id
     *   username --- 用户名
     *   password --- 密码
     *  }
     * }
     */
    public String checkLogin(String params);
    
    /**
     * 注册
     * @param params
     * {
     *  username:x --- 用户名
     *  password:x --- 密码
     * }
     * @return
     * {
     *  status:x --- 1:成功，0:失败，1007:用户名已存在，1001:不是有效的json格式，1002:不是有效的参数
     * }
     */
    public String register(String params);
}
