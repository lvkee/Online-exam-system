package com.sy.controller;

import com.sy.entity.Teacher;
import com.sy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/teacher")

//这里用了@SessionAttributes，可以直接把model中的teacher(也就key)放入其中
//这样保证了session中存在teacher这个对象
//@SessionAttributes("teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/index")
    public String index() {
        System.out.println("执行 index");
        return "index";
    }

    //正常访问login页面
    @RequestMapping(value = "/teacherLogin")
    public String login() {
        return "/admin/html/login";
    }

    /**
     * application_context必须与form表单请求URL相同 否则报404
     */
    @RequestMapping(value = "/checkLogin")
    public String checkLogin(@ModelAttribute("teacher") Teacher teacher) {
        //调用service方法
        return teacherService.checkLogin(teacher.gettName(), teacher.gettPwd());
    }

    //测试超链接跳转到另一个页面是否可以取到session值
    @RequestMapping("/anotherpage")
    public String hrefpage() {

        return "anotherpage";
    }

    //注销方法
    @RequestMapping("/outLogin")
    public String outLogin(HttpSession session) {
        //通过session.invalidata()方法来注销当前的session
        session.invalidate();
        return "login";
    }
}
