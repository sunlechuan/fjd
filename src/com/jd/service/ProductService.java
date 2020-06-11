package com.jd.service;

import java.sql.SQLException;
import java.util.List;

import com.jd.dao.ProductDao;
import com.jd.entity.Product;

public class ProductService {

	public static List<Product> list(int cid,int pre,int lat) throws SQLException{
		return ProductDao.list(cid,pre,lat);
	}
	
	public static Product getProduct(int pid) throws SQLException{
		return ProductDao.getProduct(pid);
	}
	
	public static List<Product> findAll() throws SQLException{
		return ProductDao.findAll();
	}
}
