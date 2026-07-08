package tests;

import org.testng.annotations.Test;

import apis.CustomerAddToCartAPI;
import apis.VerifyAdminTokenAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.VerifyOtpPayload;

public class CustomerAddToCart extends BaseTest {
	Response response;
	@Test
	public void steps()
	{
		VerifyOtpPayload pd = new VerifyOtpPayload();
		VerifyAdminTokenAPI vapi = new VerifyAdminTokenAPI();
		response=vapi.verifyAdminToken(mobileSpec, pd);
		String adminToken= response.jsonPath().getString("token");
		CustomerAddToCartAPI capi = new CustomerAddToCartAPI();
	response=capi.generateCustomerCart(mobileSpec, adminToken);
	System.out.println("Response code is "+response.statusCode());
	System.out.println("Response is "+response.asPrettyString());
	
		
	}

}
