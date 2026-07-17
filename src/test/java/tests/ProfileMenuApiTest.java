package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apis.ProfileMenuAPI;
import apis.VerifyAdminTokenAPI;
import apis.loginAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.VerifyOtpPayload;
import utilities.ResponseValidator;

@Listeners(utilities.TestListener.class)
public class ProfileMenuApiTest extends BaseTest{
	
	Response response;
	
	@Test(description = "TC_025-Verify Profile Menu API")
	public void steps()
	{
		
		VerifyOtpPayload pd = new VerifyOtpPayload();
		VerifyAdminTokenAPI vapi = new VerifyAdminTokenAPI();
		response=vapi.verifyAdminToken(mobileSpec, pd);
		String adminToken= response.jsonPath().getString("token");
		loginAPI lapi = new loginAPI();
		pd.setMoble_no(testMobileNumber);
		lapi.generateOTP(mobileSpec, pd, adminToken);
		pd.setMoble_no(testMobileNumber);
		pd.setOtp(testOTP);
	response =	lapi.verifyRestOtp(mobileSpec, pd, adminToken);
	String customerToken= response.jsonPath().getString("token");
	
	ProfileMenuAPI pApi = new ProfileMenuAPI();
	response =pApi.getProfileMenu(mobileSpec, customerToken, pd);
	System.out.println("Response is "+response.asPrettyString());
	ResponseValidator.validateStatusCode(response, 200);
	ResponseValidator.validateValue(response, "message", "menu data.");
	}

}
