package com.shaoda.user.dao;

import com.shaoda.core.dao.Dao;
import com.shaoda.user.model.Student;
import com.shaoda.user.model.User;

public interface StudentMapper extends Dao<Student> {
    int update(Student student, User user);
}
