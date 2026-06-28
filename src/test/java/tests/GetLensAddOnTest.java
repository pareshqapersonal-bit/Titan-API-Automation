package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apis.GetLensDetailsAPI;
import apis.GetProductListingAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.ProductPayload;
import utilities.SessionManager;

@Listeners(utilities.TestListener.class)
public class GetLensAddOnTest extends BaseTest {
	
	Response response;
	@Test(description = "TC_07-Verify the GetAddOnLens API")
	public void getLensAddOnsSteps()
	{
		String material;
		String customerHash =
		        SessionManager.getCustomerHash();

		String authToken =
		        SessionManager.getauthToken();
		GetLensDetailsAPI gl = new GetLensDetailsAPI();
		ProductPayload wp= new ProductPayload();
		GetProductListingAPI gp = new GetProductListingAPI();
		response = gp.getProductsAPI(reqspec,"eyeglasses");
		String SKUText= response.jsonPath().getString("products[0].product_sku");
		System.out.println("SKU is "+SKUText);
		
		wp.setSKU(SKUText);
		
		 response=gl.getLensDetails(reqspec, wp,customerHash, authToken );
		 System.out.println(response.jsonPath().getMap("lens_data"));
		 System.out.println(response.jsonPath().getMap("lens_data.'Single Vision'"));
		 System.out.println(response.jsonPath().getList("lens_data.'Single Vision'.high_power"));
		 String lensSku = response.jsonPath().getString(
				    "lens_data.'Single Vision'.high_power[0].available_coatings[0].lens_sku"
				);

				System.out.println(lensSku); // XT149DW
				
		 wp.setSKU("ST149RW");
		 System.out.println("Payload is "+wp.getSKU());
		response = gl.getLensAddons(reqspec, wp, customerHash, authToken);
		System.out.println(response.asPrettyString());
		System.out.println("Lens material is "+response.jsonPath().getString("addons_data.[0].material"));
		/*
		 * if(response.jsonPath().getString("addons_data.[0].material")==null) {
		 * material =""; }
		 */
		assertTrue(response.getStatusCode()==200 , "API is not working");
	}

}
