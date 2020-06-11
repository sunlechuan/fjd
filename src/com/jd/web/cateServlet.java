package com.jd.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jd.entity.Cate;
import com.jd.service.CateService;

import net.sf.json.JSONArray;

/**
 * 导航栏获取数据
 * Servlet implementation class cateServlet
 */
public class cateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //接受请求
		
     //调用服务层的资源，获取分类数据
		
	 //分类数据反给首页，分类数据保存到域对象
		response.setContentType("text/html;charset=utf-8");
		//处理表单提交过来的数据
		request.setCharacterEncoding("utf-8");
		System.out.println("-----------");
		try {
			List<Cate> list=new CateService().findAll();
			JSONArray data = JSONArray.fromObject(list);
			System.out.println(data);
			//json格式的数据  {name:tom,age:20}
			response.getWriter().print(data);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 //页面转发到首页 jsp。
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
