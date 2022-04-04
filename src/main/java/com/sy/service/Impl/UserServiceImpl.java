package com.sy.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.dao.UserDao;
import com.sy.entity.User;
import com.sy.service.UserService;

import java.util.List;
import java.util.Vector;

@Service
public class UserServiceImpl implements UserService {
    /* Enum<String> stringEnum;
     Iterable<String> stringIterable;
     List<String> stringList;
     Vector<String> stringVector;*/
    @Autowired
    private UserDao userDao;

    /*
     * 检验用户登录业务
     *
     */
    public User checkLogin(String username, String password) {

        User user = userDao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
