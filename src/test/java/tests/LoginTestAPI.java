package tests;

import static io.restassured.RestAssured.requestSpecification;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apis.VerifyAdminTokenAPI;
import apis.loginAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.VerifyOtpPayload;
import utilities.ResponseValidator;
@Listeners(utilities.TestListener.class)
public class LoginTestAPI extends BaseTest {
	Response response;
	@Test(description = "TC_002-Verify Generate OTP API ")
	public void stepsofgenerateOTP()
	{
		VerifyOtpPayload vop = new VerifyOtpPayload();
		loginAPI lp = new loginAPI();
		VerifyAdminTokenAPI vpa = new VerifyAdminTokenAPI();
		response =vpa.verifyAdminToken(mobileSpec, vop);
		String adminToken = response.jsonPath().getString("token");
		vop.setMoble_no(testMobileNumber);
		response =lp.generateOTP(mobileSpec, vop, adminToken);
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		ResponseValidator.validateStatusCode(response, 200);
		ResponseValidator.validateKeyPresent(response, "message");
		
	}
	
	
	@Test(dependsOnMethods = "stepsofgenerateOTP", description = "TC_003-Verify OTP API testing")
	public void steps()
	{
		loginAPI lp = new loginAPI();
		VerifyOtpPayload vop= new VerifyOtpPayload();
		vop.setMoble_no(testMobileNumber);
		vop.setOtp(testOTP);
		VerifyAdminTokenAPI vpa = new VerifyAdminTokenAPI();
		response =vpa.verifyAdminToken(mobileSpec, vop);
		String adminToken = response.jsonPath().getString("token");
		response = lp.verifyRestOtp(mobileSpec, vop, adminToken);
		System.out.println("Response is "+response.asPrettyString());
		
		ResponseValidator.validateStatusCode(response, 200);
		ResponseValidator.validateKeyPresent(response, "customer_id");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
		
		String customerID = response.jsonPath().getString("customer_id");
		System.out.println("customer id is"+customerID);
		
		
		
		
	}

}
