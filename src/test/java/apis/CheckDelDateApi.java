package apis;

import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.ProductPayload;
import utilities.APILogger;

import static io.restassured.RestAssured.*;
public class CheckDelDateApi {
	
	Response response;
	
	public Response checkdel(RequestSpecification rs, ProductPayload payload)
	{
		String requestBody =
				"{\n" +
				"  \"pincode\": \"" + payload.getPincode() + "\",\n" +
				"  \"sku\": \"" + payload.getSKU() + "\"\n" +
				"}";

				APILogger.setRequest(requestBody);
				APILogger.setEndpoint(Endpoints.getDelData);
		response= given()
				.spec(rs)
				.body(payload)
			.when()
			    .post(Endpoints.getDelData)
			 .then()  
			     .log().all()
			     .extract()
			     .response();
		 APILogger.setStatusCode(response.getStatusCode());
 		APILogger.setResponse(
 	            response.asPrettyString());
		
		return response;
	}
	
	
	public Response getstores(RequestSpecification rs, ProductPayload payload)
	{
		String requestBody =
				"{\n" +
				"  \"pincode\": \"" + payload.getPincode() + "\",\n" +
				"  \"sku\": \"" + payload.getSKU() + "\"\n" +
				"}";

				APILogger.setRequest(requestBody);
				APILogger.setEndpoint(Endpoints.getStoreDaa);
		response= given()
				.spec(rs)
				.body(payload)
			.when()
			    .post(Endpoints.getStoreDaa)
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
