package com.jd.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jd.entity.Cart;
import com.jd.entity.User;
import com.jd.service.UserService;

/**
 * 
 * �ж��û�����¼
 * Servlet implementation class LoginServlet
 * 
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		//������ύ����������
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		
		User user = (User) request.getSession().getAttribute("user");//�鿴�Ƿ��½��
		if(user == null) {
			//δ��½��
			user = new User();
			User user1 = new User(username,password);
			try {
				user = UserService.login(user1);
				if(user == null) {
					request.getRequestDispatcher("/regis.jsp").forward(request, response);
				}else {
					System.out.println("============");
					request.getSession().setAttribute("user", user);//�д��û�����session
					request.getRequestDispatcher("/indexServlet").forward(request, response);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else {
			//��½��
			request.getSession().invalidate();
			
			User user1 = new User(username,password);
			try {
				user = UserService.login(user1);
				if(user == null) {
					request.getRequestDispatcher("/regis.jsp").forward(request, response);
				}else {
					System.out.println("============");
					request.getSession().setAttribute("user", user);//�д��û�����session
					request.getRequestDispatcher("/indexServlet").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("session----" + user1);
			request.getRequestDispatcher("/indexServlet").forward(request, response);
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
