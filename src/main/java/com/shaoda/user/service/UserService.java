package com.shaoda.user.service;

import com.shaoda.core.service.Service;
import com.shaoda.user.model.User;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * 业务层接口基础类
 * @author cyz
 * @version 1.0
 */
public interface UserService<T> extends Service<User> {
    /**
     * 根据登录名、登录密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    User Jude(@Param("name") String username, @Param("password") String password);

    List<User> pageLimit(HttpSession session);
}
