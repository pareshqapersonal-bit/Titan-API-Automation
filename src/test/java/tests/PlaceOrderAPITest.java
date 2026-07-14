package tests;

import java.util.List;

import org.testng.annotations.Test;

import apis.CustomerAddToCartAPI;
import apis.GenerateCustomerCartAPI;
import apis.GetAddressListAPI;
import apis.GetProductListingAPI;
import apis.PlaceOrderAPI;
import apis.VerifyAdminTokenAPI;
import apis.loginAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.AddressPayload;
import payloads.CartItemPayload;
import payloads.CartPayload;
import payloads.CustomOptionsPayload;
import payloads.ExtensionAttributesPayload;
import payloads.PlaceOrderPayload;
import payloads.ProductOptionsPayload;
import payloads.VerifyOtpPayload;
import utilities.PayloadBuilder;
import utilities.ResponseValidator;

public class PlaceOrderAPITest extends BaseTest {
	
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
	
	GenerateCustomerCartAPI gapi = new GenerateCustomerCartAPI();
	response=gapi.generateCustomerCart(mobileSpec, customerToken);
	String quoteId= response.jsonPath().getString("cartId");
	System.out.println("Response code is "+response.statusCode());
	System.out.println("Response is "+response.asPrettyString());
	
	GetProductListingAPI gp = new GetProductListingAPI();
	 response = gp.getProductsAPI(webSpec, "eyeglasses");
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


	
	
	
	
	VerifyOtpPayload pd1 = new VerifyOtpPayload();
	GetAddressListAPI getaddress= new GetAddressListAPI();
	Response addressResponse  =getaddress.getAddress(mobileSpec, pd1, customerToken);
	System.out.println("response is "+response.asPrettyString());
	ResponseValidator.validateStatusCode(response, 200);
	
	

		
		
		AddressPayload billing =
		        PayloadBuilder.buildAddress(addressResponse, true);

		AddressPayload shipping =
		        PayloadBuilder.buildAddress(addressResponse, false);

		PlaceOrderPayload pplaceOrderPayloadayload = new PlaceOrderPayload();
		pplaceOrderPayloadayload.setPaymentMethod("titan_razorpay");
		pplaceOrderPayloadayload.setBilling_address(billing);
		pplaceOrderPayloadayload.setShipping_address(shipping);
		PlaceOrderAPI placeAPI = new PlaceOrderAPI();
		response =placeAPI.placeOrder(mobileSpec, customerToken, pplaceOrderPayloadayload);
		System.out.println("Rresponse is "+response.asPrettyString());
		
		
	}

}
