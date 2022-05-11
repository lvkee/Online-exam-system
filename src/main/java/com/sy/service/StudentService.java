package com.sy.service;

import com.sy.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author chris
 */
public interface StudentService {

    /**
     * 登陆检查
     * @param sName
     * @param sPwd
     * @param sBirth
     * @return
     */
    String loginCheck(String sName, String sPwd, Date sBirth);

    /**
     * 分页显示学生
     * @param request request
     * @param model model
     */
    void showStudentsByPage(HttpServletRequest request, Model model);

    /**
     * 新增学生
     * @param sName
     * @param sNickname
     * @param sPwd
     * @param sEmail
     * @param sBirth
     * @return
     */
    boolean addStudent(String sName, String sNickname, String sPwd, String sEmail, Date sBirth);

    /**
     * 修改学生信息
     * @param sId
     * @param sName
     * @param sNickname
     * @param sPwd
     * @param sEmail
     * @param sUpdateDate
     * @param sBirth
     * @return
     */
    boolean updateStudent(int sId, String sName, String sNickname, String sPwd, String sEmail, Date sUpdateDate, Date sBirth);

    /**
     * 通过 id 查询单个学生
     * @param sId
     * @return
     */
    String queryStudent(int sId);

    /**
     * 通过 id 查询单个学生
     * @param sId
     * @return
     */
    boolean deleteStudent(int sId);
}
