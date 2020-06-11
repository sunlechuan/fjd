package com.jd.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jd.entity.Cart;
import com.jd.entity.Page;
import com.jd.entity.Product;
import com.jd.service.ProductService;

import net.sf.json.JSONArray;

/**
 * ��һҳ/��һҳ
 * Servlet implementation class flp2
 */
public class flp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public flp2() {
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
		int pageSize = 3;//һҳ�̶�����
		int currPage = 1;
		int cid = 0;
		cid = Integer.parseInt(request.getParameter("cid").toString());  //ǰ̨��ֵ
		currPage = Integer.parseInt(request.getParameter("currPage").toString()); //ǰ̨��ֵ
		int pre = (currPage-1)*pageSize;	//ǰ�ڼ���
		int lat =  pageSize;  	//��ڼ���
		System.out.println("pre--" + pre + "lat--" +lat);		
		List<Product> list = null;						
		try {
			list = ProductService.list(cid,pre,lat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray data = JSONArray.fromObject(list);
		System.out.println(data);
		
		Page page = (Page) request.getSession().getAttribute("page");
		
		if(page == null) {
			page = new Page();
			request.getSession().setAttribute("page", page);
		}
		page.setCurrPage(currPage);
		System.out.println("page---" + page);
		JSONArray dataPage = JSONArray.fromObject(page);
		
		request.setAttribute("data", data);
		request.setAttribute("dataPage", dataPage);
		request.setAttribute("currPage", currPage);
		response.getWriter().print(data);
		request.getRequestDispatcher("/fenye.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
