package com.shaoda.user.controller;

import com.shaoda.core.utils.Constants;
import com.shaoda.user.model.User;
import com.shaoda.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 用户管理对应的Servlet
 * @author LEZA
 * @date 2020.5.18
 */
@Controller
public class UserServlet {

    // 依赖注入
    // JDK11之前（不包括JDK11）可以使用@Resource替代下面两条语句
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @GetMapping("/user")
    public String Edit() {
        return "user/user_edit";
    }

    //新增用户
    @PostMapping("/user")
    public String Create(User user, HttpServletResponse response) {
        //唯一编号
        String uid = UUID.randomUUID().toString();
        user.setId(uid);

        //保存User类型的对象到数据库
        Msg(userService.save(user), "添加成功！", "添加失败", response);
        return "user/user_edit";
    }

    // 更新用户信息
    @PutMapping("/user")
    public String Update(User user, HttpSession session, HttpServletResponse response) {
        Msg(userService.update(user), "更新成功！", "更新失败", response);
        return "user/user_edit";
    }

    // 删除用户信息
    @DeleteMapping("/user")
    public String Delete(String code, HttpServletResponse response) {
        Msg(userService.delete(code),"删除成功！", "删除失败", response);
        return "user/user_edit";
    }

    // 判断返回信息
    private void Msg(int jude, String msg1, String msg2, HttpServletResponse response) {
        if (jude > 0) {
            returnMsg(msg1, response);
        } else {
            returnMsg(msg2, response);
        }
    }

    // 返回操作信息
    private void returnMsg(String msg, HttpServletResponse response) {

        //返回信息给浏览器
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String jsonResult = "{\"msg\":\""+ msg +"\",\"success\":1}";
            out.write(jsonResult);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 关闭
        out.flush();
        out.close();
    }

    /**
     * 测试
     * @param model
     * @return
     */
    @RequestMapping("/show")
    public String show(Model model) {
        model.addAttribute("list",userService.selectAll());
        return "product/test";
    }

    // 查看用户信息列表
    @RequestMapping("/userList")
    public String userList(Model model, HttpSession session) {

        if (session.getAttribute(Constants.PAGEINDEX) == null) {
            session.setAttribute(Constants.PAGEINDEX, 0);
        }

        List<User> users = userService.pageLimit(session);

        if(users == null) {
            model.addAttribute("total", "0");
        }
        else {
            model.addAttribute("total", users.size());
        }
        model.addAttribute("rows", users);

        return "user/user_list";
    }

    @RequestMapping("userList/previous")
    public String Previous(HttpSession session) {
        Integer index = (Integer) session.getAttribute(Constants.PAGEINDEX);
        if (index - 12 < 0) {
            index = 0;
        } else {
            index -= 12;
        }

        session.setAttribute(Constants.PAGEINDEX, index);
        return "redirect:/userList";
    }

    @RequestMapping("userList/next")
    public String Next(HttpSession session) {
        Integer index = (Integer) session.getAttribute(Constants.PAGEINDEX) + 12;
        session.setAttribute(Constants.PAGEINDEX, index);
        return "redirect:/userList";
    }
}
