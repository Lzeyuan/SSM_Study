package com.shaoda.user.service;

import com.shaoda.core.dao.Dao;
import com.shaoda.core.utils.Constants;
import com.shaoda.user.dao.UserMapper;
import com.shaoda.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService<User> {

    private UserMapper userMapper;

    @Autowired
    @Override
    public void setDao(Dao<User> userMapper) {
        this.userMapper = (UserMapper) userMapper;
    }

    @Override
    public int save(User entity) {
        return userMapper.save(entity);
    }

    @Override
    public User get(String code) {
        return userMapper.get(code);
    }

    @Override
    public int update(User entity) {
        return userMapper.update(entity);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int delete(String code) {
        return userMapper.delete(code);
    }

    @Override
    public User Jude(String username, String password) {
        return userMapper.Jude(username, password);
    }

    @Override
    public List<User> pageLimit(HttpSession session) {
        HashMap<String, Integer> map = new HashMap<>(1024);
        Integer pageIndex = (Integer)session.getAttribute(Constants.PAGEINDEX);
        map.put("startIndex", pageIndex);
        map.put("endIndex", pageIndex + 12);
        return userMapper.pageLimit(map);
    }

}
