package apis;

import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.ProductPayload;
import utilities.APILogger;

import static io.restassured.RestAssured.*;

public class AddToCartAPI {
	
	Response response;
	public Response addToCartAPI(RequestSpecification rs, ProductPayload payload, String customerHash, String authToken)
	{
		String requestBody =
				"{\n" +
				"  \"addon_coatings\": \"" + payload.getAddOnCoatings() + "\",\n" +
				"  \"addon_materials\": \"" + payload.getAddon_material() + "\",\n" +
				"  \"base_lens_sku\": \"" + payload.getbase_lens_sku() + "\",\n" +
				"  \"is_dash\": " + payload.getIsDash() + ",\n" +
				"  \"lens_upgrade_added\": " + payload.getLens_upgrade_added() + ",\n" +
				"  \"material\": \"" + payload.getMaterial() + "\",\n" +
				"  \"product_id\": \"" + payload.getProductId() + "\",\n" +
				"  \"sku\": \"" + payload.getSKU() + "\",\n" +
				"  \"topup_coatings\": \"" + payload.getTopup_coatings() + "\"\n" +
				"}";

				APILogger.setRequest(requestBody);            
		
		response= given()
				.spec(rs)
				.header("Origin",
		                "https://adobe-eyeplus.newstore.co.in")
		        .header("Referer",
		                "https://adobe-eyeplus.newstore.co.in/")
				 .cookie(
			                "customerHash",
			                customerHash)
			        .cookie(
			                "adobe_tep_next_auth_token",
			                authToken)
			     .when()
			        .body(payload)
			        .post(Endpoints.getToCart)
			        .then()
			        .log().all()
			        .extract()
			        .response();
		APILogger.setStatusCode(response.getStatusCode());
		APILogger.setResponse(
	            response.asPrettyString());

		return response;
		
			        
			        
	}
	
	
	public Response addToCartSunglasses(RequestSpecification rs, ProductPayload payload, String customerHash, String authToken)
	{
		
		String requestBody =
				"{\n" +
				"  \"page\": \"" + payload.getPage() + "\",\n" +
				"  \"product_id\": \"" + payload.getProductId() + "\"\n" +
				"}";

				APILogger.setRequest(requestBody);
		
		response =given()
				.spec(rs)
				.header("Origin",
		                "https://adobe-eyeplus.newstore.co.in")
		        .header("Referer",
		                "https://adobe-eyeplus.newstore.co.in/")
				 .cookie(
			                "customerHash",
			                customerHash)
			        .cookie(
			                "adobe_tep_next_auth_token",
			                authToken)
			         .body(payload)
			      .when()
			          .post(Endpoints.addToCartSun)
		          .then()
		           .log().all()
		           .extract()
		           .response();
		            
		            APILogger.setStatusCode(response.getStatusCode());
		    		APILogger.setResponse(
		    	            response.asPrettyString());

		    		return response;
			         
	}
	
	

}
