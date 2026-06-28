package apis;

import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.ProductPayload;
import utilities.APILogger;

import static io.restassured.RestAssured.*;

public class GetLensDetailsAPI {
	
	Response response;
	public Response getLensDetails(RequestSpecification rs, ProductPayload payload, String customerHash, String authToken)
	{
		
		String requestBody =
		        "{ \"product_sku\" : \""
		        + payload.getSKU()
		        + "\" }";

		APILogger.setRequest(
		        requestBody);
		
		APILogger.setEndpoint(Endpoints.getLensDetails);
		
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
				  .body(payload)
			   .when()
			      .post(Endpoints.getLensDetails)
		          .then()
		          .log().all()
		          .extract()
		          .response();

		APILogger.setStatusCode(response.getStatusCode());
		APILogger.setResponse(
	            response.asPrettyString());

	    return response;
		
	}
	
	
	public Response getLensAddons(RequestSpecification rs, ProductPayload payload, String customerHash, String authToken)
	{
		
		String requestBody =
		        "{ \"Lens_sku\" : \""
		        + payload.getLensSku()
		        + "\" }";

		APILogger.setRequest(
		        requestBody);
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
			        .body(payload)
			   .when()
			       .post(Endpoints.getLensAddons)
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
