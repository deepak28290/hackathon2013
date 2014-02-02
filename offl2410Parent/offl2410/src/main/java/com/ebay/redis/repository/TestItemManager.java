package com.ebay.redis.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestItemManager implements IItemDbManager {

	List<ItemData> itemDatas = null;
	List<ItemData> mobileItemDatas = null;
	List<ItemData> homeItemDataList = null;
	List<ItemData> accessoriesItemDataList = null;
	Map<String, ItemData> itemDatasMap = null;

	public TestItemManager() {
		itemDatas = new ArrayList<ItemData>();
		mobileItemDatas = new ArrayList<ItemData>();
		homeItemDataList = new ArrayList<ItemData>();
		accessoriesItemDataList = new ArrayList<ItemData>();

		itemDatasMap = new HashMap<String, ItemData>();

		saveItemData(new ItemData("Mobile Item 1", "www.ebay.com", "101",
				"img/slide-1.jpg", "100", "110", "bangalore",
				IItemDbManager.CATEGORY_MOBILE));
		saveItemData(new ItemData("Mobile Item 2", "www.ebay.com", "102",
				"img/slide-2.jpg", "100", "120", "bangalore",
				IItemDbManager.CATEGORY_MOBILE));
		saveItemData(new ItemData("Mobile Item 3", "www.ebay.com", "103",
				"img/slide-3.jpg", "100", "130", "bangalore",
				IItemDbManager.CATEGORY_MOBILE));
		saveItemData(new ItemData("Mobile Item 4", "www.ebay.com", "103",
				"img/slide-3.jpg", "100", "130", "bangalore",
				IItemDbManager.CATEGORY_MOBILE));

		saveItemData(new ItemData("Home Item 1", "www.ebay.com", "201",
				"img/slide-1.jpg", "100", "110", "bangalore",
				IItemDbManager.CATEGORY_HOME));
		saveItemData(new ItemData("Home Item 2", "www.ebay.com", "202",
				"img/slide-2.jpg", "100", "120", "bangalore",
				IItemDbManager.CATEGORY_HOME));
		saveItemData(new ItemData("Home Item 3", "www.ebay.com", "203",
				"img/slide-3.jpg", "100", "130", "bangalore",
				IItemDbManager.CATEGORY_HOME));
		saveItemData(new ItemData("Home Item 4", "www.ebay.com", "203",
				"img/slide-3.jpg", "100", "130", "bangalore",
				IItemDbManager.CATEGORY_HOME));

		saveItemData(new ItemData("Accessory Item 1", "www.ebay.com", "301",
				"img/slide-1.jpg", "100", "110", "bangalore",
				IItemDbManager.CATEGORY_ACCESSORIES));
		saveItemData(new ItemData("Accessory Item 2", "www.ebay.com", "302",
				"img/slide-2.jpg", "100", "120", "bangalore",
				IItemDbManager.CATEGORY_ACCESSORIES));
		saveItemData(new ItemData("Accessory Item 3", "www.ebay.com", "303",
				"img/slide-3.jpg", "100", "130", "bangalore",
				IItemDbManager.CATEGORY_ACCESSORIES));
		saveItemData(new ItemData("Accessory Item 4", "www.ebay.com", "303",
				"img/slide-3.jpg", "100", "130", "bangalore",
				IItemDbManager.CATEGORY_ACCESSORIES));

	}

	@Override
	public void saveItemData(ItemData id) {
		itemDatas.add(id);
		itemDatasMap.put(id.getItem_id(), id);
		if (IItemDbManager.CATEGORY_MOBILE.equals(id.getCategory())) {
			mobileItemDatas.add(id);
		} else if (IItemDbManager.CATEGORY_HOME.equals(id.getCategory())) {
			homeItemDataList.add(id);
		} else {
			accessoriesItemDataList.add(id);
		}
	}

	@Override
	public List<ItemData> getItemByCategory(String category) {
		if (IItemDbManager.CATEGORY_MOBILE.equals(category)) {
			return mobileItemDatas;
		} else if (IItemDbManager.CATEGORY_HOME.equals(category)) {
			return homeItemDataList;
		} else if (IItemDbManager.CATEGORY_ACCESSORIES.equals(category)) {
			return accessoriesItemDataList;
		} else {
			return itemDatas;
		}
	}

	@Override
	public ItemData getItemByItemId(String itemId) {
		return itemDatasMap.get(itemId);
	}
}
