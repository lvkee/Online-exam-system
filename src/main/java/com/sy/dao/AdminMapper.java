package com.sy.dao;

import com.sy.entity.Admin;

/**
 * @author chris
 */

public interface AdminMapper {

/**
     * 通过用户名查找管理员
     * @param tname 管理员用户名
     * @return
     */

    Admin findByName(String tname);

}
