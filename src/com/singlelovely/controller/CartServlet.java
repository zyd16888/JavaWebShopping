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
		//清除购物车信息
		cart.getCart().clear();
		response.sendRedirect("cart.jsp");
		
	}


	private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pid = request.getParameter("pid");
		//获取购物车对象
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		//删除购物车项
		cart.getCart().remove(pid);
		response.sendRedirect("cart.jsp");
		
	}


	private void changeNumber(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pid = request.getParameter("pid");
		String number = request.getParameter("number");
		
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		//根据pid取出对应的项
		CartItem item = cart.getCart().get(pid);
		item.setNumber(Integer.parseInt(number));
		
		//将修改的购物车项存放到购物车中
		cart.getCart().put(pid, item);
		
		//将cart存放到session中
		session.setAttribute("cart", cart);
		
		response.sendRedirect("cart.jsp");
		return;
	}


	public void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pid = request.getParameter("pid");
		String count = request.getParameter("count");
		
		//根据id获取商品
		Product product = dao.findProductByPid(pid);
		//构造购物车项
		CartItem item = new CartItem();
		item.setProduct(product);
		item.setNumber(Integer.parseInt(count));
		//从session获取购物车对象
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}
		
		//将购物车项添加到购物车中
		
		cart.add(item);
		
		//将购物车放到session中
		
		session.setAttribute("cart", cart);
		
		//跳转到购物车页面
		response.sendRedirect("cart.jsp");
		return;
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
