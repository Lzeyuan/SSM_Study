package com.shaoda.user.service;

import com.shaoda.core.dao.Dao;
import com.shaoda.core.service.Service;
import com.shaoda.user.dao.StudentMapper;
import com.shaoda.user.dao.UserMapper;
import com.shaoda.user.model.Student;
import com.shaoda.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements Service<Student> {

    private StudentMapper studentMapper;
    private UserMapper userMapper;

    public void setDaos(Dao<Student> studentMapper) {
        this.studentMapper = (StudentMapper) studentMapper;
    }
    public void setDaou(Dao<User> userMapper) {
        this.userMapper = (UserMapper) userMapper;
    }

    public int update(Student student, User user) {
        studentMapper.update(student);
        userMapper.update(user);
        return 0;
    }

    @Override
    public void setDao(Dao<Student> dao) {

    }

    @Override
    public int save(Student entity) {
        return 0;
    }

    @Override
    public Student get(String id) {
        return null;
    }

    @Override
    public int update(Student entity) {
        return 0;
    }

    @Override
    public List<Student> selectAll() {
        return null;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public Student Jude(String username, String password) {
        return null;
    }

}
