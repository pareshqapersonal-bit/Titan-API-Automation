package tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apis.GetLensDetailsAPI;
import apis.GetProductListingAPI;
import apis.ProductDetailsAPI;
import apis.VerifyAdminTokenAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.ProductPayload;
import payloads.VerifyOtpPayload;
import utilities.DataProviderUtils;
import utilities.SessionManager;

@Listeners(utilities.TestListener.class)
public class ProductDetailsTestAPI extends BaseTest {

	Response response;
	@Test(dataProvider = "getProducts",  dataProviderClass = DataProviderUtils.class,description = "TC_13-Verify Product details API" )
	public void steps(String category)
	{
		String material="";

		String customerHash =
		        SessionManager.getCustomerHash();

		String authToken =
		        SessionManager.getauthToken();

		VerifyAdminTokenAPI vapi = new VerifyAdminTokenAPI();
		VerifyOtpPayload pd = new VerifyOtpPayload();
		
		GetLensDetailsAPI gl = new GetLensDetailsAPI();
		ProductPayload payload= new ProductPayload();
		ProductDetailsAPI api = new ProductDetailsAPI();
		GetProductListingAPI gp = new GetProductListingAPI();
		response = vapi.verifyAdminToken(mobileSpec, pd);
		String AdminToken = response.jsonPath().getString("token");
		response = gp.getProductsAPI(webSpec,"Powered Sunglasses");
		
		String SKUText= response.jsonPath().getString("products[0].product_sku");
		 String productId= response.jsonPath().getString("products[0].product_id");
		System.out.println("SKU is "+SKUText);
		
		payload.setSKU(SKUText);
		payload.setProductId(productId);
		System.out.println("Product id is "+productId);
		payload.setFintMyFit("1");
		payload.setLens_width("");
		payload.setBridge_width("");
		payload.settemple_length("");
		System.out.println("url is "+mobileSpec.toString());
		
		response=api.getProductDetails(mobileSpec, payload, AdminToken);
		System.out.println("PDP response is "+response.prettyPrint());
		String optionId = response.jsonPath()
		        .getString("productData.options[0].option_id");

		String optionValue = response.jsonPath()
		        .getString("productData.options[0].values[0].option_type_id");
		
		
		System.out.println("option id id "+optionId);
		System.out.println("option value id "+optionValue);

		
	}
}
