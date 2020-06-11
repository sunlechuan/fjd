package com.jd.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.jd.entity.Cate;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class PageDao {

	//获取某分类下的商品条数
		public static Object getTotalCount(Cate cate) throws SQLException{
			//1.准备sql
			String sql="select count(*) from product where cid=?";
			//2创建执行sql语句的对象queryrunner
			DataSource ds=new ComboPooledDataSource();
			QueryRunner rq=new QueryRunner(ds);
			//3执行sql语句
			return rq.query(sql, new ScalarHandler(),cate.getCid());
	
		}
}
