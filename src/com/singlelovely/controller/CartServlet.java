package com.singlelovely.controller;

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
		}
		
	}
	
	
	public void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int count = Integer.parseInt(request.getParameter("count"));//����
		String pid = request.getParameter("pid");//��Ʒid
		
		Cart c = new Cart();
		c.setCount(count);
		c.setPid(pid);
		//��session�л�ȡ���еĹ��ﳵ���󼯺�
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		
		if (cartList == null) {
			cartList = new ArrayList<Cart>();
		}
		
		//���ﳵ����Ʒ�ļ���
		//List<Cart> list = new ArrayList<Cart>();		
		
		
		
		cartList.add(c);
		
		
		session.setAttribute("cartList", cartList);
		
		//��ӳɹ�����ת�����ﳵҳ��
		showCart(request,response);
	}
	
	//��ʾ���ﳵҳ��
	public void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//��ȡ���ﳵ����ļ���
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		//���ﳵ�����е���Ʒ�Ķ��󼯺�
		Map<Product, Integer> cartMap = new HashMap<Product, Integer>();
		//�������ﳵ����
		for(Cart cart : cartList) {
			//������Ʒid��ѯ��Ʒ����Ϣ
			Product product = dao.findProductByPid(cart.getPid());
			//����ѯ������Ʒ��ŵ�map����
			cartMap.put(product, cart.getCount());
		}
		request.setAttribute("cartMap", cartMap);
		request.getRequestDispatcher("cart.jsp").forward(request, response);;
		return;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
