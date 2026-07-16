package tests;

import java.util.List;

import org.testng.annotations.Test;

import apis.CancelOrderAPI;
import apis.CustomerAddToCartAPI;
import apis.GenerateCustomerCartAPI;
import apis.GetAddressListAPI;
import apis.GetCustomerOrdersAPI;
import apis.GetProductListingAPI;
import apis.GetShippingMethodAPI;
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
import payloads.OrderListinngPayload;
import payloads.PlaceOrderPayload;
import payloads.ProductListingPayload;
import payloads.ProductOptionsPayload;
import payloads.ShippingInformationPayload;
import payloads.VerifyOtpPayload;
import utilities.PayloadBuilder;
import utilities.ResponseValidator;

public class CancelOrderAPITest extends BaseTest{
	
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
	GenerateCustomerCartAPI gapi = new GenerateCustomerCartAPI();
	response=gapi.generateCustomerCart(mobileSpec, customerToken);
	String quoteId= response.jsonPath().getString("cartId");
	System.out.println("Response code is "+response.statusCode());
	System.out.println("Response is "+response.asPrettyString());
	
	ProductListingPayload payload =
	        PayloadBuilder.buildProductListingPayload("sunglasses");
	GetProductListingAPI gp = new GetProductListingAPI();
	response =gp.getMagentProductListing(mobileSpec, customerToken, payload);
	System.out.println("Product Listing response "+response.asPrettyString());
	ResponseValidator.validateStatusCode(response, 200);
	ResponseValidator.validateKeyPresent(response, "products");
	String sku= response.jsonPath().getString("products[0].sku");
		
		//Payloads
		CustomOptionsPayload option = new CustomOptionsPayload();
		option.setOption_id("");
		option.setOption_value("");
		
		ExtensionAttributesPayload ext = new ExtensionAttributesPayload();
		ext.setCustom_options(List.of(option));
		
		ProductOptionsPayload productOption  = new ProductOptionsPayload();
		productOption.setExtension_attributes(ext);
		
		CartItemPayload cartItem  = new CartItemPayload();
		cartItem.setSku(sku);
		cartItem.setQty(1);
		cartItem.setQuote_id(quoteId);
		cartItem.setProduct_option(productOption);

		CartPayload cartpayload = new CartPayload();
		cartpayload.setCartItem(cartItem);
		
		CustomerAddToCartAPI cacapi = new CustomerAddToCartAPI();
		response =cacapi.customerAddToCart(mobileSpec, customerToken, cartpayload);


	
	
	
	
	VerifyOtpPayload pd1 = new VerifyOtpPayload();
	GetAddressListAPI getaddress= new GetAddressListAPI();
	Response addressResponse  =getaddress.getAddress(mobileSpec, pd1, customerToken);
	String customerId = addressResponse.jsonPath().getString("id");
	System.out.println("response is "+response.asPrettyString());
	ResponseValidator.validateStatusCode(response, 200);
	
	

	ShippingInformationPayload shippingPayload =
	        PayloadBuilder.buildShippingInformation(addressResponse);
	
	GetShippingMethodAPI shipMethod = new GetShippingMethodAPI();
	response =shipMethod.getShippingMethod(mobileSpec, customerToken, shippingPayload);
	System.out.println("Shipping method response "+response.asPrettyString());
		
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
		System.out.println("Rresponse of place order is "+response.asPrettyString());
	
		OrderListinngPayload orderListing = new OrderListinngPayload();
		System.out.println("customer id is "+customerId);
		orderListing.setPage(1);
		orderListing.setCustomerId(customerId);
		orderListing.setOrder_Id("");
		
		  GetCustomerOrdersAPI ordersApi= new GetCustomerOrdersAPI(); 
		  response  =ordersApi.getCustomerOrders(mobileSpec, customerToken, orderPayload);
		  System.out.println("Response of order search is "+response.asPrettyString());
		  
		  String customerGroupId = response.jsonPath()
			        .getString("orders.onlineOrder.items[0].customer_group_id");
		  System.out.println("Customer_grp_id is "+customerGroupId);
		  
		  orderListing.setCustomerGroupId(customerGroupId);
		  orderListing.setOrder_Id("14256");
		  orderListing.setReason("test");
		  CancelOrderAPI cancel = new CancelOrderAPI();
		  response =cancel.cancelOrder(mobileSpec, orderListing, customerToken);
		  System.out.println("cancel order response "+response.asPrettyString());
		  
	}

}
