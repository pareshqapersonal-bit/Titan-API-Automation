package tests;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;

import apis.loginAPI;
import base.BaseTest;
import constants.Endpoints;
import io.restassured.response.Response;
import payloads.VerifyOtpPayload;
import utilities.ConfigReader;

public class Login extends BaseTest{
	
	
	Response rs;
	private String customerID;
	private String customerHash;
	loginAPI sendOtp = new loginAPI();
	
	@Test(description = "TC_001-Verify Send OTP API ")
	public void stepsofSendOTP()
	{
		VerifyOtpPayload vop = new VerifyOtpPayload();
		vop.setMoble_no("8698294937");
		
		
		rs =sendOtp.sendOtp(reqspec, vop);
		
		System.out.println(rs.getStatusCode());
		System.out.println(rs.getBody());
		
	}
	
	@Test(dependsOnMethods = "stepsofSendOTP", description = "TC_002-Verify OTP API testing")
	public void steps()
	{
		
		VerifyOtpPayload vop= new VerifyOtpPayload();
		vop.setMoble_no("8698294937");
		vop.setOtp("254265");
		
		rs = sendOtp.verifyOtp(webSpec, vop);
		
		System.out.println(rs.getStatusCode());
		System.out.println(rs.getBody().asPrettyString());
		
		customerID = rs.jsonPath().getString("customerID");
		customerHash = rs.jsonPath().getString("customerHash");
		System.out.println("customer id is"+customerID);
		System.out.println("customer hash is"+customerHash);
		Assert.assertNotNull(customerID);
		Assert.assertNotNull(customerHash);
		
		
		
	}

}
