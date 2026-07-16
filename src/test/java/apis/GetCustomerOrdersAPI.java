package apis;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.OrderListinngPayload;
import utilities.APILogger;

import static io.restassured.RestAssured.*;

import constants.Endpoints;

public class GetCustomerOrdersAPI {
	
	Response response;
	
	public Response getCustomerOrders(RequestSpecification rs, String customerToken,OrderListinngPayload payload)
	{
		
		String requestBody =
		        "{\n" +
		        "  \"page\": " + payload.getPage() + ",\n" +
		        "  \"customer_id\": \"" + payload.getCustomerId() + "\",\n" +
		        "  \"order_id\": \"" + payload.getOrder_ID() + "\"\n" +
		        "}";
		APILogger.setRequest(requestBody);
		response = given()
				.spec(rs)
				.header("Authorization", "Bearer " + customerToken)
                .header("Content-Type",
		                "application/json")
		        .header("Journey","Magento")
		        .body(payload)
		      .when()
		         .post(Endpoints.getOrders)
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
