package com.zzl.demo.repository.interfaces.user;

import java.util.HashMap;
import java.util.List;

import com.zzl.demo.domain.user.User;

/**
 * <p>
 * Title: 用户数据库接口
 * </p>
 * <p>
 * <p>
 * Description: 用户数据库接口
 * </p>
 * Author: zzl
 * </p>
 * <p>
 * Copyright: 浙江龙山税友软件股份有限公司
 * </p>  
 * <p>
 * Create Time: 上午11:19:17
 * @version 1.0
 */
public interface IUserRepository {

    /**
     * 根据条件查询用户集合
     * @param paramMap 参数集合
     * @return 用户对象集合
     */
    public List<User> select(HashMap<String, Object> paramMap);
    
    /**
     * 根据id查询用户
     * @param id 用户id
     * @return 用户对象
     */
    public User selectById(Long id);
}
