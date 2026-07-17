package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apis.GeneralInfoAPI;
import apis.VerifyAdminTokenAPI;
import apis.loginAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.GetInfoPayload;
import payloads.VerifyOtpPayload;
import utilities.ResponseValidator;


@Listeners(utilities.TestListener.class)
public class GetInfoTest extends BaseTest {
	
	Response response;
	@Test(description = "TC_001-Verify General Info API")
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
		GetInfoPayload infoPayload = new GetInfoPayload();
		infoPayload.setEnvironment("qe");
		
		GeneralInfoAPI gApi = new GeneralInfoAPI();
		response =gApi.getGenralInfo(mobileSpec, infoPayload, customerToken);
		System.out.println("Respnse is "+response.asPrettyString());
		ResponseValidator.validateStatusCode(response, 200);
	}

}
