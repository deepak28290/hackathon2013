package com.ebay.redis.repository;

import java.util.List;

public interface IItemDbManager {

	public static String CATEGORY_ALL = "ALL";
	public static String CATEGORY_MOBILE = "MOBILE";
	public static String CATEGORY_HOME = "APPLIANCES";
	public static String CATEGORY_ACCESSORIES = "ACCESSORIE";

	public void saveItemData(ItemData id);

	public List<ItemData> getItemByCategory(String category);

	public ItemData getItemByItemId(String itemId);
}
