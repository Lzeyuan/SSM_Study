package com.shaoda.user.controller;

import com.shaoda.user.model.User;
import com.shaoda.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author : LEZA
 * @date : 2020-05-20 15:45
 */
@Controller
public class UmsServlet {

    // 控制反转
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @RequestMapping("/login")
    public String Login(HttpSession session, String username, String password) {

        // 判断是否已登录
        if (session.getAttribute("username") != null) {
            return "redirect:manage";
        }

        // 判断用户名或密码是否为空
        if (username == null || password == null) {
            return "common/login";
        }

        // 查询登录用户信息
        User user = userService.Jude(username, password);

        // 对象不为空，添加用户名和id到Sesision,对象为空则返回登录页面
        if (user != null) {
            session.setAttribute("username", username);
            session.setAttribute("id", user.getId());
            return "redirect:manage";
        } else {
            return "common/login";
        }
    }
}
