package com.sy.service.impl;

import com.sy.dao.AdminMapper;
import com.sy.entity.Admin;
import com.sy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author chris
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public String home(String name, String password, HttpSession session) {
        Admin admin = adminMapper.findByName(name);
        if (admin != null && admin.gettPwd().equals(password)) {
            session.setAttribute("admin", admin.gettNickname());
            return "admin/html/index";
        } else {
            return "login";
        }
    }
}
