package apis;

import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.OrderListinngPayload;
import utilities.APILogger;

import static io.restassured.RestAssured.*;
public class CancelOrderAPI {
	
	Response response;
	
	public Response cancelOrder(RequestSpecification rs,OrderListinngPayload payload, String customerToken )
	{
		
		String requestBody =
		        "{\n" +
		        "  \"page\": " + payload.getPage() + ",\n" +
		        "  \"customer_id\": \"" + payload.getCustomerId() + "\",\n" +
		        "  \"order_id\": \"" + payload.getOrder_ID() + "\"\n" +
		        "}";
		APILogger.setRequest(requestBody);
		
		APILogger.setEndpoint(Endpoints.cancelOrdrEndpoint);
	
		response = given()
				.spec(rs)
				.header("Authorization", "Bearer " + customerToken)
                .header("Content-Type",
		                "application/json")
		        .header("Journey","Magento")
		        .body(payload)
		      .when()
		       .post(Endpoints.cancelOrdrEndpoint)
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
