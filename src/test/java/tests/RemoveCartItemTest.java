package tests;

import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apis.CustomerAddToCartAPI;
import apis.GenerateCustomerCartAPI;
import apis.GetProductListingAPI;
import apis.ProductDetailsAPI;
import apis.RemoveCartItemAPI;
import apis.VerifyAdminTokenAPI;
import apis.loginAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.CartItemPayload;
import payloads.CartPayload;
import payloads.CustomOptionsPayload;
import payloads.ExtensionAttributesPayload;
import payloads.ProductOptionsPayload;
import payloads.ProductPayload;
import payloads.RemoveCartItemPayload;
import payloads.VerifyOtpPayload;
import utilities.DataProviderUtils;
import utilities.ResponseValidator;

@Listeners(utilities.TestListener.class)
public class RemoveCartItemTest extends BaseTest {
	Response response;
	@Test(dataProvider = "getProducts",  dataProviderClass = DataProviderUtils.class,description = "TC_17-Verify Remove Item from cart API" )
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
	 response = gp.getProductsAPI(webSpec, "Contact Lenses");
	 String SKUText= response.jsonPath().getString("products[0].product_sku");
	 String productId= response.jsonPath().getString("products[0].product_id");
		System.out.println("SKU is "+SKUText);
		
		
		
		ProductPayload payload= new ProductPayload();
		ProductDetailsAPI api = new ProductDetailsAPI();

		

		payload.setSKU(SKUText);
		payload.setProductId(productId);
		System.out.println("Product id is "+productId);
		payload.setFintMyFit("1");
		payload.setLens_width("");
		payload.setBridge_width("");
		payload.settemple_length("");
		System.out.println("url is "+mobileSpec.toString());
		
		response=api.getProductDetails(mobileSpec, payload, customerToken);
		System.out.println("PDP response is "+response.prettyPrint());
		String optionId = response.jsonPath()
		        .getString("productData.options[0].option_id");

		String optionValue = response.jsonPath()
		        .getString("productData.options[0].values[0].option_type_id");
		
		
		System.out.println("option id id "+optionId);
		System.out.println("option value id "+optionValue);
		
		//Payloads
		CustomOptionsPayload option = new CustomOptionsPayload();
		option.setOption_id(optionId);
		option.setOption_value(optionValue);
		
		ExtensionAttributesPayload ext = new ExtensionAttributesPayload();
		ext.setCustom_options(List.of(option));
		
		ProductOptionsPayload productOption  = new ProductOptionsPayload();
		productOption.setExtension_attributes(ext);
		System.out.println("cart id is "+quoteId);
		System.out.println("product option is "+productOption);
		CartItemPayload cartItem  = new CartItemPayload();
		cartItem.setSku(SKUText);
		cartItem.setQty(1);
		cartItem.setQuote_id(quoteId);
		cartItem.setProduct_option(productOption);

		CartPayload cartpayload = new CartPayload();
		cartpayload.setCartItem(cartItem);
		
		CustomerAddToCartAPI cacapi = new CustomerAddToCartAPI();
		response =cacapi.customerAddToCart(mobileSpec, customerToken, cartpayload);
		
		
		System.out.println("resposne is "+response.asPrettyString());
		String itemId= response.jsonPath().getString("data.item_id");
		System.out.println("itemId id "+itemId);
		RemoveCartItemPayload rPayload = new RemoveCartItemPayload();
		rPayload.setItemId(itemId);
		rPayload.setcartId(quoteId);
		rPayload.setencircleAppliedBalance("");
		rPayload.setencircleCardNumber("");
		rPayload.setiscouponApplied("");
		rPayload.setIsEncircleApplied("");
		rPayload.setisstoreCeditApplied("");
		RemoveCartItemAPI rca = new  RemoveCartItemAPI();
				response = rca.removeCartItem(mobileSpec, rPayload, customerToken);
	    System.out.println("Remove the cart "+response.asPrettyString());
		ResponseValidator.validateStatusCode(response, 200);
		ResponseValidator.validateKeyPresent(response, "message");
		
		


	
		
	}

}
