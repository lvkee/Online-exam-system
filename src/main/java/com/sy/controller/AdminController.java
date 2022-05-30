package com.sy.controller;

import com.sy.entity.Admin;
import com.sy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * 管理员操作
 *
 * @author chris
 * @date 2022/05/28
 */

@Controller
@RequestMapping(value = "/admin")

public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 返回登录页面
     *
     * @return
     */
    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/main")
    public String mainPage() {
        return "admin/html/index";
    }

    /**
     * 登录检查
     *
     * @param admin
     * @param session
     * @return
     */
    @RequestMapping(value = "/home")
    public String home(@ModelAttribute("admin") Admin admin, HttpSession session) {
        return adminService.home(admin.gettName(), admin.gettPwd(), session);
    }

    /**
     * xx 管理
     * @return
     */
    @RequestMapping(value = "/files")
    public String toFilePage() {
        return "/admin/html/table-files";
    }

    /**
     * 退出登录
     *
     * @param session
     * @return 登录页面
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
