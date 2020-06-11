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
 * ��������ȡ����
 * Servlet implementation class cateServlet
 */
public class cateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //��������
		
     //���÷�������Դ����ȡ��������
		
	 //�������ݷ�����ҳ���������ݱ��浽�����
		response.setContentType("text/html;charset=utf-8");
		//������ύ����������
		request.setCharacterEncoding("utf-8");
		System.out.println("-----------");
		try {
			List<Cate> list=new CateService().findAll();
			JSONArray data = JSONArray.fromObject(list);
			System.out.println(data);
			//json��ʽ������  {name:tom,age:20}
			response.getWriter().print(data);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 //ҳ��ת������ҳ jsp��
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
