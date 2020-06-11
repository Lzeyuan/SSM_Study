package com.shaoda.core.model;

/* *
 * 实体类的基类
 * @author LEZA
 * @version
 *
 * */

import lombok.Data;

import java.util.Date;

@Data
public class Model {
    // ID
    protected String id;

    // 创建者
    protected String creator;

    // 创建时间
    protected Date createTime;

    // 更新者
    protected String updator;

    // 更新时间
    protected Date updateTime;
}
