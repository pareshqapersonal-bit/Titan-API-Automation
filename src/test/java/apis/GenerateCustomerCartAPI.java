package apis;

import static io.restassured.RestAssured.given;

import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.APILogger;

public class GenerateCustomerCartAPI {

	public Response generateCustomerCart(RequestSpecification backendSpec,
            String bearerToken)
{
		
		String requestBody =
				"{}";
		APILogger.setRequest(requestBody);   
                 Response response= given()
                          .spec(backendSpec)
                          .header("Authorization", "Bearer " + bearerToken)
                          .header("Content-Type",
          		                "application/json")
          		        .header("Journey","Magento")
          		     
                        .when()
                            .post(Endpoints.generateCustomerCart);
                 
                 APILogger.setStatusCode(response.getStatusCode());
         		APILogger.setResponse(
         	            response.asPrettyString());

         	    return response;
}
}
