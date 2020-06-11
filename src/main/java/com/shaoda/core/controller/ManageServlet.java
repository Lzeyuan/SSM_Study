package com.shaoda.core.controller;

import com.shaoda.core.utils.Constants;
import com.shaoda.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 管理后台对应的Servlet
 * @author LIZIEN
 * 2020.5.11
 * */

@SuppressWarnings("serial")
@Controller
public class ManageServlet {

	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	@RequestMapping("/manage")
	public String isLogin(HttpSession session) {

		// 判断是否登录
		if (session.getAttribute("username") != null) {
			return "common/manage";
		} else {
			return "redirect:login";
		}
	}

	@RequestMapping("/manage/loginout")
	public String judeLoginOut(HttpSession session) {

		// 退出登录,删除Session中的用户信息
		session.removeAttribute(Constants.USERSESSION);
		session.removeAttribute("id");
		return "redirect:login";
	}

}
