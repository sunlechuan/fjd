package com.jd.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {
	private HashMap<Integer, ProductItem> productMap = new LinkedHashMap<Integer, ProductItem>();;

	private int totalMoney;
	
	 //�ѹ�������뵽���ﳵ���ȥ
    public void addProduct(Product product,int quantity) {

        //��ȡ�õ�������
    	ProductItem productItem = productMap.get(product.getPid());
    	System.out.println("productItem----" + productItem);
        //�жϹ��ﳵ�Ƿ���ڸù�������������
        if (productItem == null) {

            //����������������,�����û����ݹ�������Ʒ��Ϊ������
        	productItem = new ProductItem();
        	productItem.setProduct(product);
        	
        	productItem.setQuantity(quantity);
        	int price = productItem.getPrice();//С��
        	productItem.setPrice(price);

            //�ѹ�������뵽���ﳵȥ
            productMap.put(product.getPid(), productItem);           
        } else {

            //������ڸù��������������������
        	int quantityall = productItem.getQuantity() + quantity;
        	productItem.setQuantity(quantityall);
        	
        	int price = productItem.getPrice();//С��
        	productItem.setPrice(price);
        }
    }
    
    public void clear(){
    	productMap.clear();
    }
    
    /**
	 * ɾ��ָ����Ŀ
	 * @param bid
	 */
	public void delete(int pid){
		System.out.println("dele+pid--" + pid);
		productMap.remove(pid);
	}
    
    
    //���ﳵ���ܼ�
    public int getTotalMoney() {

        int totalMoney = 0;

        for (Map.Entry<Integer, ProductItem> me : productMap.entrySet()) {    
        	ProductItem productItem = me.getValue();//�õ�ÿ��������
        	totalMoney += productItem.getPrice();
        }

        return totalMoney;
    }

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	//����pid-list
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
	
	//��������list
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
	
	//���ɶ���ʵ����list
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
