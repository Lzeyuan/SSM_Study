package com.shaoda.core.dao;

import java.util.List;

/**
* 数据交互的底层接口
* @author LEZA
* @version 1.0
* @param <T>   泛型
*/
public interface Dao<T> {
   /**
   * 保存 T 类型的对象到 Map 成员变量中
    * @param entity 实体
    * @return
    */
   int save(T entity);

   /**
    * 从 map 中获取 id 对应的对象
    * @param id 实体id
    * @return T
    */
   T get(String id);

   /**
    * 替换 map 中key为id的内容,改为 entity 对象
    * @param entity 实体
    * @return
    */
   int update(T entity);

   /**
    * 返回 map 中存放的所有 T 对象
    * @return List
    */
   List<T> selectAll();
   /**
    * 删除指定 id 对象
    * @param id
    * @return
    */
   int delete(String id);

}
