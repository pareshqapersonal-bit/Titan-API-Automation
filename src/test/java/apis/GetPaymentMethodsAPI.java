package apis;

import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.VerifyOtpPayload;
import utilities.APILogger;
import static io.restassured.RestAssured.*;
public class GetPaymentMethodsAPI {
	
	Response response;
	
	public Response getPaymentMethods(RequestSpecification rs, VerifyOtpPayload payload,String customerToken)
	{
		String requestBody =
				"{}";
		APILogger.setRequest(requestBody);  
		response= given()
				.spec(rs)
				 .header("Content-Type",
	 		                "application/json")
	 		        .header("Journey","Magento")
				        .body(payload)
				     .when()
				          .post(Endpoints.getpayment)
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
