package com.singlelovely.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			//根据工具类获取数据库连接
			conn = DBUtils.getConnection();
			
			String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?)";
			
			//获取数据库操作对象
			pst = (PreparedStatement) DBUtils.getPst(conn, sql);
			
			//为占位符设置值
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
			
			//执行sql语句
			num = pst.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtils.close(null, pst, conn);
		}
		
		
		return num;
	}

	@Override
	public User login(String username, String password) {
		//System.out.println(username+" u + p "+password); 查看传值
		//创建实体类对象
		User user =  null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from user where username=? and password=?";
			pst =   (PreparedStatement) DBUtils.getPst(conn, sql);
			pst.setString(1, username);
			pst.setString(2,password);
			
			rs = pst.executeQuery();
			if (rs.next()) {
				String uid = rs.getString(1);
				String uname = rs.getString(2);
				String pass = rs.getString(3);
				String name = rs.getString(4);
				String photo = rs.getString(5);
				String email = rs.getString(6);
				String telephone = rs.getString(7);
				String birthday = rs.getString(8);
				String sex = rs.getString(9);
				int state = rs.getInt(10);
				String code = rs.getString(11);
				
				user = new User();

				user.setUid(uid);
				user.setUsername(uname);
				user.setPassword(pass);
				user.setPhoto(photo);
				user.setName(name);
				user.setEmail(email);
				user.setTelephone(telephone);
				user.setBirthday(birthday);
				user.setSex(sex);
				user.setState(state);
				user.setCode(code);
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, pst, conn);
		}
		return user;
	}

}
