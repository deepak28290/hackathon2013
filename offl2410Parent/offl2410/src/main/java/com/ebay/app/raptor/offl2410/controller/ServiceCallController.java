package com.ebay.app.raptor.offl2410.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

	@Controller
	 @RequestMapping(value="/findItem")
	public class ServiceCallController{
	 
	   @RequestMapping(value="/",method = RequestMethod.GET)
	   public HashMap<String, String> getFIResults(ModelMap model) {
			HashMap<String, String> fiResults = new HashMap<String, String>();
			//fetch from FI service
			String itemTitle = "title1" ; 
			String imgUrl = "Url1" ; 
			String cost = "250" ; 
			String shippingDays = "4" ; 
			
			
			model.put("item_title", itemTitle);
			model.put("item_img_url", imgUrl);
			model.put("item_cost", cost);
			model.put("item_shipping", shippingDays);
			return fiResults;
	   }

	}
