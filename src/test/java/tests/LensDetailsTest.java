package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apis.GetLensDetailsAPI;
import apis.GetProductListingAPI;
import apis.loginAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.ProductPayload;

import utilities.SessionManager;
@Listeners(utilities.TestListener.class)
public class LensDetailsTest extends BaseTest {
	Response response;
	
	@Test(description = "TC_008-Verify Lens Details API")
	public void getLensDetailsAPISteps()
	{
		String customerHash =
		        SessionManager.getCustomerHash();

		String authToken =
		        SessionManager.getauthToken();
		GetLensDetailsAPI gl = new GetLensDetailsAPI();
		ProductPayload wp= new ProductPayload();
		GetProductListingAPI gp = new GetProductListingAPI();
		response = gp.getProductsAPI(webSpec,"eyeglasses");
		String SKUText= response.jsonPath().getString("products[0].product_sku");
		System.out.println("SKU is "+SKUText);
		
		wp.setSKU(SKUText);
		
		 response=gl.getLensDetails(webSpec, wp,customerHash, authToken );
		System.out.println(response.asPrettyString());
	}

}
