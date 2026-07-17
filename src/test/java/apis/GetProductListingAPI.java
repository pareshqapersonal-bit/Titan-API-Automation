package apis;

import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.ProductListingPayload;
import utilities.APILogger;

import static io.restassured.RestAssured.*;

public class GetProductListingAPI {
	Response response;
	
	public Response getProductsAPI(RequestSpecification rs, String category)
	{
		String requestBody = "GET request - No request body";

		APILogger.setRequest(
		        requestBody);
		
		/*
		 * String endpoint="";
		 * 
		 * System.out.println("Category = " + category);
		 * System.out.println("Endpoint = " + endpoint);
		 * if(category.equalsIgnoreCase("Sunglasses")) { endpoint=
		 * Endpoints.getSunglassProducts;
		 * APILogger.setEndpoint(Endpoints.getSunglassProducts); }else
		 * if(category.equalsIgnoreCase("Eyeglasses")) { endpoint=
		 * Endpoints.getEyeglassProducts;
		 * APILogger.setEndpoint(Endpoints.getEyeglassProducts); }else
		 * if(category.equalsIgnoreCase("Powered Sunglasses")) { endpoint=
		 * Endpoints.getPoweredSunglassesProducts;
		 * APILogger.setEndpoint(Endpoints.getPoweredSunglassesProducts); }else
		 * if(category.equalsIgnoreCase("Computer Glasses")) { endpoint=
		 * Endpoints.getComputerGlassesProducts;
		 * APILogger.setEndpoint(Endpoints.getComputerGlassesProducts);
		 * 
		 * }else if(category.equalsIgnoreCase("Contact Lenses")) { endpoint=
		 * Endpoints.getContactLenseProducts;
		 * APILogger.setEndpoint(Endpoints.getContactLenseProducts); }else
		 * if(category.equalsIgnoreCase("Accesories")) { endpoint=
		 * Endpoints.getAccessoriesProducts;
		 * APILogger.setEndpoint(Endpoints.getAccessoriesProducts);
		 * }if(category.equalsIgnoreCase("Ready reader")) { endpoint=
		 * Endpoints.getReadyReaderProducts;
		 * APILogger.setEndpoint(Endpoints.getReadyReaderProducts);
		 * }if(category.equalsIgnoreCase("Smart Glasses")) { endpoint=
		 * Endpoints.getSmartGlassesProducts;
		 * APILogger.setEndpoint(Endpoints.getSmartGlassesProducts); }
		 */
		
		String endpoint = "";

		switch (category.toLowerCase()) {

		case "sunglasses":
		    endpoint = Endpoints.getSunglassProducts;
		    APILogger.setEndpoint(endpoint);
		    break;

		case "eyeglasses":
		    endpoint = Endpoints.getEyeglassProducts;
		    APILogger.setEndpoint(endpoint);
		    break;

		case "powered sunglasses":
		    endpoint = Endpoints.getPoweredSunglassesProducts;
		    APILogger.setEndpoint(endpoint);
		    break;

		case "computer glasses":
		    endpoint = Endpoints.getComputerGlassesProducts;
		    APILogger.setEndpoint(endpoint);
		    break;

		case "contact lenses":
		    endpoint = Endpoints.getContactLenseProducts;
		    APILogger.setEndpoint(endpoint);
		    break;

		case "accessories":
		    endpoint = Endpoints.getAccessoriesProducts;
		    APILogger.setEndpoint(endpoint);
		    break;

		case "ready reader":
		    endpoint = Endpoints.getReadyReaderProducts;
		    APILogger.setEndpoint(endpoint);
		    break;

		case "smart glasses":
		    endpoint = Endpoints.getSmartGlassesProducts;
		    APILogger.setEndpoint(endpoint);
		    break;

		default:
		    throw new IllegalArgumentException("Invalid category: " + category);
		}
		response= given()
	            .spec(rs)
	    .when()
	            .get(endpoint)
		.then()
        .log().all()
        .extract()
        .response();
		APILogger.setStatusCode(response.getStatusCode());
		APILogger.setResponse(
	            response.asPrettyString());
		/*
		 * System.out.println("Status code is"+ response.getStatusCode());
		 * System.out.println("response is"+ response.asPrettyString());
		 */
		return response;
	}
	
	
	
	public Response getMagentProductListing(RequestSpecification rs , String customerToken, ProductListingPayload payload)
	{
		String requestBody =
		        "{\n" +
		        "  \"type\": \"" + payload.getType() + "\",\n" +
		        "  \"page\": " + payload.getPage() + ",\n" +
		        "  \"min_price\": \"" + payload.getMin_price() + "\",\n" +
		        "  \"max_price\": \"" + payload.getMax_price() + "\",\n" +
		        "  \"selected_price_filter\": \"" + payload.getSelected_price_filter() + "\",\n" +
		        "  \"filters\": " + payload.getFilters() + ",\n" +
		        "  \"sort_by\": " + payload.getSort_by() + ",\n" +
		        "  \"categoryId\": \"" + payload.getCategoryId() + "\",\n" +
		        "  \"findMyFitFlag\": \"" + payload.getFindMyFitFlag() + "\",\n" +
		        "  \"lens_width\": \"" + payload.getLens_width() + "\",\n" +
		        "  \"bridge_width\": \"" + payload.getBridge_width() + "\",\n" +
		        "  \"temple_length\": \"" + payload.getTemple_length() + "\"\n" +
		        "}";
		
		APILogger.setRequest(
		        requestBody);
		APILogger.setEndpoint(Endpoints.getMagentoProductList);
		
		response = given()
				    .spec(rs)
				    .header("Authorization", "Bearer " + customerToken)
                    .header("Content-Type",
    		                "application/json")
    		        .header("Journey","Magento")
    		        .body(payload)
    		      .when()
    		         .post(Endpoints.getMagentoProductList)
    		         .then()
    		         .log().all()
    		         .extract()
    		         .response();
    		 		APILogger.setStatusCode(response.getStatusCode());
    		 		APILogger.setResponse(
    		 	            response.asPrettyString());
    		         
		return response;
	}

}
