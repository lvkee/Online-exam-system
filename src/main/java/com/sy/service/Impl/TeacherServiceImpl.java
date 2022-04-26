package com.sy.service.Impl;

import com.sy.dao.TeacherDao;
import com.sy.entity.Teacher;
import com.sy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public String checkLogin(String name, String password) {
        Teacher teacher = teacherDao.findByName(name);
        if (teacher != null && teacher.gettPwd().equals(password)) {
            return "admin/html/index";
        } else {
            System.out.println("Not found");
            return "admin/html/login";
        }
    }
}
