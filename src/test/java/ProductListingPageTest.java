import org.testng.annotations.Test;

import apis.GetProductListingAPI;
import base.BaseTest;
import io.restassured.response.Response;
import utilities.DataProviderUtils;

public class ProductListingPageTest extends BaseTest {
	
	@Test(dataProvider = "getProducts",  dataProviderClass = DataProviderUtils.class )
	public void productListingTE(String category)
	{
		GetProductListingAPI gpa = new GetProductListingAPI();
		Response response =gpa.getProductsAPI(reqspec, category);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
	}

}
