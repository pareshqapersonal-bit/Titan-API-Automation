package apis;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.ProductPayload;
import static io.restassured.RestAssured.*;

import constants.Endpoints;

public class ProductDetailsAPI {
	
	public Response getProductDetails(RequestSpecification rs, ProductPayload payload, String customerHash, String authToken)
	{
		return given()
				.spec(rs)
				. header("Origin",
		                "https://adobe-eyeplus.newstore.co.in")
		        .header("Referer",
		                "https://adobe-eyeplus.newstore.co.in/")
			  .cookie(
		                "customerHash",
		                customerHash)
		        .cookie(
		                "adobe_tep_next_auth_token",
		                authToken)
		        .body(payload)
		    .when()
		       .post(Endpoints.getProductDetails);
	}

}
