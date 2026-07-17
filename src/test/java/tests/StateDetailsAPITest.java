package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apis.StateDetailsAPI;
import apis.VerifyAdminTokenAPI;
import apis.loginAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.VerifyOtpPayload;

@Listeners(utilities.TestListener.class)
public class StateDetailsAPITest extends BaseTest{
	
Response response;

@Test(description = "TC_019-Verify State list API")
public void steps()
{  
	VerifyAdminTokenAPI adminapi = new VerifyAdminTokenAPI();
	VerifyOtpPayload pd = new VerifyOtpPayload();
	response=	adminapi.verifyAdminToken(mobileSpec, pd);
	String adminToken = response.jsonPath().getString("token");
	/*
	 * loginAPI lapi = new loginAPI(); pd.setMoble_no("8698294937");
	 * lapi.generateOTP(mobileSpec, pd, adminToken); pd.setMoble_no("8698294937");
	 * pd.setOtp("654321"); response = lapi.verifyRestOtp(mobileSpec, pd,
	 * adminToken); String customerToken= response.jsonPath().getString("token")
	 */;
	StateDetailsAPI sapi = new StateDetailsAPI();
	
	response =sapi.getStateDetails(mobileSpec,adminToken,pd );
	System.out.println(response.asPrettyString());
	
}

}
