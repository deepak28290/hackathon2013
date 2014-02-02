package com.ebay.redis.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBItemManager implements IItemDbManager {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public Connection getConnection() throws Exception {
		if(connect == null){
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://l-blr-00800188.corp.ebay.com/hackathon?"
							+ "user=root&password=");					
		}
		return connect;
	}

	@Override
	public void saveItemData(ItemData id) {
		try {
			Connection connect = getConnection();

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			String itemid = id.getItem_id();
			// Result set get the result of the SQL query
			resultSet = statement
					.executeQuery("select * from hackathon.ebay_offline_master where item_id="
							+ itemid);
			// writeResultSet(resultSet);
			if (!checkResultSet(resultSet)) {

				// PreparedStatements can use variables and are more efficient
				preparedStatement = connect
						.prepareStatement("insert into hackathon.ebay_offline_master values (?,?,?,?,?,?,?,?)");
				preparedStatement.setString(1, id.getItem_id());
				preparedStatement.setString(2, id.getTitle());
				preparedStatement.setString(3, id.getItem_url());
				preparedStatement.setString(4, id.getImg_url());
				preparedStatement.setString(5, id.getEbay_cost());
				preparedStatement.setString(6, id.getMy_cost());
				preparedStatement.setString(7, id.getLocation());
				preparedStatement.setString(8, id.getCategory());

				preparedStatement.executeUpdate();
			} else {
				System.out.println("Log: Entry already in DB");
			}
		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {

			}
		} finally {
			close();
		}

	}

	@Override
	public List<ItemData> getItemByCategory(String category) {

		HashMap<String, String> map = new HashMap<String, String>();
		List<ItemData> lid = new ArrayList<ItemData>();
		System.out.println(category);
		System.out.println("DBItemManager.getItemByCategory()");
		try {
			// This will load the MySQL driver, each DB has its own driver
			Connection connect = getConnection();
			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query

			System.out.println("DBItemManager.getItemByCategory() 1");
			if (category.equals(CATEGORY_ALL)) {
				resultSet = statement
						.executeQuery("select * from hackathon.ebay_offline_master");
				System.out.println("DBItemManager.getItemByCategory() 2");
			} else {
				resultSet = statement
						.executeQuery("select * from hackathon.ebay_offline_master where category=\'"
								+ category + "\'");
				System.out.println("DBItemManager.getItemByCategory() 3");
			}
			lid = writeResultSetList(resultSet);
		} catch (Exception e) {
				e.printStackTrace();
		} finally {
			close();
		}
		return lid;
	}

	@Override
	public ItemData getItemByItemId(String itemId) {

		ItemData id = new ItemData();
		try {
			// This will load the MySQL driver, each DB has its own driver
			Connection connect = getConnection();
			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement
					.executeQuery("select * from hackathon.ebay_offline_master where item_id="
							+ itemId);
			id = writeResultSet(resultSet);
		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {

			}
		} finally {
			close();
		}
		return id;
	}

	// You need to close the resultSet
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}

	}

	private List<ItemData> writeResultSetList(ResultSet resultSet)
			throws SQLException {
		System.out.println("DBItemManager.writeResultSetList()");
		// ResultSet is initially before the first data set
		HashMap<String, String> map = new HashMap<String, String>();
		ItemData id = null;
		List<ItemData> lid = new ArrayList<ItemData>();
		while (resultSet.next()) {
			System.out.println("DBItemManager.writeResultSetList() loop " );
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			if (resultSet.getString("title") == null) {
				break;
			}
			System.out.println(resultSet.getString("title"));

			map.put("item_title", resultSet.getString("title"));
			map.put("item_id", resultSet.getString("item_id"));
			map.put("item_url", resultSet.getString("item_url"));
			map.put("img_url", resultSet.getString("img_url"));
			map.put("cost", resultSet.getString("cost_ebay"));
			map.put("my_cost", resultSet.getString("my_cost"));
			map.put("location", resultSet.getString("location"));
			map.put("category", resultSet.getString("category"));
			lid.add(new ItemData(map, map.get("my_cost")));
		}
		return lid;
	}

	private ItemData writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		HashMap<String, String> map = new HashMap<String, String>();
		ItemData id = null;
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			System.out.println(resultSet.getString("title"));
			map.put("item_title", resultSet.getString("title"));
			map.put("item_id", resultSet.getString("item_id"));
			map.put("item_url", resultSet.getString("item_url"));
			map.put("img_url", resultSet.getString("img_url"));
			map.put("cost", resultSet.getString("cost_ebay"));
			map.put("my_cost", resultSet.getString("my_cost"));
			map.put("location", resultSet.getString("location"));
			map.put("category", resultSet.getString("category"));
			id = new ItemData(map, map.get("my_cost"));
			break;
		}
		return id;
	}

	private boolean checkResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		HashMap<String, String> map = new HashMap<String, String>();
		boolean isPresent = false;
		while (resultSet.next()) {
			isPresent = true;
			break;
		}
		return isPresent;
	}

	public static void main(String args[]) {

		List<ItemData> lid = new ArrayList<ItemData>();
		DBItemManager db = new DBItemManager();
		lid = db.getItemByCategory(CATEGORY_MOBILE.toString());
		System.out.println(lid.size());
		/*
		 * ItemData id=new ItemData(); DBItemManager db=new DBItemManager();
		 * db.getItemByItemId("title1"); System.out.println()
		 */
	}
}
