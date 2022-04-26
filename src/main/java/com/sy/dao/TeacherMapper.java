package com.sy.dao;

import com.sy.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TeacherMapper {

    List<Teacher> getTeachers(int id);

    Integer addTeachers(@Param("tName") String tName,@Param("tNickname") String tNickname,@Param("tPwd") String tPwd,@Param("tEmail") String tEmail,@Param("tCreateDate") Date tCreateDate,@Param("tLastUpdate") Date tLastUpdate);

}
