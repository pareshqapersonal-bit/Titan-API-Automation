package utilities;

import org.testng.Assert;

import io.restassured.response.Response;

public class ResponseValidator  {
	
	 public static void validateStatusCode(Response response, int expectedStatusCode) {
	        Assert.assertEquals(
	                response.getStatusCode(),
	                expectedStatusCode,
	                "Status code mismatch");
	    }

	    public static void validateKeyPresent(Response response, String key) {
	        Assert.assertTrue(
	                response.jsonPath().getMap("$").containsKey(key),
	                key + " key is missing");
	    }

	    public static void validateValue(Response response,
	                                     String jsonPath,
	                                     String expectedValue) {
	        Assert.assertEquals(
	                response.jsonPath().getString(jsonPath),
	                expectedValue);
	    }
}
