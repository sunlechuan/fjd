package com.jd.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.jd.entity.Cate;
import com.jd.entity.Product;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ProductDao {

	public static List<Product> findAll() throws SQLException{
		
		//1.准备sql
		String sql="SELECT * FROM product  ";
		//2创建执行sql语句的对象queryrunner
		DataSource ds=new ComboPooledDataSource();
		QueryRunner rq=new QueryRunner(ds);
		//3执行sql语句
		return rq.query(sql, new BeanListHandler<Product>(Product.class));
	}
	
	//获取某分类下的商品
	public static List<Product> list(int cid,int pre,int lat) throws SQLException{
		
		//1.准备sql
		String sql="select * from product where cid=?  LIMIT ?,?";
		//2创建执行sql语句的对象queryrunner
		DataSource ds=new ComboPooledDataSource();
		QueryRunner rq=new QueryRunner(ds);
		//3执行sql语句
		return rq.query(sql, new BeanListHandler<Product>(Product.class),cid,pre,lat);
	}
	//获取某商品详细信息
		public static Product getProduct(int pid) throws SQLException{
			
			//1.准备sql
			String sql="select * from product where pid=?";
			//2创建执行sql语句的对象queryrunner
			DataSource ds=new ComboPooledDataSource();
			QueryRunner rq=new QueryRunner(ds);
			//3执行sql语句
			return (Product) rq.query(sql, new BeanHandler<Product>(Product.class),pid);
		}
		
		
		public static void main(String[] args) throws SQLException {
			System.out.println(getProduct(1));
		}
}
