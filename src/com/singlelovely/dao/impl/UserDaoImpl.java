package com.singlelovely.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.singlelovely.dao.UserDao;
import com.singlelovely.entity.User;
import com.singlelovely.utils.DBUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public int saveUser(User user) {
		int num = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			//���ݹ������ȡ���ݿ�����
			conn = DBUtils.getConnection();
			
			String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?)";
			
			//��ȡ���ݿ��������
			pst = (PreparedStatement) DBUtils.getPst(conn, sql);
			
			//Ϊռλ������ֵ
			pst.setString(1, user.getUid());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getName());
			pst.setString(5, user.getPhoto());
			pst.setString(6, user.getEmail());
			pst.setString(7, user.getTelephone());
			pst.setString(8, user.getBirthday());
			pst.setString(9, user.getSex());
			pst.setInt(10, user.getState());
			pst.setString(11, user.getCode());
			
			//ִ��sql���
			num = pst.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtils.close(null, pst, conn);
		}
		
		
		return num;
	}

}
