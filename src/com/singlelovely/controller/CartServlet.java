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
		int count = Integer.parseInt(request.getParameter("count"));//数量
		String pid = request.getParameter("pid");//商品id
		
		Cart c = new Cart();
		c.setCount(count);
		c.setPid(pid);
		//从session中获取已有的购物车对象集合
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		
		if (cartList == null) {
			cartList = new ArrayList<Cart>();
		}
		
		//购物车中商品的集合
		//List<Cart> list = new ArrayList<Cart>();		
		
		
		
		cartList.add(c);
		
		
		session.setAttribute("cartList", cartList);
		
		//添加成功后跳转到购物车页面
		showCart(request,response);
	}
	
	//显示购物车页面
	public void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//获取购物车对象的集合
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		//购物车中所有的商品的对象集合
		Map<Product, Integer> cartMap = new HashMap<Product, Integer>();
		//遍历购物车对象
		for(Cart cart : cartList) {
			//根据商品id查询商品的信息
			Product product = dao.findProductByPid(cart.getPid());
			//将查询到的商品存放到map集合
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
