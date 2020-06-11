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
 *  dao��Ĳ�����������
 *  
 * */
public class CateDao {
   
	//��ȡ����������е�����
	public List<Cate> findAll() throws SQLException{
		
		//1.׼��sql
		String sql="SELECT * FROM cate  ";
		//2����ִ��sql���Ķ���queryrunner
		DataSource ds=new ComboPooledDataSource();
		QueryRunner rq=new QueryRunner(ds);
		//3ִ��sql���
		return rq.query(sql, new BeanListHandler<Cate>(Cate.class));
	}
	
	//��ȡĳ�����µ���Ʒ����
			public static Object getCidFrom(Cate cate) throws SQLException{
				
				//1.׼��sql
				String sql="select * from cate where cname=?";
				//2����ִ��sql���Ķ���queryrunner
				DataSource ds=new ComboPooledDataSource();
				QueryRunner rq=new QueryRunner(ds);
				//3ִ��sql���
				return rq.query(sql, new ScalarHandler(),cate.getCname());
		
			}
}
