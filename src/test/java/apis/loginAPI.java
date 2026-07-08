package apis;
import static io.restassured.RestAssured.*;
import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.VerifyOtpPayload;
import utilities.APILogger;

public class loginAPI {

	public Response sendOtp(RequestSpecification webSpec, VerifyOtpPayload payload)
	{
		String requestBody =
		        "{ \"mobile_no\" : \""
		        + payload.getMobile_no()
		        + "\" }";

		APILogger.setRequest(
		        requestBody);
		
		APILogger.setEndpoint(Endpoints.sendOTP);
		
		Response response= given()
				.spec(webSpec)
				.body(payload)
			.when()
			    .post(Endpoints.sendOTP);
		
		APILogger.setStatusCode(response.getStatusCode());
		APILogger.setResponse(
	            response.asPrettyString());

	    return response;
		
	}
	
	public Response verifyOtp(RequestSpecification webSpec, VerifyOtpPayload payload)
	{
		String requestBody =
		        "{ \"mobile_no\" : \""
		        + payload.getMobile_no()
		        + "\" }";

		APILogger.setRequest(
		        requestBody);
		APILogger.setEndpoint(Endpoints.verifyOTP);
		Response response= given()
				.spec(webSpec)
				.body(payload)
			.when()
			    .post(Endpoints.verifyOTP);
		
		
		APILogger.setStatusCode(response.getStatusCode());
		APILogger.setResponse(
	            response.asPrettyString());

	    return response;
	}
	
	public Response checkSessionAPI(RequestSpecification reqSpec, String customerCookie)
	{
		return given()
				.spec(reqSpec)
				.cookie( "customerHash", customerCookie)
			   .when()
			    .get(Endpoints.checkSession);
	}
	
	
	
	//RestAPI

	public Response generateOTP(RequestSpecification webSpec, VerifyOtpPayload payload, String adminToken)
	{
		String requestBody =
		        "{ \"mobile_no\" : \""
		        + payload.getMobile_no()
		        + "\" }";

		APILogger.setRequest(
		        requestBody);
		
		APILogger.setEndpoint(Endpoints.sendOTP);
		
		Response response= given()
				.spec(webSpec)
				.header("Authorization",adminToken)
				.header("Content-Type","application/json")
				.header("Journey","Magento")
				.body(payload)
			.when()
			    .post(Endpoints.generateOTP);
		
		APILogger.setStatusCode(response.getStatusCode());
		APILogger.setResponse(
	            response.asPrettyString());

	    return response;
		
	}
	
	
	public Response verifyRestOtp(RequestSpecification webSpec, VerifyOtpPayload payload, String adminToken)
	{
		String requestBody =
		        "{ \"mobile_no\" : \""
		        + payload.getMobile_no()
		        + "\" }";

		APILogger.setRequest(
		        requestBody);
		APILogger.setEndpoint(Endpoints.verifyOTP);
		Response response= given()
				.spec(webSpec)
				.header("Authorization",adminToken)
				.header("Content-Type","application/json")
				.header("Journey","Magento")
				.body(payload)
			.when()
			    .post(Endpoints.veriftRestOTP);
		
		
		APILogger.setStatusCode(response.getStatusCode());
		APILogger.setResponse(
	            response.asPrettyString());

	    return response;
	}
}
