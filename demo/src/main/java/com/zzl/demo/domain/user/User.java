package com.zzl.demo.domain.user;
/**
 * <p>
 * Title: 用户数据模型
 * </p>
 * <p>
 * <p>
 * Description: 用户数据模型
 * </p>
 * Author: zzl
 * </p>
 * <p>
 * Copyright: 浙江龙山税友软件股份有限公司
 * </p>  
 * <p>
 * Create Time: 上午11:22:48
 * @version 1.0
 */
public class User {

    private Long id;
    
    private String username;
    
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
