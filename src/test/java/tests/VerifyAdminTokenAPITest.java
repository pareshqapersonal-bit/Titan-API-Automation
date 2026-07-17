package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apis.VerifyAdminTokenAPI;
import base.BaseTest;
import io.restassured.response.Response;
import payloads.VerifyOtpPayload;
import utilities.ResponseValidator;

@Listeners(utilities.TestListener.class)
public class VerifyAdminTokenAPITest extends BaseTest{
	
	@Test(description = "TC_013-Verify Admin token API")
	public void steps()
	{
		VerifyAdminTokenAPI vApi= new VerifyAdminTokenAPI();
		VerifyOtpPayload pd = new VerifyOtpPayload();
		Response response=vApi.verifyAdminToken(mobileSpec, pd);
		System.out.println("Respnse is "+response.asPrettyString());
		ResponseValidator.validateStatusCode(response, 200);
		ResponseValidator.validateKeyPresent(response, "token");
	}

}
