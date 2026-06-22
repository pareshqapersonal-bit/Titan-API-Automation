package tests;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Demo {
    @Test
	public void test()
	{
		
    	 baseURI="https://www.titaneyeplus.com";
    	 
    	 HashMap<String, String> payload = new HashMap<String, String>();
    	 payload.put("sku", "FT1515UFA6LGRV");
    	 payload.put("pincode", "421201");
	
		Response response = given()
				.header("Content-Type", "application/json")
				.body(payload)
				.when()
				.post("/api/cart/check-delivery");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.asPrettyString());
		
		assertEquals(response.getStatusCode(), 200);
		assertTrue(response.jsonPath().getBoolean("status"));
		Assert.assertEquals(response.jsonPath().getString("ship_by"), "tomorrow");
		
	}
}
