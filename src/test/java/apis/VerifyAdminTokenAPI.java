package apis;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.VerifyOtpPayload;
import utilities.APILogger;

import static io.restassured.RestAssured.*;

import constants.Endpoints;

public class VerifyAdminTokenAPI {
	
	public Response verifyAdminToken(RequestSpecification rs , VerifyOtpPayload pd) 
	{
		
		String requestBody =
				"{}";
		APILogger.setRequest(requestBody);   
		APILogger.setEndpoint(Endpoints.verifyAdminToken);
		Response response= given()
				.spec(rs)
				.header("Authorization", "Bearer 36f1240d47a29cf572957cb87f69d5e4")
				.header("Content-Type","application/json")
				.header("Journey","Magento")
				.body(pd)
			.when()
			  .post(Endpoints.verifyAdminToken)
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
