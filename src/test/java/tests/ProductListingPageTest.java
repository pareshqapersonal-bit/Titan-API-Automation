package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apis.GetProductListingAPI;
import base.BaseTest;
import io.restassured.response.Response;
import utilities.DataProviderUtils;
@Listeners(utilities.TestListener.class)
public class ProductListingPageTest extends BaseTest {
	
	@Test(dataProvider = "getProducts",  dataProviderClass = DataProviderUtils.class, description = "TC_005-Verify the Product list API" )
	public void productListingTE(String category)
	{
		GetProductListingAPI gpa = new GetProductListingAPI();
		Response response =gpa.getProductsAPI(webSpec, category);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
		assertTrue((response.getStatusCode()==200));
		
	}

}
