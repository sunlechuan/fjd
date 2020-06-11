package com.jd.service;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.jd.dao.CateDao;
import com.jd.entity.Cate;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/*
 * �����ķ������
 * */
public class CateService {
     //����dao��Ĵ����ȡ��������
	 @SuppressWarnings("deprecation")
	public List<Cate> findAll() throws SQLException{
		 //ͨ�������ȡ��������
		 //1.����һ�����������
		 //ͨ��io ����ȡ�����ļ�����Ϣ��ͨ����������Ľ������ļ�����Ϣ����inputstream���С�
		 InputStream in=CateService.class.getClassLoader().getResourceAsStream("ehcache.xml");
		 CacheManager cm=CacheManager.create(in);
		 //2.��ȡָ�����ƵĻ���
		 Cache c1 = cm.getCache("categoryCache");  //map.put(key,value) map.get(key)
		 //3. �ӻ����л�ȡָ����key������  ���磺key  = clist  
		 Element element = c1.get("clist");
		 List<Cate> list;
		 if(element==null){//���Ϊ��˵��������û��ָ����key ��ֵ���������
			 //�����ݿ��л�ȡ��
			 CateDao dao=new CateDao();//��2�ο�ʼ������벻ִ�У�
			 list=dao.findAll();
			 //�������ݴ����ݿ��л�ȡ��ͬ�����浽ָ����key�Ļ���
			 c1.put(new Element("clist",list));
			 System.out.println("���ݴ����ݿ��л�ȡ");
		 }else{
			 //�����������ݣ���������
		     list=(List<Cate>)element.getValue();
		     System.out.println("���ݴӻ����л�ȡ");
		 }
		 return list;
	 }
	 
	 
	 public static int getCidFrom(Cate cate) throws SQLException{
			
			
			return Integer.parseInt(CateDao.getCidFrom(cate).toString());
		}
}
