package com.ebay.redis.repository;

public class ItemManagerFactory {
	public static IItemDbManager getItemDbManager(boolean test) {
		if (test) {
			return new TestItemManager();
		} else {
			return new DBItemManager();
		}

	}
}
