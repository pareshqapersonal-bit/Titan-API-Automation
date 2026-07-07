package apis;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.ProductPayload;

import utilities.APILogger;


import static io.restassured.RestAssured.*;

import constants.Endpoints;

public class ProductDetailsAPI {
	

	public Response getProductDetails(RequestSpecification rs, ProductPayload payload, String adminToken)
	{
		
		String requestBody =
				"{\n" +
				"  \"sku\": \"" + payload.getSKU() + "\",\n" +
				"  \"product_id\": \"" + payload.getProductId() + "\",\n" +
				"  \"findMyFitFlag\": \"" + payload.getFindMyFit() + "\",\n" +
				"  \"lens_width\": " + payload.getLens_width() + ",\n" +
				"  \"bridge_width\": " + payload.getBridge_width() + ",\n" +
				"  \"temple_length\": \"" + payload.getTemple_length() + "\",\n" +
				"}";

				APILogger.setRequest(requestBody);   
		Response response = given()
				.spec(rs)
				. header("Authorization",
		                adminToken)
		        .header("Content-Type",
		                "application/json")
		        .header("Journey","Magento")
			 
		        .body(payload)
		    .when()
		       .post(Endpoints.getProductDetails)
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
