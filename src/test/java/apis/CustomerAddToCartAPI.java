package apis;
import static io.restassured.RestAssured.*;

import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CustomerAddToCartAPI {
	
	public Response generateCustomerCart(RequestSpecification backendSpec,
            String bearerToken)
{
                 return given()
                          .spec(backendSpec)
                          .header("Authorization", bearerToken)
                        .when()
                            .post(Endpoints.customerAddToCart);
}

}
