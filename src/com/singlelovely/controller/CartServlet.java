package com.singlelovely.controller;

import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.singlelovely.dao.ProductDao;
import com.singlelovely.dao.impl.ProductDaoImpl;
import com.singlelovely.entity.Cart;
import com.singlelovely.entity.CartItem;
import com.singlelovely.entity.Product;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private ProductDao dao = new ProductDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if (method.equals("addCart")) {
			addCart(request, response);
		}else if (method.equals("changeNumber")) {
			changeNumber(request,response);
		}else if (method.equals("deleteCart")) {
			deleteCart(request,response);
		}else if (method.equals("clearCart")) {
			clearCart(request,response);
		}
		
	}
	
	
	private void clearCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		//������ﳵ��Ϣ
		cart.getCart().clear();
		response.sendRedirect("cart.jsp");
		
	}


	private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pid = request.getParameter("pid");
		//��ȡ���ﳵ����
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		//ɾ�����ﳵ��
		cart.getCart().remove(pid);
		response.sendRedirect("cart.jsp");
		
	}


	private void changeNumber(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pid = request.getParameter("pid");
		String number = request.getParameter("number");
		
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		//����pidȡ����Ӧ����
		CartItem item = cart.getCart().get(pid);
		item.setNumber(Integer.parseInt(number));
		
		//���޸ĵĹ��ﳵ���ŵ����ﳵ��
		cart.getCart().put(pid, item);
		
		//��cart��ŵ�session��
		session.setAttribute("cart", cart);
		
		response.sendRedirect("cart.jsp");
		return;
	}


	public void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pid = request.getParameter("pid");
		String count = request.getParameter("count");
		
		//����id��ȡ��Ʒ
		Product product = dao.findProductByPid(pid);
		//���칺�ﳵ��
		CartItem item = new CartItem();
		item.setProduct(product);
		item.setNumber(Integer.parseInt(count));
		//��session��ȡ���ﳵ����
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}
		
		//�����ﳵ����ӵ����ﳵ��
		
		cart.add(item);
		
		//�����ﳵ�ŵ�session��
		
		session.setAttribute("cart", cart);
		
		//��ת�����ﳵҳ��
		response.sendRedirect("cart.jsp");
		return;
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
