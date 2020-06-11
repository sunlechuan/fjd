package com.jd.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jd.entity.Cart;
import com.jd.entity.Product;
import com.jd.service.ProductService;

/**
 * 放入购物车
 * Servlet implementation class buyServlet
 */
public class buyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		//处理表单提交过来的数据
		request.setCharacterEncoding("utf-8");
		
		int pid = 0;
		int num = 0;
		if(request.getParameter("pid") != null && request.getParameter("num") != null){
			pid = Integer.parseInt(request.getParameter("pid").toString());
			num = Integer.parseInt(request.getParameter("num").toString());
			System.out.println("pid---" + pid + "num---" + num);
		}
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		//session没有存入cart
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		
		if(request.getParameter("pid") != null  && request.getParameter("num") != null){
			//从数据库找到该条商品放入map中
			ProductService ps = new ProductService();
			Product product = new Product();
			try {
				product = (Product) ps.getProduct(pid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cart.addProduct(product,num);
			int totalMoney = cart.getTotalMoney();
			cart.setTotalMoney(totalMoney);
		}
		
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
