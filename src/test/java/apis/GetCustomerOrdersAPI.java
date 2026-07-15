package apis;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.OrderListinngPayload;
import static io.restassured.RestAssured.*;

import constants.Endpoints;

public class GetCustomerOrdersAPI {
	
	Response response;
	
	public Response getCustomerOrders(RequestSpecification rs, String customerToken,OrderListinngPayload payload)
	{
		return given()
				.spec(rs)
				.header("Authorization", "Bearer " + customerToken)
                .header("Content-Type",
		                "application/json")
		        .header("Journey","Magento")
		        .body(payload)
		      .when()
		         .post(Endpoints.getOrders);
	}

}
