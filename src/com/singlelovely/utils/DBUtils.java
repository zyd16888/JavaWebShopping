package com.singlelovely.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 	���ݿ����������
 * 	Ϊ�˼�jdbc�Ĳ���
 * 		ע������
 * 		��ȡ�����ݿ������
 * 
 * @author dong
 *
 */

public class DBUtils {
	
	//ע��������ִֻ��һ��
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//��ȡ�����ݿ������
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String user = "root";
		String password = "475182659";
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	
	public static Statement getPst(Connection conn,String sql){
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pst;
	}
	
	public static void close(ResultSet rs,PreparedStatement pst,Connection conn) {
		try {
			if (rs != null)
				rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		try {
			if (pst != null) {
				pst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	 
	}
	

}
