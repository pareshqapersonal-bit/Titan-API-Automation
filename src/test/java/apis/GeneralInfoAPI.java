package apis;

import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.GetInfoPayload;
import utilities.APILogger;

import static io.restassured.RestAssured.*;

public class GeneralInfoAPI {
	
	Response response;
	
	public Response getGenralInfo(RequestSpecification rs, GetInfoPayload payload, String customerToken)
	{
		
		String requestBody =
		        "{ \"environment\" : \""
		        + payload.getEnviornment()
		        + "\" }";
		
		APILogger.setRequest(requestBody);
		APILogger.setEndpoint(Endpoints.getInfoEndpoints);
		response = given()
				.spec(rs)
				 .header("Authorization", "Bearer " + customerToken)
                 .header("Content-Type",
 		                "application/json")
 		        .header("Journey","Magento")
  		          .body(payload)
  		        .when()
  		           .post(Endpoints.getInfoEndpoints);
		
		APILogger.setStatusCode(response.getStatusCode());
		APILogger.setResponse(
	            response.asPrettyString());

	    return response;
	}

}
