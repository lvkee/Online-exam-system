package com.sy.service;

import javax.servlet.http.HttpSession;

/**
 * @author chris
 */
public interface AdminService {

    /**
     * 检查用户名和密码是否匹配
     * 如果匹配则将用户加入 session
     * @param name 用户名
     * @param password 密码
     * @param session
     * @return JSP 视图
     */
    String home(String name, String password, HttpSession session);

}
