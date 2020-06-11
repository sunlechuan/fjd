package com.jd.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jd.entity.Cart;
import com.jd.entity.OrderItem;
import com.jd.entity.User;
import com.jd.service.OrderService;

import net.sf.json.JSONArray;

/**
 * 我的订单页面
 * Servlet implementation class myOrderServlet
 */
public class myOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myOrderServlet() {
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
		System.out.println("------myOrder---------");
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
			List<OrderItem> myOrderList= null;
			try {
				myOrderList = OrderService.listOrder(user.getUser_id());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONArray data = JSONArray.fromObject(myOrderList);
			System.out.println(data);
			response.getWriter().print(data);
			request.setAttribute("data", data);
			request.getRequestDispatcher("/myorder.jsp").forward(request, response);
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
