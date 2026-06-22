package apis;
import static io.restassured.RestAssured.*;
import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.VerifyOtpPayload;

public class loginAPI {

	public Response sendOtp(RequestSpecification reqspec, VerifyOtpPayload payload)
	{
		return given()
				.spec(reqspec)
				.body(payload)
			.when()
			    .post(Endpoints.sendOTP);
	}
	
	public Response verifyOtp(RequestSpecification reqSpec, VerifyOtpPayload payload)
	{
		return given()
				.spec(reqSpec)
				.body(payload)
			.when()
			    .post(Endpoints.verifyOTP);
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
