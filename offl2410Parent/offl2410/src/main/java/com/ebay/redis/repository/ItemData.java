package com.ebay.redis.repository;

import java.util.HashMap;

public class ItemData implements DomainObject {
	public static final String OBJECT_KEY = "ITEM";

	public ItemData() {
	}

	public ItemData(String title, String item_url, String item_id,
			String img_url, String ebay_cost, String my_cost, String location,
			String category) {
		this.setTitle(title);
		this.setItem_url(item_url);
		this.setItem_id(item_id);
		this.setImg_url(img_url);
		this.setEbay_cost(ebay_cost);
		this.setMy_cost(my_cost);
		this.setLocation(location);
		this.setCategory(category);
	}
	public ItemData(HashMap<String,String> map,String myCost) {
		this.setTitle(map.get("item_title"));
		this.setItem_url(map.get("item_url"));
		this.setItem_id(map.get("item_id"));
		this.setImg_url(map.get("img_url"));
		this.setEbay_cost(map.get("cost"));
		this.setMy_cost(myCost);
		this.setLocation(map.get("location"));
		this.setCategory(map.get("category"));
	}
	private String title;
	private String item_url;
	private String item_id;
	private String img_url;
	private String img_url1;
	private String img_url2;
	private String ebay_cost;
	private String my_cost;
	private String location;
	private String category;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the item_url
	 */
	public String getItem_url() {
		return item_url;
	}

	/**
	 * @param item_url
	 *            the item_url to set
	 */
	public void setItem_url(String item_url) {
		this.item_url = item_url;
	}

	/**
	 * @return the item_id
	 */
	public String getItem_id() {
		return item_id;
	}

	/**
	 * @param item_id
	 *            the item_id to set
	 */
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	/**
	 * @return the img_url
	 */
	public String getImg_url() {
		return img_url;
	}

	public String getImg_url1() {
		return img_url; //TBD
	}

	public void setImg_url1(String img_url1) {
		this.img_url1 = img_url1;
	}

	public String getImg_url2() {
		return img_url; //TBD
	}

	public void setImg_url2(String img_url2) {
		this.img_url2 = img_url2;
	}

	
	/**
	 * @param img_url
	 *            the img_url to set
	 */
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	/**
	 * @return the ebay_cost
	 */
	public String getEbay_cost() {
		return ebay_cost;
	}

	/**
	 * @param ebay_cost
	 *            the ebay_cost to set
	 */
	public void setEbay_cost(String ebay_cost) {
		this.ebay_cost = ebay_cost;
	}

	/**
	 * @return the my_cost
	 */
	public String getMy_cost() {
		return my_cost;
	}

	/**
	 * @param my_cost
	 *            the my_cost to set
	 */
	public void setMy_cost(String my_cost) {
		this.my_cost = my_cost;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String getKey() {
		return getItem_id();
	}

	@Override
	public String getObjectKey() {
		return OBJECT_KEY;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	public int getProfit() {
		int profit = -1;
		try {
			System.out.println("ItemData.getProfit()" + ebay_cost);
			System.out.println("ItemData.getProfit()" + my_cost);
			float ebaycost = Float.parseFloat(ebay_cost.trim());
			float mycost = Float.parseFloat(my_cost.trim());
			profit = (int) ((mycost - ebaycost) * 100 / ebaycost);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profit;
	}
}
