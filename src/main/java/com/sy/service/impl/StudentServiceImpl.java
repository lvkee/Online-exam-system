package com.sy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sy.converter.DateConverter;
import com.sy.dao.StudentMapper;
import com.sy.entity.Student;
import com.sy.service.StudentService;
import com.sy.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chris
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public String loginCheck(String sName, String sPwd, Date sBirth) {
        Date date = new Date();
        int i = 0;
        try {
            i = studentMapper.addStudent(sName, "test", "test", "test", date, date, sBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i == 1) {
            System.out.println("插入成功");
            return "/admin/html/login";
        } else {
            System.out.println("插入失败");
            return "/client/views/login";
        }
    }

    /**
     * 实验十 5
     * 1. pageNow 为请求参数，表示要显示的页面号（索引）
     * 2. totalCount 为学生总数
     * 3. 需要导入 util 包下的 Page 类
     * 4. students 和 page 就是传入 JSP 页面的 model
     * @param request request
     * @param model model
     */
    @Override
    public void showStudentsByPage(HttpServletRequest request, Model model) {
        String pageNow = request.getParameter("pageNow");

        Page page = null;

        List<Student> students = new ArrayList<Student>();

        int totalCount = (int) studentMapper.getStudentsCount();

        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            students = this.studentMapper.selectStudents(page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCount, 1);
            students = this.studentMapper.selectStudents(page.getStartPos(), page.getPageSize());
        }
        System.out.println(students.toString());
        model.addAttribute("students", students);
        model.addAttribute("page", page);
    }

    @Override
    public boolean addStudent(String sName, String sNickname, String sPwd, String sEmail, Date sBirth) {
        Date date = new Date();
        try {
            studentMapper.addStudent(sName, sNickname, sPwd, sEmail, date, date, sBirth);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateStudent(int sId, String sName, String sNickname, String sPwd, String sEmail, Date sUpdateDate, Date sBirth) {
        Date date = new Date();
        try {
            studentMapper.updateStudent(sId, sName, sNickname, sPwd, sEmail, date, sBirth);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String queryStudent(int sId) {
        try {
            Student student = studentMapper.queryStudent(sId);
            // 第一种方式
            JSONObject json=new JSONObject();
            json.put("sId", student.getsId());
            json.put("sName",student.getsName());
            json.put("sNickname",student.getsNickname());
            json.put("sPwd",student.getsPwd());
            json.put("sEmail",student.getsEmail());
            json.put("sBirth",student.getsBirth());
            System.out.println(json);
            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteStudent(int sId) {
        try {
            studentMapper.deleteStudent(sId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
