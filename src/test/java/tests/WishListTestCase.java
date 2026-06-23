package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Listeners;

import org.testng.Assert;

import org.testng.annotations.Test;

import apis.loginAPI;
import apis.wishlistAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.VerifyOtpPayload;
import payloads.WishListPayload;
import utilities.SessionManager;


@Listeners(utilities.TestListener.class)
public class WishListTestCase extends BaseTest {
	
	Response response;
	
	
	@Test
	public void wishlistSteps()
	{
		/*
		 * loginAPI lapi = new loginAPI();
		 * 
		 * VerifyOtpPayload vop = new VerifyOtpPayload(); vop.setMoble_no("8698294937");
		 * lapi.sendOtp(reqspec, vop); vop.setMoble_no("8698294937");
		 * vop.setOtp("254265"); response= lapi.verifyOtp(reqspec, vop); customerHash =
		 * response.jsonPath().getString("customerHash");
		 * System.out.println("custmerhash is"+customerHash);
		 * 
		 * System.out.println( response.getHeaders());
		 * 
		 * System.out.println( response.getCookies());
		 * 
		 * System.out.println( response.getDetailedCookies());
		 * 
		 * String authToken = response.getCookie( "adobe_tep_next_auth_token");
		 * System.out.println("token is"+ authToken);
		 */
		
		/*
		 * response = lapi.checkSessionAPI(reqspec,customerHash);
		 * 
		 * 
		 * 
		 * 
		 * System.out.println( "Status : " + response.getStatusCode());
		 * 
		 * System.out.println( "Headers : " + response.getHeaders());
		 * 
		 * System.out.println( "Cookies : " + response.getCookies());
		 * 
		 * response.prettyPrint();
		 * 
		 * 
		 * 
		 * 
		 * String cookie = response.getCookie("adobe_tep_next_auth_token");
		 * System.out.println("cookie name is"+ cookie);
		 */
		
		String customerHash =
		        SessionManager.getCustomerHash();

		String authToken =
		        SessionManager.getauthToken();
		wishlistAPI wapi = new wishlistAPI();
		WishListPayload wp= new WishListPayload();
		wp.setProductId("2029");
		response= wapi.addToFav(reqspec, wp, customerHash,authToken);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
		String status=response.jsonPath().getString("status");
		String message=response.jsonPath().getString("message");
		String expectedMessage="Product is already added in wishlist";
		if(status.equalsIgnoreCase("false"))
		{
			Assert.assertEquals(message, expectedMessage);
		}else {
			Assert.assertTrue(status.equalsIgnoreCase("true"), "Something went wrong");
		}
		
	}
	

}
