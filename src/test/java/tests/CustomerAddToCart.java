package tests;

import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apis.CustomerAddToCartAPI;
import apis.GenerateCustomerCartAPI;
import apis.GetProductListingAPI;
import apis.VerifyAdminTokenAPI;
import apis.loginAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.CartItemPayload;
import payloads.CartPayload;
import payloads.CustomOptionsPayload;
import payloads.CustomerAddToCartPayload;
import payloads.ExtensionAttributesPayload;
import payloads.ProductOptionsPayload;
import payloads.ProductPayload;
import payloads.VerifyOtpPayload;
import utilities.DataProviderUtils;
import utilities.ResponseValidator;
@Listeners(utilities.TestListener.class)
public class CustomerAddToCart extends BaseTest {
	Response response;
	@Test(dataProvider = "getProducts",  dataProviderClass = DataProviderUtils.class,description = "TC_15-Verify Add to cart API" )
	public void steps(String category)
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
		GenerateCustomerCartAPI gapi = new GenerateCustomerCartAPI();
	response=gapi.generateCustomerCart(mobileSpec, customerToken);
	String quoteId= response.jsonPath().getString("cartId");
	System.out.println("Response code is "+response.statusCode());
	System.out.println("Response is "+response.asPrettyString());
	
	GetProductListingAPI gp = new GetProductListingAPI();
	 response = gp.getProductsAPI(webSpec, category);
	 String SKUText= response.jsonPath().getString("products[0].product_sku");
		System.out.println("SKU is "+SKUText);
		
		//Payloads
		CustomOptionsPayload option = new CustomOptionsPayload();
		option.setOption_id("");
		option.setOption_value("");
		
		ExtensionAttributesPayload ext = new ExtensionAttributesPayload();
		ext.setCustom_options(List.of(option));
		
		ProductOptionsPayload productOption  = new ProductOptionsPayload();
		productOption.setExtension_attributes(ext);
		
		CartItemPayload cartItem  = new CartItemPayload();
		cartItem.setSku(SKUText);
		cartItem.setQty(1);
		cartItem.setQuote_id(quoteId);
		cartItem.setProduct_option(productOption);

		CartPayload payload = new CartPayload();
		payload.setCartItem(cartItem);
		
		CustomerAddToCartAPI cacapi = new CustomerAddToCartAPI();
		response =cacapi.customerAddToCart(mobileSpec, customerToken, payload);
		
		
		System.out.println("resposne is "+response.asPrettyString());
		
		ResponseValidator.validateStatusCode(response, 200);
		ResponseValidator.validateKeyPresent(response, "message");
		


	
		
	}

}
