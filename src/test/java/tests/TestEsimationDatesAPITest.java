package tests;



import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.DataProviderUtils;
import apis.CheckDelDateApi;
import apis.GetProductListingAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.ProductPayload;
import utilities.ResponseValidator;
@Listeners(utilities.TestListener.class)
public class TestEsimationDatesAPITest extends BaseTest {
  Response response;
	
   
	@Test(description = "TC_010-Verify the Check delivery date API", dataProvider = "getPincode", dataProviderClass = DataProviderUtils.class)
	public void testSteps(String pincode)
	{
		CheckDelDateApi api = new CheckDelDateApi();
		GetProductListingAPI papi = new GetProductListingAPI();
		ProductPayload payload = new ProductPayload();
	
		response =papi.getProductsAPI(webSpec, "eyeglasses");
		String pSku= response.jsonPath().getString("products[0].product_sku");
		payload.setSKU(pSku);
		payload.setPincode(pincode);
		response=api.checkdel(webSpec, payload);
		System.out.println(response.asPrettyString());
		ResponseValidator.validateStatusCode(response, 200);
		ResponseValidator.validateKeyPresent(response, "ship_by");
		ResponseValidator.validateKeyPresent(response, "delivery_by");
		
		
	}
}
