package apis;

import static io.restassured.RestAssured.*;
import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.WishListPayload;
import utilities.APILogger;

public class wishlistAPI {
	
	public Response addToFav(RequestSpecification reqspec, WishListPayload payload, String cookiename, String authToken)
	{
		//for apilogger
		String requestBody =
		        "{ \"product_id\" : \""
		        + payload.getProductId()
		        + "\" }";

		APILogger.setRequest(
		        requestBody);
		
		APILogger.setEndpoint(Endpoints.addToFav);
		
	Response response= given()
				.spec(reqspec)
				.header("Origin",
		                "https://adobe-eyeplus.newstore.co.in")
		        .header("Referer",
		                "https://adobe-eyeplus.newstore.co.in/")
				 .cookie(
			                "customerHash",
			                cookiename)
			        .cookie(
			                "adobe_tep_next_auth_token",
			                authToken)
			        .cookie(
			                "user_login_success",
			                "1")
			        .cookie("clientId",
			                "d65fe87f-d63b-44c6-9111-d05dcdc2ca12")
			        .cookie("moe_uuid",
			                "0c7dcb97-06d1-4273-9866-43a6c751bdc9")
				.body(payload)
				
			   .when()
			     .post(Endpoints.addToFav)
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
