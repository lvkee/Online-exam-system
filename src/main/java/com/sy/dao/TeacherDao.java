package com.sy.dao;

import com.sy.entity.Teacher;

/**
 * @author chris
 */
public interface TeacherDao {

    /**
     * 通过老师用户名查找老师
     * @param tname 老师用户名
     * @return Teacher
     */
    Teacher findByName(String tname);

}
