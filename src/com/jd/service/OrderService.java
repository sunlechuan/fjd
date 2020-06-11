package com.jd.service;

import java.sql.SQLException;
import java.util.List;

import com.jd.dao.OrderDao;
import com.jd.entity.Order;
import com.jd.entity.OrderItem;

public class OrderService {

	public static void saveOrder(Order order) throws SQLException{
		OrderDao.saveOrder(order);
	}
	public static List<OrderItem> listOrder(int user_id) throws SQLException{
		return OrderDao.listOrder(user_id);
	}
}
