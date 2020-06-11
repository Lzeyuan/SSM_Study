package com.shaoda.user.dao;

import com.shaoda.core.dao.Dao;
import com.shaoda.user.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface UserMapper extends Dao<User> {
    /**
     * 根据登录名、登录密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    User Jude(@Param("name") String username, @Param("password") String password);

    /**
     * 分页获取USER数据
     * @param map
     * @return User列表
     */
    List<User> pageLimit(HashMap<String, Integer> map);
}
