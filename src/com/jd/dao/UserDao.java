package com.jd.dao;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.jd.entity.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class UserDao {
	public static User getUser(String username) throws SQLException{
		
		//1.׼��sql
		String sql="select * from user where username=?";
		//2����ִ��sql���Ķ���queryrunner
		DataSource ds=new ComboPooledDataSource();
		QueryRunner rq=new QueryRunner(ds);
		//3ִ��sql���
		return (User) rq.query(sql, new BeanHandler<User>(User.class),username);
	}
	
	public static User login(User user) throws SQLException{
		
		//1.׼��sql
		String sql="select * from user where username=? and password=?";
		//2����ִ��sql���Ķ���queryrunner
		DataSource ds=new ComboPooledDataSource();
		QueryRunner rq=new QueryRunner(ds);
		//3ִ��sql���
		return (User) rq.query(sql, new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
	}
	
	public static void saveUser(User user) throws SQLException{
		
		//1.׼��sql
		String sql="INSERT INTO fjd.user (user_id, username, PASSWORD, NAME, phone)VALUES(?, ?, ?, ?, ?);";
		//2����ִ��sql���Ķ���queryrunner
		DataSource ds=new ComboPooledDataSource();
		QueryRunner rq=new QueryRunner(ds);
		//3ִ��sql���
		
		rq.update(sql,user.getUser_id(),user.getUsername(),user.getPassword(),user.getName(),user.getPhone());
	}
	
	public static void main(String[] args) throws SQLException {
		User user = new User(4,"slc1","1","slc1","34234234");
		saveUser(user);
	}
}
