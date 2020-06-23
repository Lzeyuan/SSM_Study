package com.shaoda.user.model;

import com.shaoda.core.model.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 学生实体类
 * @author cyz
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Model {

	private String id;

	/** 用户姓名 */
	private String name;

}
