package apis;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.CartTotalPayload;
import payloads.RemoveCartItemPayload;
import utilities.APILogger;

import static io.restassured.RestAssured.*;

import constants.Endpoints;
public class RemoveCartItemAPI {
	
	public Response removeCartItem(RequestSpecification rs, RemoveCartItemPayload payload, String customerToken)
	{
		
		
		String requestBody =
		        "{\n" +
		        "  \"ItemId\": \"" + payload.getItemId() + "\",\n" +
		        "  \"isencircleApplied\": " + payload.getisencircleApplied()+ ",\n" +
		        "  \"iscouponApplied\": " + payload.getiscouponApplied() + ",\n" +
		        "  \"isstoreCeditApplied\": " + payload.getisstoreCeditApplied() + ",\n" +
		        "  \"encircleAppliedBalance\": " + payload.getencircleAppliedBalance() + ",\n" +
		        "  \"encircleCardNumber\": \"" + payload.getencircleCardNumber() + "\",\n" +
		        "  \"cartId\": \"" + payload.getcartId() + "\"\n" +
		        "}";
		
		APILogger.setRequest(requestBody);
		APILogger.setEndpoint(Endpoints.removeCartItem);
		Response response = given()
				 .spec(rs)
				 .header("Authorization", "Bearer " + customerToken)
                 .header("Content-Type",
 		                "application/json")
 		        .header("Journey","Magento")
			        .body(payload)
			     .when()
			         .post(Endpoints.removeCartItem)
			         .then()
			         .log().all()
			         .extract()
				        .response();
			APILogger.setStatusCode(response.getStatusCode());
			APILogger.setResponse(
		           response.asPrettyString());

			return response;
			        
	}
	
	
	public Response cartTotal(RequestSpecification rs, CartTotalPayload payload, String customerToken)
	{
		String requestBody =
				"{\n" +
				"  \"cart_id\": \"" + payload.getCartId() + "\",\n" +
			
				"}";

				APILogger.setRequest(requestBody);
		
		Response response= given()
				.spec(rs)
				 .header("Authorization", "Bearer " + customerToken)
                 .header("Content-Type",
 		                "application/json")
 		        .header("Journey","Magento")
			        .body(payload)
			     .when()
			          .post(Endpoints.cartTotal)
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
