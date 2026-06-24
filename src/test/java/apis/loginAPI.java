package apis;
import static io.restassured.RestAssured.*;
import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.VerifyOtpPayload;
import utilities.APILogger;

public class loginAPI {

	public Response sendOtp(RequestSpecification reqspec, VerifyOtpPayload payload)
	{
		String requestBody =
		        "{ \"mobile_no\" : \""
		        + payload.getMobile_no()
		        + "\" }";

		APILogger.setRequest(
		        requestBody);
		
		APILogger.setEndpoint(Endpoints.sendOTP);
		
		Response response= given()
				.spec(reqspec)
				.body(payload)
			.when()
			    .post(Endpoints.sendOTP);
		
		APILogger.setStatusCode(response.getStatusCode());
		APILogger.setResponse(
	            response.asPrettyString());

	    return response;
		
	}
	
	public Response verifyOtp(RequestSpecification reqSpec, VerifyOtpPayload payload)
	{
		String requestBody =
		        "{ \"mobile_no\" : \""
		        + payload.getMobile_no()
		        + "\" }";

		APILogger.setRequest(
		        requestBody);
		APILogger.setEndpoint(Endpoints.verifyOTP);
		Response response= given()
				.spec(reqSpec)
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
}
