package com.singlelovely.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.parser.RecoveredRequiresStatement;

import com.singlelovely.dao.UserDao;
import com.singlelovely.dao.impl.UserDaoImpl;
import com.singlelovely.entity.User;


public class RegServlet extends HttpServlet {
	private UserDao dao =  new UserDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取表单中提交的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmpwd = request.getParameter("confirmpwd");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String sex = request.getParameter("inlineRadioOptions"); //性别
		String telephone = request.getParameter("telephone");
	 
		
		//获取到的数据封装到user对象中
		 User user = new User();
		 //set方法
		 user.setUid(UUID.randomUUID().toString().replaceAll("-",""));
		 user.setUsername(username);
		 user.setPassword(password);
		 user.setEmail(email);
		 user.setName(name);
		 user.setSex(sex);
		 user.setTelephone(telephone);
		 user.setState(0); //账号状态：0未激活  1激活
		 
		 
		 //对象报错到数据库中
		 int num = dao.saveUser(user);
		 
		 if(num == 0) {
			 System.out.println("注册失败");
		 }else {
			System.out.println("注册成功");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
