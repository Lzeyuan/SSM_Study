package com.shaoda.user.model;

import com.shaoda.core.model.Model;

public class Student extends Model {

    /** 用户姓名 */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "学生信息："+ name;
    }
}