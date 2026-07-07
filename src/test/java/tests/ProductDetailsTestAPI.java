package tests;

import apis.ProductDetailsAPI;
import base.BaseTest;
import payloads.ProductPayload;
import utilities.SessionManager;

public class ProductDetailsTestAPI extends BaseTest {

	@Test
	public void steps()
	{
		
		String customerHash =
		        SessionManager.getCustomerHash();

		String authToken =
		        SessionManager.getauthToken();
		ProductPayload payload= new ProductPayload();
		payload.setSKU();
		payload.setProductId(authToken);
		
		ProductDetailsAPI api = new ProductDetailsAPI();
		api.getProductDetails(mobileSpec, payload, customerHash, authToken)
		
	}
}
