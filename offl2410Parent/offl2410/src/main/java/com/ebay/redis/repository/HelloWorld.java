/*package com.ebay.redis.repository;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
 
public class HelloWorld {
 
 public static void main(String[] args) {
  ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
  ItemDataRepository idRepository = (ItemDataRepository) applicationContext.getBean("idRepository");
  ItemData id1 = new ItemData("title1","item_url1","item_id1","img_url1","ebay_cost1","my_cost1","location1","category1");
  ItemData id2 = new ItemData("title2","item_url2","item_id2","img_url2","ebay_cost2","my_cost2","location2","category2");
  ItemData id3 = new ItemData("title2","item_url2","item_id2","img_url2","ebay_cost2","my_cost2","location2","category2");
  idRepository.put(id1);
  System.out.println(" Step 1 output : " + idRepository.getObjects().get(0).getEbay_cost());
  idRepository.put(id2);
  System.out.println(" Step 2 output : " + idRepository.getObjects().get(1).getEbay_cost());
  System.out.println(" Step 2 output : " + idRepository.getObjects());
  idRepository.delete(id3);
  System.out.println(" Step 3 output : " + idRepository.getObjects());
 }
}*/