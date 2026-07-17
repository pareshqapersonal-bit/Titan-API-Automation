package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apis.GetAddressListAPI;
import apis.GetShippingMethodAPI;
import apis.VerifyAdminTokenAPI;
import apis.loginAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.AddressInformationPayload;
import payloads.ShippingInformationPayload;
import payloads.VerifyOtpPayload;
import utilities.PayloadBuilder;
import utilities.ResponseValidator;

@Listeners(utilities.TestListener.class)
public class GetShippingMethodAPITest extends BaseTest {

	Response response;
	
	@Test(description = "TC_022-Verify Shipping method API")
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
	Response addressResponse =getaddress.getAddress(mobileSpec, pd1, customerToken);
	System.out.println("response is "+response.asPrettyString());
	ResponseValidator.validateStatusCode(response, 200);
	
	
	ShippingInformationPayload shippingPayload =
	        PayloadBuilder.buildShippingInformation(addressResponse);
	
	GetShippingMethodAPI shipMethod = new GetShippingMethodAPI();
	response =shipMethod.getShippingMethod(mobileSpec, customerToken, shippingPayload);
	System.out.println("Shipping method response "+response.asPrettyString());
	ResponseValidator.validateStatusCode(response, 200);
	ResponseValidator.validateKeyPresent(response, "payment");
	
	
	}
}
