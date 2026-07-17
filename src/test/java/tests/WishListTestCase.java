package tests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Listeners;

import org.testng.Assert;

import org.testng.annotations.Test;

import apis.loginAPI;
import apis.wishlistAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.ProductPayload;
import payloads.VerifyOtpPayload;

import utilities.SessionManager;


@Listeners(utilities.TestListener.class)
public class WishListTestCase extends BaseTest {
	private String productID;
	Response response;
	
	@Test(description = "TC_004-Verify the wishlist list API")
	public void getWatchlistSteps()
	{
		/*
		 * String customerHash; loginAPI lapi = new loginAPI();
		 * 
		 * VerifyOtpPayload vop = new VerifyOtpPayload(); vop.setMoble_no("8698294937");
		 * lapi.sendOtp(reqspec, vop); vop.setMoble_no("8698294937");
		 * vop.setOtp("254265"); response= lapi.verifyOtp(reqspec, vop); customerHash =
		 * response.jsonPath().getString("customerHash");
		 * 
		 * String authToken = response.getCookie("adobe_tep_next_auth_token");
		 * 
		 * SessionManager.setCustomerHash(customerHash);
		 * SessionManager.setauthToken(authToken); customerHash =
		 * response.jsonPath().getString("customerHash");
		 * System.out.println("custmerhash is"+customerHash);
		 * 
		 * System.out.println( response.getHeaders());
		 * 
		 * System.out.println( response.getCookies());
		 * 
		 * System.out.println( response.getDetailedCookies());
		 * 
		 * authToken = response.getCookie( "adobe_tep_next_auth_token");
		 * System.out.println("token is"+ authToken);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * customerHash = SessionManager.getCustomerHash();
		 * 
		 * authToken = SessionManager.getauthToken();
		 */
		
		String customerHash =
		        SessionManager.getCustomerHash();

		String authToken =
		        SessionManager.getauthToken();
		wishlistAPI wapi = new wishlistAPI();
		System.out.println("customerHash = " + customerHash);
		System.out.println("authToken = " + authToken);
		wapi.getWatchlist(webSpec, customerHash, authToken);
		response= wapi.getWatchlist(webSpec, customerHash,authToken);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
		String status=response.jsonPath().getString("status");
		String message=response.jsonPath().getString("message");
		
	}
	
	@Test(dependsOnMethods = "getWatchlistSteps",description = "TC_005-Verify the Remove from wishlist API")
	public void RemoveFromwishlistSteps()
	{
		/*
		  loginAPI lapi = new loginAPI();
		  
		  VerifyOtpPayload vop = new VerifyOtpPayload(); vop.setMoble_no("8698294937");
		  lapi.sendOtp(reqspec, vop); vop.setMoble_no("8698294937");
		  vop.setOtp("254265"); response= lapi.verifyOtp(reqspec, vop); customerHash =
		  response.jsonPath().getString("customerHash");
		  System.out.println("custmerhash is"+customerHash);
		  
		  System.out.println( response.getHeaders());
		  
		  System.out.println( response.getCookies());
		  
		  System.out.println( response.getDetailedCookies());
		  
		  String authToken = response.getCookie( "adobe_tep_next_auth_token");
		  System.out.println("token is"+ authToken);
		 
		
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
		response=wapi.getWatchlist(webSpec, customerHash, authToken);
		System.out.println("Product id response check"+ response);
		List<String> productIds =
		        response.jsonPath().getList("data.product_id");
		 productID= productIds.get(0);
		 ProductPayload wp= new ProductPayload();
		wp.setProductId(productID);
		response= wapi.removeFromFav(webSpec, wp, customerHash,authToken);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
		String status=response.jsonPath().getString("status");
		String message=response.jsonPath().getString("message");
		
		
			
	}
	
	@Test(dependsOnMethods = "RemoveFromwishlistSteps",description = "TC_006-Verify the Add to wishlist API")
	public void wishlistSteps()
	{
		/*
		  loginAPI lapi = new loginAPI();
		  
		  VerifyOtpPayload vop = new VerifyOtpPayload(); vop.setMoble_no("8698294937");
		  lapi.sendOtp(reqspec, vop); vop.setMoble_no("8698294937");
		  vop.setOtp("254265"); response= lapi.verifyOtp(reqspec, vop); customerHash =
		  response.jsonPath().getString("customerHash");
		  System.out.println("custmerhash is"+customerHash);
		  
		  System.out.println( response.getHeaders());
		  
		  System.out.println( response.getCookies());
		  
		  System.out.println( response.getDetailedCookies());
		  
		  String authToken = response.getCookie( "adobe_tep_next_auth_token");
		  System.out.println("token is"+ authToken);
		 
		
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
		ProductPayload wp= new ProductPayload();
		wp.setProductId(productID);
		response= wapi.addToFav(webSpec, wp, customerHash,authToken);
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
