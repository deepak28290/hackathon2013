package com.ebay.app.raptor.offl2410.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ebay.app.raptor.util.APIHelper;
import com.ebay.raptor.kernel.context.IRaptorContext;

import com.ebay.redis.repository.IItemDbManager;
import com.ebay.redis.repository.ItemData;
import com.ebay.redis.repository.ItemManagerFactory;


@Controller
public class SampleRaptorController {

	@Inject
	IRaptorContext raptorCtx;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public HashMap<String, String> handleRequest() {
		HashMap<String, String> model = new HashMap<String, String>();
		String helloRaptor = "Say hello to Raptor!";
		model.put("greeting", helloRaptor);
		return model;
	}  	
 	
 	@RequestMapping(value="manage", method=RequestMethod.GET)
	public HashMap<String, String> handleManageRequest() {
		HashMap<String, String> model = new HashMap<String, String>();
		String helloRaptor = "Manage Item Page";
		model.put("greeting", helloRaptor);
		return model;
	}
 	
 	@RequestMapping(value="sell", method=RequestMethod.GET)
	public @ResponseBody String handleMySaleRequest(@RequestParam("itemid") String item_id,@RequestParam("myCost") String my_item_cost,@RequestParam("category") String category) throws JSONException {
 		//to-do push to db
 		
 		HashMap<String, String> map1 = new HashMap<String, String>();

 		IItemDbManager db =ItemManagerFactory.getItemDbManager(false);
 		map1=APIHelper.getResultsByItemIdMap(item_id,category);
 		
		ItemData id=new ItemData(map1,my_item_cost);
		System.out.println(category);
		db.saveItemData(id);
		HashMap<String, String> model = new HashMap<String, String>();
		
		return "";
	}
 	
 	@RequestMapping(value="firesults")
	public @ResponseBody String handleFIRequest(@RequestParam("itemid") String item_id,@RequestParam("category") String category) {
		
 		//make service call and return json response
 		HashMap<String, String> results = new HashMap<String, String>();
 		//results=APIHelper.getResultsByItemId(item_id);
 		
 		JSONObject jsonRes=new JSONObject();
 	try{
 		jsonRes=APIHelper.getResultsByItemId(item_id,category);
 	}catch(Exception e){
 		return "empty";
 	}
		//fetch from FI service
		
		System.out.println(jsonRes.toString().replace("\\", ""));
		return jsonRes.toString().replace("\\", "");

	}

	@RequestMapping(value = "deals", method = RequestMethod.GET)
	public HashMap<String, Object> deals() {
		HashMap<String, Object> model = new HashMap<String, Object>();
		String helloRaptor = "My Items Page";
		model.put("greeting", helloRaptor);
		model.put("mobileItemDataList", ItemManagerFactory.getItemDbManager(false)
				.getItemByCategory(IItemDbManager.CATEGORY_MOBILE));
		model.put("homeItemDataList", ItemManagerFactory.getItemDbManager(false)
				.getItemByCategory(IItemDbManager.CATEGORY_HOME));
		model.put("accessoriesItemDataList", ItemManagerFactory.getItemDbManager(false)
				.getItemByCategory(IItemDbManager.CATEGORY_ACCESSORIES));
		return model;
	}

	@RequestMapping(value = "viewitem", method = RequestMethod.GET)
	public HashMap<String, Object> viewitem(@RequestParam String itemid) {
		HashMap<String, Object> model = new HashMap<String, Object>();
		String helloRaptor = "View Item Page";
		model.put("greeting", helloRaptor);
		ItemData itemData =  ItemManagerFactory.getItemDbManager(false)
				.getItemByItemId(itemid);
		model.put("itemData", itemData);
		
		model.put("relatedItemDataList", ItemManagerFactory.getItemDbManager(false)
				.getItemByCategory(itemData.getCategory()));
		
		return model;
	}

	@RequestMapping(value = "manageitem", method = RequestMethod.GET)
	public HashMap<String, String> manageitem() {
		HashMap<String, String> model = new HashMap<String, String>();
		String helloRaptor = "Manage Item Page";
		model.put("greeting", helloRaptor);
		return model;
	}
	
	@RequestMapping(value = "finditem", method = RequestMethod.GET)
	public HashMap<String, String> finditem() {
		HashMap<String, String> model = new HashMap<String, String>();
		String helloRaptor = "Find Item Page";
		model.put("greeting", helloRaptor);
		return model;
	}


	@RequestMapping(value = "printinvoice", method = RequestMethod.GET)
	public HashMap<String, String> printinvoice() {
		HashMap<String, String> model = new HashMap<String, String>();
		String helloRaptor = "Print Invoice";
		model.put("greeting", helloRaptor);
		return model;
	}

	@RequestMapping(value = "myitems", method = RequestMethod.GET)
	public HashMap<String, Object> myitems() {
		HashMap<String, Object> model = new HashMap<String, Object>();
		String helloRaptor = "My Items Page";
		model.put("greeting", helloRaptor);
		List<ItemData> itemDataList = ItemManagerFactory.getItemDbManager(false)
				.getItemByCategory(IItemDbManager.CATEGORY_ALL);
		model.put("itemDataList", itemDataList);
		return model;
	}


}
