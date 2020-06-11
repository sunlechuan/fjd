package com.jd.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.jd.entity.Cate;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 *  dao层的操作分类表的类
 *  
 * */
public class CateDao {
   
	//获取分类表中所有的数据
	public List<Cate> findAll() throws SQLException{
		
		//1.准备sql
		String sql="SELECT * FROM cate  ";
		//2创建执行sql语句的对象queryrunner
		DataSource ds=new ComboPooledDataSource();
		QueryRunner rq=new QueryRunner(ds);
		//3执行sql语句
		return rq.query(sql, new BeanListHandler<Cate>(Cate.class));
	}
	
	//获取某分类下的商品条数
			public static Object getCidFrom(Cate cate) throws SQLException{
				
				//1.准备sql
				String sql="select * from cate where cname=?";
				//2创建执行sql语句的对象queryrunner
				DataSource ds=new ComboPooledDataSource();
				QueryRunner rq=new QueryRunner(ds);
				//3执行sql语句
				return rq.query(sql, new ScalarHandler(),cate.getCname());
		
			}
}
