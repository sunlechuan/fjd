package com.jd.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jd.entity.Cart;
import com.jd.entity.Order;
import com.jd.entity.Product;
import com.jd.entity.User;
import com.jd.service.OrderService;
import com.jd.service.ProductService;

import net.sf.json.JSONArray;

/**
 * 订单
 * Servlet implementation class orderServlet
 */
public class orderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderServlet() {
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
		
		String address = request.getParameter("address");
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		
		User user = (User) request.getSession().getAttribute("user");
		
		if(user == null){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			System.out.println(user);
			int totalMoney = cart.getTotalMoney();
			cart.setTotalMoney(totalMoney);
			
			//cart
			
			//获取购物车中的pid和count
			int user_id = user.getUser_id();
			List<Order> listOrder = cart.getOrderList(user_id);
			for(Order order : listOrder) {
				try {
					order.setAddress(address);
					OrderService.saveOrder(order);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("/order.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
