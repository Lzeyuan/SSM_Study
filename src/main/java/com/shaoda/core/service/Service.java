package com.shaoda.core.service;
import java.util.List;

import com.shaoda.core.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 业务层接口基础类
 * @author cyz
 * @version 1.0
 */
public interface Service<T> {

    /**
     * 注入对应的数据操作类
     *
     * @param dao 数据操作类
     */
    void setDao(Dao<T> dao);

    /**
     * 保存 T 类型的对象到 Map 成员变量中
     *
     * @param entity 实体
     */
    int save(T entity);

    /**
     * 从 map 中获取 id 对应的对象
     *
     * @param id 实体id
     * @return T
     */
    T get(String id);

    /**
     * 替换 map 中key为id的内容,改为 entity 对象
     *
     * @param entity 实体
     */
    int update(T entity);

    /**
     * 返回 map 中存放的所有 T 对象
     *
     * @return T 对象列表
     */
    List<T> selectAll();

    /**
     * 删除指定 id 对象
     *
     * @param id 实体id
     */
    int delete(String id);

    T Jude(String username, String password);
}
