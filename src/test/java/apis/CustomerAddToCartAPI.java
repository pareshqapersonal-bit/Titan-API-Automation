package apis;
import static io.restassured.RestAssured.*;

import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.CartPayload;
import utilities.APILogger;

public class CustomerAddToCartAPI {
	
	public Response customerAddToCart(RequestSpecification backendSpec,
            String bearerToken, CartPayload payload)
{
		
		
		String requestBody =
				"{\n" +
				"  \"cartItem\": {\n" +
				"    \"sku\": \"" + payload.getCartItem().getSku() + "\",\n" +
				"    \"qty\": " + payload.getCartItem().getQty() + ",\n" +
				"    \"quote_id\": \"" + payload.getCartItem().getQuote_id() + "\",\n" +
				"    \"product_option\": {\n" +
				"      \"extension_attributes\": {\n" +
				"        \"custom_options\": [\n" +
				"          {\n" +
				"            \"option_id\": \"" + payload.getCartItem().getProduct_option()
				                .getExtension_attributes().getCustom_options().get(0).getOption_id() + "\",\n" +
				"            \"option_value\": \"" + payload.getCartItem().getProduct_option()
				                .getExtension_attributes().getCustom_options().get(0).getOption_value() + "\"\n" +
				"          }\n" +
				"        ]\n" +
				"      }\n" +
				"    }\n" +
				"  }\n" +
				"}";
		
		APILogger.setRequest(requestBody);   
		
		
		
                 Response response= given()
                          .spec(backendSpec)
                          .header("Authorization", "Bearer " + bearerToken)
                          .header("Content-Type",
          		                "application/json")
          		        .header("Journey","Magento")
          		        .body(payload)
                        .when()
                            .post(Endpoints.customerAddToCart);
                 
                 APILogger.setStatusCode(response.getStatusCode());
         		APILogger.setResponse(
         	            response.asPrettyString());

         	    return response;
}

}
