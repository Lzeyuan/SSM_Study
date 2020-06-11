package com.shaoda.user.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.shaoda.core.model.Model;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class User extends Model {

    // 登录名
    private String code;

    // 密码
    private String password;

    // 用户姓名
    private String name;

    // 用户年龄
    private int age;

    // 出生年月日
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format="yyyy-MM-dd")//数据库导出页面时json格式化
    private Date birthday;
}
