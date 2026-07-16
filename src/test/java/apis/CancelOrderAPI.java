package apis;

import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.OrderListinngPayload;
import static io.restassured.RestAssured.*;
public class CancelOrderAPI {
	
	Response response;
	
	public Response cancelOrder(RequestSpecification rs,OrderListinngPayload payload, String customerToken )
	{
		return given()
				.spec(rs)
				.header("Authorization", "Bearer " + customerToken)
                .header("Content-Type",
		                "application/json")
		        .header("Journey","Magento")
		        .body(payload)
		      .when()
		       .post(Endpoints.cancelOrdrEndpoint);
	}
	

}
