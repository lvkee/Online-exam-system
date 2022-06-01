package com.sy.dao;

import com.sy.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author chris
 */
public interface StudentMapper {

    /**
     * 实验九 2 创建一个学生账号
     * @param sName 学生用户名
     * @param sNickname 学生昵称
     * @param sPwd 学生密码
     * @param sEmail 学生邮箱
     * @param sCreateDate 学生账号创建时间
     * @param sUpdateDate 学生账号最后修改时间
     * @param sBirth 学生生日
     * @return Integer
     */
    public Integer addStudent(@Param("sName") String sName, @Param("sNickname") String sNickname, @Param("sPwd") String sPwd, @Param("sEmail") String sEmail, @Param("sCreateDate") Date sCreateDate, @Param("sUpdateDate") Date sUpdateDate, @Param("sBirth") Date sBirth);

    /**
     * 实验九 2 通过学生 id 查询单个学生
     * @param sId
     * @return
     */
    public Student queryStudent(@Param("sId") int sId);

    /**
     * 实验九 2 通过学生 id 删除单个学生
     * @param sId
     * @return
     */
    public int deleteStudent(@Param("sId") int sId);

    /**
     * 实验九 2 通过学生 id 修改学生信息
     * @param sId
     * @param sName
     * @param sNickname
     * @param sPwd
     * @param sEmail
     * @param sUpdateDate
     * @param sBirth
     * @return
     */
    public int updateStudent(@Param("sId") int sId, @Param("sName") String sName, @Param("sNickname") String sNickname, @Param("sPwd") String sPwd, @Param("sEmail") String sEmail, @Param("sUpdateDate") Date sUpdateDate, @Param("sBirth") Date sBirth);

    /**
     * 实验十 3
     * 使用注释方法传入多个参数，学生分页
     * @param startPos 起始位置
     * @param pageSize 每页容量
     * @return 学生集合
     */
    public List<Student> selectStudents(@Param(value="startPos") Integer startPos, @Param(value="pageSize") Integer pageSize);

    /**
     * 实验十 3
     * 取得学生数量
     * @return 学生数量
     */
    public long getStudentsCount();
}
