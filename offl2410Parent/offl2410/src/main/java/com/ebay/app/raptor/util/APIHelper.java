package com.ebay.app.raptor.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class APIHelper {

	
	public static JSONObject getResultsByItemId(String item_id,String category){
		String api_url="http://open.api.ebay.com/shopping?callname=GetSingleItem&responseencoding=JSON&appid=Ebaya3a9b-4c45-47f0-8756-92adc8896c3&siteid=0&version=515&ItemID="+item_id;
		System.out.println(api_url);
		 // Create a method instance.
	    HttpClient client=new HttpClient();
		GetMethod method = new GetMethod(api_url);
	    HashMap<String,String> responseMap=new HashMap<String, String>();
	    JSONObject responseJson=new JSONObject();
	    // Provide custom retry handler is necessary
	    method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
	    		new DefaultHttpMethodRetryHandler(3, false));

	    try {
	      // Execute the method.
	      int statusCode = client.executeMethod(method);

	      if (statusCode != HttpStatus.SC_OK) {
	        System.err.println("Method failed: " + method.getStatusLine());
	      }

	      // Read the response body.
	      byte[] responseBody = method.getResponseBody();
	      ObjectMapper jsonMapper = new ObjectMapper();
	       jsonMapper.writeValueAsString(responseBody);
	      HashMap<String,String> map = new HashMap<String,String>();
	     

	       map = jsonMapper.readValue(responseBody, HashMap.class);
	       String jsonString=new String(responseBody);
	       // Deal with the response.
	       
	       JsonParser jsonParser = new JsonParser();
	       JsonObject jo = (JsonObject)jsonParser.parse(jsonString);
	       JsonElement je=jo.get("Item");
	       JsonObject jo1=je.getAsJsonObject();
	      String costInUsd=jo1.get("ConvertedCurrentPrice").getAsJsonObject().get("Value").toString();
	      double costInINR = Double.parseDouble(costInUsd)*62;
	      int roundedOffINR = (int)Math.round(costInINR);
	      String imgSecUrl1=jo1.get("GalleryURL").toString().replace("\"","");
	      String imgSecUrl2=null;
	      String imgSecUrl3=null;
	     try{
	       imgSecUrl2=jo1.get("PictureURL").getAsJsonArray().get(0).getAsString();
	       imgSecUrl3=jo1.get("PictureURL").getAsJsonArray().get(1).getAsString();
	     }catch(Exception e){
	    	 
	     }
	     String imgUrl=imgSecUrl1+"---"+imgSecUrl2+"---"+imgSecUrl3;
	     System.out.println(imgUrl);
	      
	      
	      responseMap.put("item_id",jo1.get("ItemID").toString().replace("\"", ""));
	      responseMap.put("location",jo1.get("Location").toString().replace("\"", ""));
	      responseMap.put("item_title",jo1.get("Title").toString().replace("\"", ""));
	      responseMap.put("img_url",jo1.get("GalleryURL").toString().replace("\"", ""));
	      
	      responseMap.put("cost",roundedOffINR+"");
	      responseMap.put("item_url",jo1.get("ViewItemURLForNaturalSearch").toString().replace("\"", ""));
	      responseMap.put("category", category);//get category from view
	      
	      
	      responseJson.put("item_id",jo1.get("ItemID").toString().replace("\"", ""));
	      responseJson.put("location",jo1.get("Location").toString().replace("\"", ""));
	      responseJson.put("item_title",jo1.get("Title").toString().replace("\"", ""));
	      responseJson.put("img_url",imgUrl);
	      
	      responseJson.put("cost",roundedOffINR+"".replace("\"", ""));
	      responseJson.put("item_url",jo1.get("ViewItemURLForNaturalSearch").toString().replace("\"", ""));
	      responseJson.put("category", category);//get category from view
	      // Use caution: ensure correct character encoding and is not binary data
	      
	    } catch (HttpException e) {
	      System.err.println("Fatal protocol violation: " + e.getMessage());
	      e.printStackTrace();
	    } catch (IOException e) {
	      System.err.println("Fatal transport error: " + e.getMessage());
	      e.printStackTrace();
	    } catch (JSONException e) {
		      System.err.println("Fatal transport error: " + e.getMessage());
		      e.printStackTrace();
		    }finally {
	      // Release the connection.
	      method.releaseConnection();
	    }
	    return responseJson;
		
		
	}

	public static  HashMap<String,String> getResultsByItemIdMap(String item_id,String category){
		String api_url="http://open.api.ebay.com/shopping?callname=GetSingleItem&responseencoding=JSON&appid=Ebaya3a9b-4c45-47f0-8756-92adc8896c3&siteid=0&version=515&ItemID="+item_id;
		System.out.println(api_url);
		 // Create a method instance.
	    HttpClient client=new HttpClient();
		GetMethod method = new GetMethod(api_url);
	    HashMap<String,String> responseMap=new HashMap<String, String>();
	    JSONObject responseJson=new JSONObject();
	    // Provide custom retry handler is necessary
	    method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
	    		new DefaultHttpMethodRetryHandler(3, false));

	    try {
	      // Execute the method.
	      int statusCode = client.executeMethod(method);

	      if (statusCode != HttpStatus.SC_OK) {
	        System.err.println("Method failed: " + method.getStatusLine());
	      }

	      // Read the response body.
	      byte[] responseBody = method.getResponseBody();
	      ObjectMapper jsonMapper = new ObjectMapper();
	       jsonMapper.writeValueAsString(responseBody);
	      HashMap<String,String> map = new HashMap<String,String>();
	     

	       map = jsonMapper.readValue(responseBody, HashMap.class);
	       String jsonString=new String(responseBody);
	       // Deal with the response.
	       
	       JsonParser jsonParser = new JsonParser();
	       JsonObject jo = (JsonObject)jsonParser.parse(jsonString);
	       JsonElement je=jo.get("Item");
	       JsonObject jo1=je.getAsJsonObject();
	      String costInUsd=jo1.get("ConvertedCurrentPrice").getAsJsonObject().get("Value").toString();
	      double costInINR = Double.parseDouble(costInUsd)*62;
	      int roundedOffINR = (int)Math.round(costInINR);
	      
	      String imgSecUrl1=jo1.get("GalleryURL").toString().replace("\"","");
	      String imgSecUrl2=null;
	      String imgSecUrl3=null;
	     try{
	       imgSecUrl2=jo1.get("PictureURL").getAsJsonArray().get(0).getAsString();
	       imgSecUrl3=jo1.get("PictureURL").getAsJsonArray().get(1).getAsString();
	     }catch(Exception e){
	    	 
	     }
	     String imgUrl=imgSecUrl1+"---"+imgSecUrl2+"---"+imgSecUrl3;
	     System.out.println(imgUrl);
	      
	      responseMap.put("item_id",jo1.get("ItemID").toString().replace("\"", ""));
	      responseMap.put("location",jo1.get("Location").toString().replace("\"", ""));
	      responseMap.put("item_title",jo1.get("Title").toString().replace("\"", ""));
	      responseMap.put("img_url",imgUrl);
	      
	      responseMap.put("cost",roundedOffINR+"");
	      responseMap.put("item_url",jo1.get("ViewItemURLForNaturalSearch").toString().replace("\"", ""));
	      responseMap.put("category", category);//get category from view
	      
	      
	      responseJson.put("item_id",jo1.get("ItemID").toString().replace("\"", ""));
	      responseJson.put("location",jo1.get("Location").toString().replace("\"", ""));
	      responseJson.put("item_title",jo1.get("Title").toString().replace("\"", ""));
	      responseJson.put("img_url",imgUrl);
	      
	      responseJson.put("cost",roundedOffINR+"".replace("\"", ""));
	      responseJson.put("item_url",jo1.get("ViewItemURLForNaturalSearch").toString().replace("\"", ""));
	      responseJson.put("category", category);//get category from view
	      // Use caution: ensure correct character encoding and is not binary data
	      
	    } catch (HttpException e) {
	      System.err.println("Fatal protocol violation: " + e.getMessage());
	      e.printStackTrace();
	    } catch (IOException e) {
	      System.err.println("Fatal transport error: " + e.getMessage());
	      e.printStackTrace();
	    } catch (JSONException e) {
		      System.err.println("Fatal transport error: " + e.getMessage());
		      e.printStackTrace();
		    }finally {
	      // Release the connection.
	      method.releaseConnection();
	    }
	    return responseMap;
		
		
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		String api_url="http://open.api.ebay.com/shopping?callname=GetSingleItem&responseencoding=JSON&appid=Ebaya3a9b-4c45-47f0-8756-92adc8896c3&siteid=0&version=515&ItemID=360769735325";
		System.out.println(api_url);
		 // Create a method instance.
	    HttpClient client=new HttpClient();
		GetMethod method = new GetMethod(api_url);
	    HashMap<String,String> responseMap=new HashMap<String, String>();
	    // Provide custom retry handler is necessary
	    method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
	    		new DefaultHttpMethodRetryHandler(3, false));

	    try {
	      // Execute the method.
	      int statusCode = client.executeMethod(method);

	      if (statusCode != HttpStatus.SC_OK) {
	        System.err.println("Method failed: " + method.getStatusLine());
	      }

	      // Read the response body.
	      byte[] responseBody = method.getResponseBody();
	      ObjectMapper jsonMapper = new ObjectMapper();
	       jsonMapper.writeValueAsString(responseBody);
	      HashMap<String,String> map = new HashMap<String,String>();
	     

	       map = jsonMapper.readValue(responseBody, HashMap.class);
	       String jsonString=new String(responseBody);
	       // Deal with the response.
	       System.out.println(jsonString);
	       
	       JsonParser jsonParser = new JsonParser();
	       JsonObject jo = (JsonObject)jsonParser.parse(jsonString);
	       JsonElement je=jo.get("Item");
	       JsonObject jo1=je.getAsJsonObject();
	      String costInUsd=jo1.get("ConvertedCurrentPrice").getAsJsonObject().get("Value").toString();
	      String imgSecUrl1=jo1.get("GalleryURL").toString().replace("\"","");
	      String imgSecUrl2=null;
	      String imgSecUrl3=null;
	     try{
	       imgSecUrl2=jo1.get("PictureURL").getAsJsonArray().get(0).getAsString();
	       imgSecUrl3=jo1.get("PictureURL").getAsJsonArray().get(1).getAsString();
	     }catch(Exception e){
	    	 
	     }
	     String imgUrl=imgSecUrl1+","+imgSecUrl2+","+imgSecUrl3;
	     System.out.println(imgUrl);
	      int costInINR=Integer.parseInt(costInUsd.split("\\.")[0])*55;
	      responseMap.put("item_id",jo1.get("ItemID").toString());
	      responseMap.put("location",jo1.get("Location").toString());
	      responseMap.put("img_url",imgUrl);
	      
	      responseMap.put("cost",costInINR+"");
	      responseMap.put("item_url",jo1.get("ViewItemURLForNaturalSearch").toString());
	      // Use caution: ensure correct character encoding and is not binary data
	      System.out.println(new String(responseBody));
	      
	    } catch (HttpException e) {
	      System.err.println("Fatal protocol violation: " + e.getMessage());
	      e.printStackTrace();
	    } catch (IOException e) {
	      System.err.println("Fatal transport error: " + e.getMessage());
	      e.printStackTrace();
	    } finally {
	      // Release the connection.
	      method.releaseConnection();
	    }
	}
	
}
