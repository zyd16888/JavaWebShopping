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
		//��ȡ�û�����ķ���
		String method = request.getParameter("method");
		System.out.println(method);
		if (method.equals("login")) {
			login(request, response);
		}else if (method.equals("reg")) {
			reg(request, response);
		}
		
	}
	
	public void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�����ύ������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmpwd = request.getParameter("confirmpwd");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String sex = request.getParameter("inlineRadioOptions"); //�Ա�
		String telephone = request.getParameter("telephone");
		
		//�ж����������Ƿ�һ��
		if (!password.equals(confirmpwd)) {
			request.setAttribute("msg", "���벻һ��");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
	 
		
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
		 
		 
		 //���󱨴浽���ݿ���
		 int num = dao.saveUser(user);
		 
		 if(num == 0) {
			 System.out.println("ע��ʧ��");
			 request.setAttribute("msg", "ע��ʧ��");//�����������ò���
			 RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			 dispatcher.forward(request, response);
			 
		 }else {
			//��ת����½����
			 System.out.println("ע��ɹ�");
			 System.out.println(user.getName().toString());
			 response.sendRedirect("login.jsp");
		}
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
		
			//���ݿ��ѯ
			User user = dao.login(username, password);
			
			//�ж��Ƿ��½�ɹ�
			if(user == null) {
					System.out.println("��½ʧ��");
					request.setAttribute("msg", "�û��������������");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					return;
				}else {
				System.out.println("��½�ɹ�");
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
