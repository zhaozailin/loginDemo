package com.zzl.demo.common.consts;
/**
 * <p>
 * Title: 状态码常量
 * </p>
 * <p>
 * <p>
 * Description: 状态码常量
 * </p>
 * Author: zzl
 * </p>
 * <p>
 * Copyright: 浙江龙山税友软件股份有限公司
 * </p>  
 * <p>
 * Create Time: 下午1:10:05
 * @version 1.0
 */
public class StatusCode {

    // 业务处理成功
    public static final int GLOBAL_SUCCESS = 1;
    
    // 业务处理失败
    public static final int GLOBAL_FAIL = 0;
    
    // session过期
    public static final int SESSION_TIMEOUT = -2;
    
    // 不是有效的json格式
    public static final int STATUS_INVALID_JSON = 1001;

    // 不是有效的参数
    public static final int STATUS_INVALID_PARAMS = 1002;

    // 文件删除失败
    public static final int STATUS_FILE_DELETE_FAIL = 1003;

    // 数据库记录不存在
    public static final int STATUS_NOT_EXIST = 1004;

    // 权限不足
    public static final int STATUS_LACK_AUTHORITY = 1005;

    // 文件操作失败
    public static final int STATUS_FILE_ERROR = 1006;

    // 数据库记录已存在
    public static final int STATUS_DB_EXIST = 1007;
}
