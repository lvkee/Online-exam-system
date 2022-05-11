package com.sy.controller;

import com.sy.entity.Teacher;
import com.sy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chris
 */
@Controller
@RequestMapping(value = "/teacher")

public class TeacherController extends BaseController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/teacherLogin")
    public String login() {
        return "login";
    }


    @RequestMapping(value = "/checkLogin")
    public String checkLogin(@ModelAttribute("teacher") Teacher teacher, Model model) {
        return teacherService.checkLogin(teacher.gettName(), teacher.gettPwd());
    }

    @RequestMapping(value = "/showOrg")
    public ModelAndView showOrg() {
        ModelAndView modelAndView = new ModelAndView("showOrg","message","hello");
        return modelAndView;
    }
}
