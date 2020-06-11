package com.jd.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.jd.entity.Cate;
import com.jd.entity.Page;
import com.jd.service.CateService;
import com.jd.service.PageService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class fenyeServlet
 */
public class fenyeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fenyeServlet() {
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
		
		Cate cate = new Cate();
		try {
			BeanUtils.populate(cate, request.getParameterMap());
			System.out.println(cate);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int cid = CateService.getCidFrom(cate);
			cate.setCid(cid);
			JSONArray data = JSONArray.fromObject(cate);
			
			System.out.println(data);
			System.out.println(cid + "---cid");
			response.getWriter().print(data);
			
			int totalCount = Integer.parseInt(PageService.getTotalCount(cate).toString());
			System.out.println(totalCount + "---totalCount");
			int pageSize = 3;
			int totalPage = totalCount/pageSize;
			
			if(totalPage*pageSize < totalCount) {
				totalPage+=1;
			}
			System.out.println("totalPage---" + totalPage);
			Page page = new Page();
			page.setTotalCount(totalCount);//总条数
			page.setPageSize(pageSize);//一页面几个
			page.setTotalPage(totalPage);//总页数
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(cate.getCid() + "--cid");
		System.out.println(cate.getCname() + "index");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
