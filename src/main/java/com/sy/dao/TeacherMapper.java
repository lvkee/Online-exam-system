package com.sy.dao;

import com.sy.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author chris
 */
public interface TeacherMapper {

    /**
     * 通过老师 id 查找老师
     * @param id 老师 id
     * @return List
     */
    List<Teacher> getTeachers(int id);

    /**
     * 创建一个新的老师账号
     * @param tName 老师用户名
     * @param tNickname 老师昵称
     * @param tPwd 老师密码
     * @param tEmail 老师邮箱
     * @param tCreateDate 老师账号创建时间
     * @param tLastUpdate 老师账号最后更新时间
     * @return Integer
     */
    Integer addTeachers(@Param("tName") String tName,@Param("tNickname") String tNickname,@Param("tPwd") String tPwd,@Param("tEmail") String tEmail,@Param("tCreateDate") Date tCreateDate,@Param("tLastUpdate") Date tLastUpdate);

}
