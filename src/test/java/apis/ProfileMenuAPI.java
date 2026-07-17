package apis;

import java.lang.module.ModuleDescriptor.Requires;

import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.VerifyOtpPayload;
import utilities.APILogger;

import static io.restassured.RestAssured.*;
public class ProfileMenuAPI {

	
	Response response;
	
	public Response getProfileMenu(RequestSpecification rs, String customerToken, VerifyOtpPayload payload)
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
 		           .post(Endpoints.getProfilrMenuEndpoint);
		APILogger.setStatusCode(response.getStatusCode());
		APILogger.setResponse(
	            response.asPrettyString());

	    return response;
	}
}
