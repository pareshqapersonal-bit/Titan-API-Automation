package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apis.GetProductListingAPI;
import apis.VerifyAdminTokenAPI;
import apis.loginAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.ProductListingPayload;
import payloads.VerifyOtpPayload;
import utilities.PayloadBuilder;
import utilities.ResponseValidator;

@Listeners(utilities.TestListener.class)
public class GetMagentoProductListingAPITEst extends BaseTest {
	
	Response response;
	
	@Test(description = "TC_20-Verify Product List API" )
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
	
	ProductListingPayload payload =
	        PayloadBuilder.buildProductListingPayload("sunglasses");
	
	GetProductListingAPI getProductList = new GetProductListingAPI();
	response =getProductList.getMagentProductListing(mobileSpec, customerToken, payload);
	System.out.println("Product Listing response "+response.asPrettyString());
	ResponseValidator.validateStatusCode(response, 200);
	ResponseValidator.validateKeyPresent(response, "products");
	String sku= response.jsonPath().getString("products[0].sku");
	System.out.println("Product sku is "+sku);
	
	}

}
