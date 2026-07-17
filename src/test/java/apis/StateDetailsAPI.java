package apis;

import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.VerifyOtpPayload;
import utilities.APILogger;

import static io.restassured.RestAssured.*;

public class StateDetailsAPI {
	Response response;
	public Response getStateDetails(RequestSpecification rs, String customerToken, VerifyOtpPayload payload)
	{
		String requestBody =
				"{}";
		APILogger.setRequest(requestBody);  
		APILogger.setEndpoint(Endpoints.getStateDetailsapi);
		response= given()
                  .spec(rs)
                  .header("Authorization", customerToken)
                  .header("Content-Type",
  		                "application/json")
  		        .header("Journey","Magento")
  		          .body(payload)
                .when()
                    .get(Endpoints.getStateDetailsapi)
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
