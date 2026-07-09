package apis;

import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.VerifyOtpPayload;

import static io.restassured.RestAssured.*;

public class StateDetailsAPI {
	
	public Response getStateDetails(RequestSpecification rs, String customerToken, VerifyOtpPayload payload)
	{
		return given()
                  .spec(rs)
                  .header("Authorization", customerToken)
                  .header("Content-Type",
  		                "application/json")
  		        .header("Journey","Magento")
  		          .body(payload)
                .when()
                    .get(Endpoints.getStateDetailsapi);
	}

}
