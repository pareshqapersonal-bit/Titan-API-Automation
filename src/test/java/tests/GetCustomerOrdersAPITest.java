package tests;

import org.testng.annotations.Test;

import apis.GetCustomerOrdersAPI;
import apis.VerifyAdminTokenAPI;
import apis.loginAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.OrderListinngPayload;
import payloads.VerifyOtpPayload;

public class GetCustomerOrdersAPITest extends BaseTest{
	
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
	
	OrderListinngPayload orderPayload = new OrderListinngPayload();
	//orderPayload.setPage("1");
	orderPayload.setIs_Previous("0");
	//orderPayload.setOrderEntityNo("14193");
	//orderPayload.setOffline_Order_No("");
	
	GetCustomerOrdersAPI ordersApi= new GetCustomerOrdersAPI();
	 response =ordersApi.getCustomerOrders(mobileSpec, customerToken, orderPayload);
	 System.out.println("Response of order search is "+response.asPrettyString());
	
	
	
	
	}

}
