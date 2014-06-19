package com.zzl.demo.repository.impl.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zzl.demo.domain.user.User;
import com.zzl.demo.repository.interfaces.user.IUserRepository;

/**
 * <p>
 * Title: 用户数据库接口实现类（测试版均为假数据）
 * </p>
 * <p>
 * <p>
 * Description: 用户数据库接口实现类
 * </p>
 * Author: zzl
 * </p>
 * <p>
 * Copyright: 浙江龙山税友软件股份有限公司
 * </p>  
 * <p>
 * Create Time: 上午11:29:40
 * @version 1.0
 */
@Repository
public class UserRepository implements IUserRepository {

    /**
     * 根据条件查询用户对象集合
     * @see com.zzl.demo.repository.interfaces.user.IUserRepository#select(java.util.HashMap)
     */
    @Override
    public List<User> select(HashMap<String, Object> paramMap) {
        
        List<User> list = new ArrayList<User>();
        
        if (((String)paramMap.get("username")).equals("zzl") && ((String)paramMap.get("password")).equals("123")) {
            User user = new User();
            user.setId(1L);
            user.setUsername("zzl");
            user.setPassword("123");
            
            list.add(user);
        }
        
        return list;
    }

    /** 
     * 根据id查询用户对象
     * @see com.zzl.demo.repository.interfaces.user.IUserRepository#selectById(java.lang.Long)
     */
    @Override
    public User selectById(Long id) {
        User user = new User();
        user.setId(1L);
        user.setUsername("zzl");
        user.setPassword("123");
        
        return user;
    }

    /** 
     * 新增用户
     * @see com.zzl.demo.repository.interfaces.user.IUserRepository#insert(com.zzl.demo.domain.user.User)
     */
    @Override
    public void insert(User user) {
        // 略
    }

    /**
     * 检查用户是否重名 
     * @see com.zzl.demo.repository.interfaces.user.IUserRepository#checkRepeat(java.lang.String, java.lang.Long)
     */
    @Override
    public boolean checkRepeat(String username, Long id) {
        
        // 略
        return false;
    }
    
}
