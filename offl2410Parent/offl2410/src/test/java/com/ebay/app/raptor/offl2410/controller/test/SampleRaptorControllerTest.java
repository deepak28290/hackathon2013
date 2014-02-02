package com.ebay.app.raptor.offl2410.controller.test;

import java.util.HashMap;

import junit.framework.Assert;

import org.junit.Test;

import com.ebay.app.raptor.offl2410.controller.SampleRaptorController;

public class SampleRaptorControllerTest {

	
	@Test
	public void testHandleRequest(){
		try{
			SampleRaptorController  controller = new SampleRaptorController();
			HashMap<String, String> model = controller.handleRequest();
			Assert.assertEquals("Say hello to Raptor!", model.get("greeting"));
		}catch(Exception e){
			Assert.fail("Exception occured in test class "+e);
		}
	}

}
