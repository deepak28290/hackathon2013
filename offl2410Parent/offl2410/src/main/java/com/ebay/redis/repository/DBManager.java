/*package com.ebay.redis.repository;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class DBManager {
	public static ItemData id2 = new ItemData("title2","item_url2","item_id2","img_url2","ebay_cost2","my_cost2","location2","category2");
	public  static ItemData id3 = new ItemData("title23","item_url23","item_id23","img_url23","ebay_cost23","my_cost23","location23","category23");
	public static boolean pushToRedis(ItemData id1){
		try{
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
			ItemDataRepository idRepository = (ItemDataRepository) applicationContext.getBean("idRepository");
//			  ItemData id2 = new ItemData("title2","item_url2","item_id2","img_url2","ebay_cost2","my_cost2","location2","category2");
			  idRepository.put(id2);
			  idRepository.put(id3);
			  System.out.println(idRepository.getObjects().size());
			 // idRepository.put(id2);
		
		return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delFromRedis(ItemData id1){
		try{
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
			ItemDataRepository idRepository = (ItemDataRepository) applicationContext.getBean("idRepository");
//			  ItemData id2 = new ItemData("title2","item_url2","item_id2","img_url2","ebay_cost2","my_cost2","location2","category2");
			  idRepository.delete(id2);
			  System.out.println(idRepository.getObjects().size());
			 // idRepository.put(id2);
		
		return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static boolean getFromRedisByItemId(String itemId){
		try{
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
			ItemDataRepository idRepository = (ItemDataRepository) applicationContext.getBean("idRepository");
			int size=idRepository.getObjects().size();
			for(int i=0;i<size;i++){
				
			}
//			  ItemData id2 = new ItemData("title2","item_url2","item_id2","img_url2","ebay_cost2","my_cost2","location2","category2");
			 // idRepository.get(itemId);
			 // idRepository.put(id2);
		
		return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
 public static void main(String[] args) {
	 ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
	 ItemDataRepository idRepository = (ItemDataRepository) applicationContext.getBean("idRepository");
	  ItemData id1 = new ItemData("title3","item_url1","item_id1","img_url1","ebay_cost1","my_cost1","location1","category1");
	  ItemData id2 = new ItemData("title4","item_url2","item_id2","img_url2","ebay_cost2","my_cost2","location2","category2");
	  ItemData id3 = new ItemData("title5","item_url2","item_id2","img_url2","ebay_cost2","my_cost2","location2","category2");
	  idRepository.put(id1);
	  
	  System.out.println(" Step 1 output : " + idRepository.getObjects().get(0).getEbay_cost());
	  idRepository.put(id2);
	  System.out.println(idRepository.getObjects().size());
	  System.out.println(" Step 2 output : " + idRepository.getObjects().get(1).getEbay_cost());
	  System.out.println(" Step 2 output : " + idRepository.getObjects());
	  idRepository.delete(id3);
	  System.out.println(idRepository.getObjects().size());
	  System.out.println(" Step 3 output : " + idRepository.getObjects());
	  
	 getFromRedisByItemId(null);
 }
}*/