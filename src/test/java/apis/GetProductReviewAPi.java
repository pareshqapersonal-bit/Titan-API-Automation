package apis;

import base.BaseTest;
import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.ProductPayload;

import static io.restassured.RestAssured.given;
public class GetProductReviewAPi{
	
	Response response;
	
	public Response getProductReview(RequestSpecification rs, String customerToken, ProductPayload productPayload)
	{
		return given().spec(rs).header("Authorization", "Bearer "+customerToken).body(productPayload).when().post(Endpoints.getproductreview).then().extract().response();
	}
	
	

}
