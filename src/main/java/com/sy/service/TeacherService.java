package com.sy.service;

/**
 * @author chris
 */
public interface TeacherService {

    /**
     * 检查老师用户名和密码是否匹配
     * @param name 老师用户名
     * @param password 老师密码
     * @return String
     */
    String home(String name, String password);

}
