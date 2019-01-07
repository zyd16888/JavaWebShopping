package com.singlelovely.dao;

import com.singlelovely.entity.User;

/**
 * user类操作接口
 * 增删改查
 * 登陆
 * 
 * @author dong
 *
 */


public interface UserDao {
	/**
	 * 增加用户方法
	 * @param user  对象中封装了要插入到数据库中的数据
	 * @return		插入的记录数
	 */
	
	public int saveUser(User user);
	
	
	
	/**
	 * 增加用户方法
	 * @param user  对象中封装了要插入到数据库中的数据
	 * @param password
	 * @return
	 */
	public User login(String username, String password);
}
