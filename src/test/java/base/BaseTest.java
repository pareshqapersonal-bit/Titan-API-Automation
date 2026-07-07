package base;

import java.awt.Container;


import org.testng.annotations.BeforeClass;

import apis.loginAPI;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.VerifyOtpPayload;
import utilities.ConfigReader;
import utilities.SessionManager;

public class BaseTest {

	protected RequestSpecification mobileSpec;
	protected RequestSpecification backendSpec;
	protected RequestSpecification webSpec;
	protected ConfigReader config;
	protected RequestSpecification reqspec;
	
	@BeforeClass
	public void setUP()
	{
		config = new ConfigReader();
		/*
		 * reqspec = new RequestSpecBuilder() .setBaseUri(config.getProperty("baseUrl"))
		 * .setContentType(ContentType.JSON) .build();
		 */
		mobileSpec = new RequestSpecBuilder()
	            .setBaseUri(config.getProperty("mobileBaseUrl"))
	            .setContentType(ContentType.JSON)
	            .build();

	    backendSpec = new RequestSpecBuilder()
	            .setBaseUri(config.getProperty("backendBaseUrl"))
	            .setContentType(ContentType.JSON)
	            .build();

	    webSpec = new RequestSpecBuilder()
	            .setBaseUri(config.getProperty("webBaseUrl"))
	            .setContentType(ContentType.JSON)
	            .build();

		loginAPI lapi = new loginAPI();

	    VerifyOtpPayload vop =
	            new VerifyOtpPayload();

	    vop.setMoble_no("8698294937");
	    System.out.println(reqspec);
	    System.out.println(webSpec);
	    System.out.println(mobileSpec);
	    System.out.println(backendSpec);
	    lapi.sendOtp(webSpec, vop);
     
	    vop.setOtp("254265");

	    Response response =
	            lapi.verifyOtp(webSpec, vop);

	    SessionManager.setCustomerHash(
	            response.getCookie(
	                    "customerHash"));

	    SessionManager.setauthToken(
	            response.getCookie(
	                    "adobe_tep_next_auth_token"));
	}
}
