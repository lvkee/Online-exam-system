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

//��������@SessionAttributes������ֱ�Ӱ�model�е�teacher(Ҳ��key)��������
//������֤��session�д���teacher�������
//@SessionAttributes("teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/index")
    public String index() {
        System.out.println("ִ�� index");
        return "index";
    }

    //��������loginҳ��
    @RequestMapping(value = "/teacherLogin")
    public String login() {
        return "/admin/html/login";
    }

    /**
     * application_context������form������URL��ͬ ����404
     */
    @RequestMapping(value = "/checkLogin")
    public String checkLogin(@ModelAttribute("teacher") Teacher teacher) {
        //����service����
        return teacherService.checkLogin(teacher.gettName(), teacher.gettPwd());
    }

    //���Գ�������ת����һ��ҳ���Ƿ����ȡ��sessionֵ
    @RequestMapping("/anotherpage")
    public String hrefpage() {

        return "anotherpage";
    }

    //ע������
    @RequestMapping("/outLogin")
    public String outLogin(HttpSession session) {
        //ͨ��session.invalidata()������ע����ǰ��session
        session.invalidate();
        return "login";
    }
}
