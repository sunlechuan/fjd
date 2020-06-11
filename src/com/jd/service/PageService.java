package com.jd.service;

import java.sql.SQLException;
import com.jd.dao.PageDao;
import com.jd.entity.Cate;

public class PageService {
	
	public static Object getTotalCount(Cate cate) throws SQLException{
		return  PageDao.getTotalCount(cate);
	}
}
