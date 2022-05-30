/*
package com.sy.service.impl;

import com.sy.dao.TeacherDao;
import com.sy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

*/
/**
 * @author chris
 *//*

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public String home(String name, String password) {
        Teacher teacher = teacherDao.findByName(name);
        return teacher != null && teacher.gettPwd().equals(password) ? "admin/html/index" : "admin/html/login";
    }
}
*/
