package com.singlelovely.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.parser.RecoveredRequiresStatement;

import com.singlelovely.dao.UserDao;
import com.singlelovely.dao.impl.UserDaoImpl;
import com.singlelovely.entity.User;


public class UserServlet extends HttpServlet {
	private UserDao dao =  new UserDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户请求的方法
		String method = request.getParameter("method");
		System.out.println(method);
		if (method.equals("login")) {
			login(request, response);
		}else if (method.equals("reg")) {
			reg(request, response);
		}
		
	}
	
	public void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取表单中提交的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmpwd = request.getParameter("confirmpwd");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String sex = request.getParameter("inlineRadioOptions"); //性别
		String telephone = request.getParameter("telephone");
		
		//判断两次密码是否一样
		if (!password.equals(confirmpwd)) {
			request.setAttribute("msg", "密码不一致");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
	 
		
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
		 
		 
		 //对象报存到数据库中
		 int num = dao.saveUser(user);
		 
		 if(num == 0) {
			 System.out.println("注册失败");
			 request.setAttribute("msg", "注册失败");//向请求中设置参数
			 RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			 dispatcher.forward(request, response);
			 
		 }else {
			//跳转到登陆界面
			 System.out.println("注册成功");
			 System.out.println(user.getName().toString());
			 response.sendRedirect("login.jsp");
		}
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
		
			//数据库查询
			User user = dao.login(username, password);
			
			//判断是否登陆成功
			if(user == null) {
					System.out.println("登陆失败");
					request.setAttribute("msg", "用户名或者密码错误");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					return;
				}else {
				System.out.println("登陆成功");
					response.sendRedirect("index.jsp");
				}
			
			
			} catch (ServletException | IOException e) {
				
				e.printStackTrace();
			}
	}
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
