package com.jd.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {
	private HashMap<Integer, ProductItem> productMap = new LinkedHashMap<Integer, ProductItem>();;

	private int totalMoney;
	
	 //把购物项加入到购物车里边去
    public void addProduct(Product product,int quantity) {

        //获取得到购物项
    	ProductItem productItem = productMap.get(product.getPid());
    	System.out.println("productItem----" + productItem);
        //判断购物车是否存在该购物项，如果不存在
        if (productItem == null) {

            //创建这个购物项对象,并将用户传递过来的商品作为购物项
        	productItem = new ProductItem();
        	productItem.setProduct(product);
        	
        	productItem.setQuantity(quantity);
        	int price = productItem.getPrice();//小计
        	productItem.setPrice(price);

            //把购物项加入到购物车去
            productMap.put(product.getPid(), productItem);           
        } else {

            //如果存在该购物项，将购物项的数量相加
        	int quantityall = productItem.getQuantity() + quantity;
        	productItem.setQuantity(quantityall);
        	
        	int price = productItem.getPrice();//小计
        	productItem.setPrice(price);
        }
    }
    
    public void clear(){
    	productMap.clear();
    }
    
    /**
	 * 删除指定条目
	 * @param bid
	 */
	public void delete(int pid){
		System.out.println("dele+pid--" + pid);
		productMap.remove(pid);
	}
    
    
    //购物车的总价
    public int getTotalMoney() {

        int totalMoney = 0;

        for (Map.Entry<Integer, ProductItem> me : productMap.entrySet()) {    
        	ProductItem productItem = me.getValue();//得到每个购物项
        	totalMoney += productItem.getPrice();
        }

        return totalMoney;
    }

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	//生成pid-list
	@SuppressWarnings("unchecked")
	public List getProductMapPid() {
		List list = new ArrayList();
		int pid = 0;
		 for (Map.Entry<Integer, ProductItem> me : productMap.entrySet()) {
			 pid = me.getKey();
			 System.out.println("pid+++" + pid);
			 list.add(pid);
		 }	
		return list;
		
	}
	
	//生成数量list
	public List getProductMapCount() {
		List list = new ArrayList();
		int quantity = 0;
		 for (Map.Entry<Integer, ProductItem> me : productMap.entrySet()) {
			 quantity = me.getValue().getQuantity();
			 System.out.println("Quantity+++" + quantity);
			 list.add(quantity);
		 }	
		return list;
		
	}
	
	//生成订单实体类list
	public List<Order> getOrderList(int user_id) {
		List list = this.getProductMapPid();
		List list2 = this.getProductMapCount();
		
		List<Order> listOrder = new ArrayList<Order>();
		
		for (int i = 0; i < list.size(); i++) {
			Order order = new Order();
			int pid = (Integer) list.get(i);
			int count = (Integer) list2.get(i);
			order.setPid(pid);
			order.setUser_id(user_id);
			order.setCount(count);
			listOrder.add(order);
		}
		return listOrder;
	}
	
	
	public HashMap<Integer, ProductItem> getProductMap() {
		return productMap;
	}


	public void setProductMap(HashMap<Integer, ProductItem> productMap) {
		this.productMap = productMap;
	}


//	@Override
//	public String toString() {
//		return "Cart [productMap=" + productMap + ", totalMoney=" + totalMoney + "]";
//	}
	@Override
	public String toString() {
		return "{productMap:\"" + productMap + "\",totalMoney:\"" + totalMoney + "\"}";
	}
    
	
	
}
