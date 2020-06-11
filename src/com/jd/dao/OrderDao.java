package com.jd.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.jd.entity.Order;
import com.jd.entity.OrderItem;
import com.jd.entity.Product;
import com.jd.entity.ProductItem;
import com.jd.entity.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class OrderDao {
	//������Ϣ�������ݿ�
	public static void saveOrder(Order order) throws SQLException{
			
			//1.׼��sql
			String sql="INSERT INTO fjd.order (bid, pid, count, user_id,address)VALUES(?, ?, ?, ?, ?);";
			//2����ִ��sql���Ķ���queryrunner
			DataSource ds=new ComboPooledDataSource();
			QueryRunner rq=new QueryRunner(ds);
			//3ִ��sql���
			
			rq.update(sql,order.getBid(),order.getPid(),order.getCount(),order.getUser_id(),order.getAddress());
		}
	
	public static List<OrderItem> listOrder(int user_id) throws SQLException{
		
		//1.׼��sql
		String sql="SELECT * FROM product INNER JOIN `order` ON product.pid = `order`.pid AND user_id = ?";
		//2����ִ��sql���Ķ���queryrunner
		DataSource ds=new ComboPooledDataSource();
		QueryRunner rq=new QueryRunner(ds);
		//3ִ��sql���
		return rq.query(sql, new BeanListHandler<OrderItem>(OrderItem.class),user_id);
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.println(listOrder(1));
	}
}
