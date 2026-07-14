package apis;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.PlaceOrderPayload;
import static io.restassured.RestAssured.*;

import constants.Endpoints;
public class PlaceOrderAPI {
	
	public Response placeOrder(RequestSpecification rs, String customerToken, PlaceOrderPayload payload)
	{
		return given()
				.spec(rs)
				.header("Authorization", "Bearer " + customerToken)
                .header("Content-Type",
		                "application/json")
		        .header("Journey","Magento")
		        .body(payload)
		     .when()
		        .post(Endpoints.postPlaceOrder);
		     
				
	}

}
