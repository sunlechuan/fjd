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
 * 服务层的分类服务
 * */
public class CateService {
     //调用dao层的代码获取分类数据
	 @SuppressWarnings("deprecation")
	public List<Cate> findAll() throws SQLException{
		 //通过缓存获取分类数据
		 //1.创建一个缓存管理器
		 //通过io 流读取配置文件的信息，通过类加载器的将配置文件的信息加载inputstream流中。
		 InputStream in=CateService.class.getClassLoader().getResourceAsStream("ehcache.xml");
		 CacheManager cm=CacheManager.create(in);
		 //2.获取指定名称的缓存
		 Cache c1 = cm.getCache("categoryCache");  //map.put(key,value) map.get(key)
		 //3. 从缓存中获取指定的key的数据  比如：key  = clist  
		 Element element = c1.get("clist");
		 List<Cate> list;
		 if(element==null){//如果为空说明缓存中没有指定的key 的值分类的数据
			 //从数据库中获取了
			 CateDao dao=new CateDao();//第2次开始这个代码不执行，
			 list=dao.findAll();
			 //分类数据从数据库中获取的同步保存到指定的key的缓存
			 c1.put(new Element("clist",list));
			 System.out.println("数据从数据库中获取");
		 }else{
			 //缓存中有数据，分类数据
		     list=(List<Cate>)element.getValue();
		     System.out.println("数据从缓存中获取");
		 }
		 return list;
	 }
	 
	 
	 public static int getCidFrom(Cate cate) throws SQLException{
			
			
			return Integer.parseInt(CateDao.getCidFrom(cate).toString());
		}
}
