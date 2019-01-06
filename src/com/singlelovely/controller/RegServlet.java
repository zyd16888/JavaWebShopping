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
		//��ȡ�����ύ������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmpwd = request.getParameter("confirmpwd");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String sex = request.getParameter("inlineRadioOptions"); //�Ա�
		String telephone = request.getParameter("telephone");
	 
		
		//��ȡ�������ݷ�װ��user������
		 User user = new User();
		 //set����
		 user.setUid(UUID.randomUUID().toString().replaceAll("-",""));
		 user.setUsername(username);
		 user.setPassword(password);
		 user.setEmail(email);
		 user.setName(name);
		 user.setSex(sex);
		 user.setTelephone(telephone);
		 user.setState(0); //�˺�״̬��0δ����  1����
		 
		 
		 //���󱨴����ݿ���
		 int num = dao.saveUser(user);
		 
		 if(num == 0) {
			 System.out.println("ע��ʧ��");
		 }else {
			System.out.println("ע��ɹ�");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
