package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apis.AddToCartAPI;
import apis.GetLensDetailsAPI;
import apis.GetProductListingAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.ProductPayload;
import utilities.ResponseValidator;
import utilities.SessionManager;

@Listeners(utilities.TestListener.class)
public class AddToCartSunglassesApiTest extends BaseTest{
	Response response;
	
  @Test(description = "TC_09-Verify Add to Cart sunglasseses API")
  public void addToCartSteps()
  {
	  String material="";
		String customerHash =
		        SessionManager.getCustomerHash();
		
		String authToken =
		        SessionManager.getauthToken();
		GetProductListingAPI gp = new GetProductListingAPI();
		response = gp.getProductsAPI(webSpec,"sunglasses");
		String SKUText= response.jsonPath().getString("products[0].product_sku");
		 String productId= response.jsonPath().getString("products[0].product_id");
		 ProductPayload payload = new ProductPayload();
		 payload.setPage("pdp");
		 payload.setProductId(productId);
		 System.out.println(payload.getPage()  + payload.getProductId());
		 AddToCartAPI atc = new AddToCartAPI();
		 Response response =atc.addToCartSunglasses(webSpec, payload, customerHash, authToken);
		 System.out.println(response.asPrettyString());
		 String message = response.jsonPath().getString("item[0].message");
		 System.out.println("message is "+message);
		 ResponseValidator.validateStatusCode(response, 200);
		 ResponseValidator.validateValue(response, "item[0].message", "Item added to cart successfully");
  }
}
