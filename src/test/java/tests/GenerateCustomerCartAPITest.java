package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apis.CustomerAddToCartAPI;
import apis.GenerateCustomerCartAPI;
import apis.VerifyAdminTokenAPI;
import apis.loginAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.VerifyOtpPayload;
@Listeners(utilities.TestListener.class)
public class GenerateCustomerCartAPITest extends BaseTest{

	Response response;
	@Test(description = "TC_014-Verify Generate Cart API ")
	public void steps()
	{
		VerifyOtpPayload pd = new VerifyOtpPayload();
		VerifyAdminTokenAPI vapi = new VerifyAdminTokenAPI();
		response=vapi.verifyAdminToken(mobileSpec, pd);
		String adminToken= response.jsonPath().getString("token");
		loginAPI lapi = new loginAPI();
		pd.setMoble_no("8698294937");
		lapi.generateOTP(mobileSpec, pd, adminToken);
		pd.setMoble_no("8698294937");
		pd.setOtp("654321");
	response =	lapi.verifyRestOtp(mobileSpec, pd, adminToken);
	String customerToken= response.jsonPath().getString("token");
	System.out.println(customerToken);
		GenerateCustomerCartAPI gapi = new GenerateCustomerCartAPI();
	response=gapi.generateCustomerCart(mobileSpec, customerToken);
	System.out.println("Response code is "+response.statusCode());
	System.out.println("Response is "+response.asPrettyString());
	
		
	}
}
