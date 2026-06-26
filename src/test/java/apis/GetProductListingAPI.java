package apis;

import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class GetProductListingAPI {
	Response response;
	
	public Response getProductsAPI(RequestSpecification rs, String category)
	{
		String endpoint="";
		if(category.equalsIgnoreCase("Sunglasses"))
		{
			endpoint= Endpoints.getSunglassProducts;
		}else if(category.equalsIgnoreCase("Eyeglasses"))
		{
			endpoint= Endpoints.getEyeglassProducts;
		}else if(category.equalsIgnoreCase("Powered Sunglasses"))
		{
			endpoint= Endpoints.getPoweredSunglassesProducts;
		}else if(category.equalsIgnoreCase("Computer Glasses"))
		{  endpoint= Endpoints.getComputerGlassesProducts;
			
		}else if(category.equalsIgnoreCase("Contact Lenses"))
		{
			endpoint= Endpoints.getComputerGlassesProducts;
		}else if(category.equalsIgnoreCase("Accesories"))
		{
			endpoint= Endpoints.getAccessoriesProducts;
		}if(category.equalsIgnoreCase("Ready reader"))
		{
			endpoint= Endpoints.getReadyReaderProducts;
		}if(category.equalsIgnoreCase("Smart Glasses"))
		{
			endpoint= Endpoints.getSmartGlassesProducts;
		}
		return given()
	            .spec(rs)
	    .when()
	            .get(endpoint);
	}

}
