package apis;

import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.VerifyOtpPayload;
import utilities.APILogger;
import static io.restassured.RestAssured.*;

public class GetAddressListAPI {
	
	Response response;
	
	public Response getAddress(RequestSpecification rs, VerifyOtpPayload payload, String customerToken)

	{
		
		String requestBody =
				"{}";
		APILogger.setRequest(requestBody);   
		APILogger.setEndpoint(Endpoints.getaddress);
		response= given()
				.spec(rs)
				 .header("Authorization", "Bearer " + customerToken)
                 .header("Content-Type",
 		                "application/json")
 		        .header("Journey","Magento")
			        .body(payload)
			     .when()
			          .get(Endpoints.getaddress)
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
