package com.jd.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jd.entity.Cart;
import com.jd.entity.Cate;
import com.jd.entity.Page;
import com.jd.entity.Product;
import com.jd.service.PageService;
import com.jd.service.ProductService;

import net.sf.json.JSONArray;

/**
 * 导航栏点击后，获取指定分类商品
 * Servlet implementation class flproductServlet
 */
public class flproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public flproductServlet() {
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
		
		System.out.println("--------------------------");
		int pageSize = 3;//一页固定三个
		int currPage = 1;
		int cid = 0;
		cid = Integer.parseInt(request.getParameter("cid").toString());
		
		System.out.println(cid + "FLcid");
		System.out.println(request.getParameter("currPage"));
		if(request.getParameter("currPage") == null){
			currPage = 1;
		}else{
			currPage = Integer.parseInt(request.getParameter("currPage").toString());
		}
		
		int pre = (currPage-1)*pageSize;
		int lat = (currPage-1)*pageSize + pageSize;  	// 1  0-3
		System.out.println("pre--" + pre + "lat--" +lat);										// 2  3-6 
		List<Product> list = null;						//3   6-9
		try {
			list = ProductService.list(cid,pre,lat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray data = JSONArray.fromObject(list);
		System.out.println(data);
		request.setAttribute("data", data);
		response.getWriter().print(data);
		
		Cate cate = new Cate();
		cate.setCid(cid);
		
		//分页：
		int totalCount = 0;
		try {
			totalCount = Integer.parseInt(PageService.getTotalCount(cate).toString());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(totalCount);
		
		int totalPage = totalCount/pageSize;
		
		if(totalPage*pageSize < totalCount) {
			totalPage+=1;
		}
		System.out.println("totalPage---" + totalPage);
		
		//Page
		Page page = new Page();
		page.setTotalCount(totalCount);//总条数
		page.setPageSize(pageSize);//一页面几个
		page.setTotalPage(totalPage);//总页数
		page.setCurrPage(currPage);;//总页数
		JSONArray dataPage = JSONArray.fromObject(page);
		System.out.println(dataPage);
		
		request.getSession().setAttribute("page", page);
		
		request.setAttribute("dataPage", dataPage);
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
