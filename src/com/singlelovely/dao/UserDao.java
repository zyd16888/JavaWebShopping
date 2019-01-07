package com.singlelovely.dao;

import com.singlelovely.entity.User;

/**
 * user������ӿ�
 * ��ɾ�Ĳ�
 * ��½
 * 
 * @author dong
 *
 */


public interface UserDao {
	/**
	 * �����û�����
	 * @param user  �����з�װ��Ҫ���뵽���ݿ��е�����
	 * @return		����ļ�¼��
	 */
	
	public int saveUser(User user);
	
	
	
	/**
	 * �����û�����
	 * @param user  �����з�װ��Ҫ���뵽���ݿ��е�����
	 * @param password
	 * @return
	 */
	public User login(String username, String password);
}
