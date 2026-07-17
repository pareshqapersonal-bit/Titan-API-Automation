package apis;

import static io.restassured.RestAssured.given;

import constants.Endpoints;
import io.restassured.specification.RequestSpecification;
import payloads.VerifyOtpPayload;
import utilities.APILogger;
import io.restassured.response.Response;
public class GetStoreLocatorTopCitiesApi {
	
	Response response;
	
	public Response getstorelocatortopCities(RequestSpecification rs, VerifyOtpPayload payload,String customerToken)
	{
		String requestBody =
				"{}";
		APILogger.setRequest(requestBody);  
		response = given()
				.spec(rs)
				 .header("Authorization", "Bearer " + customerToken)
                .header("Content-Type",
		                "application/json")
		        .header("Journey","Magento")
 		          .body(payload)
 		        .when()
 		           .post(Endpoints.getstorelocatortopcities);
		APILogger.setStatusCode(response.getStatusCode());
		APILogger.setResponse(
	            response.asPrettyString());

	    return response;
	}

}
