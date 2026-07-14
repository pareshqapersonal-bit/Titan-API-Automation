package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apis.GetAddressListAPI;
import apis.VerifyAdminTokenAPI;
import apis.loginAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.VerifyOtpPayload;
import utilities.ResponseValidator;

@Listeners(utilities.TestListener.class)
public class GetAddressListAPITest extends BaseTest {
	
	Response response;
	@Test
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
	System.out.println(customerToken);
	VerifyOtpPayload pd1 = new VerifyOtpPayload();
	GetAddressListAPI getaddress= new GetAddressListAPI();
	response =getaddress.getAddress(mobileSpec, pd1, customerToken);
	System.out.println("response is "+response.asPrettyString());
	ResponseValidator.validateStatusCode(response, 200);
	
	}

}
