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
}
