package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apis.CheckDelDateApi;
import apis.GetProductListingAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.ProductPayload;
import utilities.DataProviderUtils;
import utilities.ResponseValidator;

@Listeners(utilities.TestListener.class)
public class GetStoresApiTest extends BaseTest{
	
	Response response;
	@Test(description = "TC_012-Verify the Get Stores Api", dataProvider = "getPincode", dataProviderClass = DataProviderUtils.class)
	public void testSteps(String pincode)
	{
		CheckDelDateApi api = new CheckDelDateApi();
		GetProductListingAPI papi = new GetProductListingAPI();
		response=  papi.getProductsAPI(webSpec, "eyeglasses");
		ProductPayload payload = new ProductPayload();
		response =papi.getProductsAPI(webSpec, "eyeglasses");
		String pSku= response.jsonPath().getString("products[0].product_sku");
		payload.setSKU(pSku);
		payload.setPincode(pincode);
		response=api.getstores(webSpec, payload);
		System.out.println(response.asPrettyString());
		ResponseValidator.validateStatusCode(response, 200);
		ResponseValidator.validateKeyPresent(response, "storeList");
	}

}
