package com.shaoda.user.service;

import com.shaoda.core.service.Service;
import com.shaoda.user.model.Student;
import com.shaoda.user.model.User;

public interface StudentService extends Service<User> {
    int update(Student student, User user);
}
