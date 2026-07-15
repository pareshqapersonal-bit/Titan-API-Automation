package apis;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.PlaceOrderPayload;
import utilities.APILogger;

import static io.restassured.RestAssured.*;

import constants.Endpoints;
public class PlaceOrderAPI {
	
	public Response placeOrder(RequestSpecification rs, String customerToken, PlaceOrderPayload payload)
	{
		
		
		String requestBody =
		        "{\n" +
		        "  \"paymentMethod\": \"" + payload.getPaymentMethod() + "\",\n" +
		        "  \"billing_address\": {\n" +
		        "    \"region\": \"" + payload.getBilling_address().getRegion() + "\",\n" +
		        "    \"region_id\": \"" + payload.getBilling_address().getRegion_id() + "\",\n" +
		        "    \"region_code\": \"" + payload.getBilling_address().getRegion_code() + "\",\n" +
		        "    \"country_id\": \"" + payload.getBilling_address().getCountry_id() + "\",\n" +
		        "    \"street\": " + payload.getBilling_address().getStreet() + ",\n" +
		        "    \"telephone\": \"" + payload.getBilling_address().getTelephone() + "\",\n" +
		        "    \"postcode\": \"" + payload.getBilling_address().getPostcode() + "\",\n" +
		        "    \"city\": \"" + payload.getBilling_address().getCity() + "\",\n" +
		        "    \"firstname\": \"" + payload.getBilling_address().getFirstname() + "\",\n" +
		        "    \"lastname\": \"" + payload.getBilling_address().getLastname() + "\",\n" +
		        "    \"customer_id\": \"" + payload.getBilling_address().getCustomer_id() + "\",\n" +
		        "    \"email\": \"" + payload.getBilling_address().getEmail() + "\",\n" +
		        "    \"same_as_billing\": " + payload.getBilling_address().getSame_as_billing() + ",\n" +
		        "    \"custom_attributes\": [\n" +
		        "      {\n" +
		        "        \"attribute_code\": \"" + payload.getBilling_address().getCustom_attributes().get(0).getAttribute_code() + "\",\n" +
		        "        \"value\": \"" + payload.getBilling_address().getCustom_attributes().get(0).getValue() + "\"\n" +
		        "      },\n" +
		        "      {\n" +
		        "        \"attribute_code\": \"" + payload.getBilling_address().getCustom_attributes().get(1).getAttribute_code() + "\",\n" +
		        "        \"value\": \"" + payload.getBilling_address().getCustom_attributes().get(1).getValue() + "\"\n" +
		        "      }\n" +
		        "    ]\n" +
		        "  },\n" +
		        "  \"shipping_address\": {\n" +
		        "    \"region\": \"" + payload.getShipping_address().getRegion() + "\",\n" +
		        "    \"region_id\": \"" + payload.getShipping_address().getRegion_id() + "\",\n" +
		        "    \"region_code\": \"" + payload.getShipping_address().getRegion_code() + "\",\n" +
		        "    \"country_id\": \"" + payload.getShipping_address().getCountry_id() + "\",\n" +
		        "    \"street\": " + payload.getShipping_address().getStreet() + ",\n" +
		        "    \"telephone\": \"" + payload.getShipping_address().getTelephone() + "\",\n" +
		        "    \"postcode\": \"" + payload.getShipping_address().getPostcode() + "\",\n" +
		        "    \"city\": \"" + payload.getShipping_address().getCity() + "\",\n" +
		        "    \"firstname\": \"" + payload.getShipping_address().getFirstname() + "\",\n" +
		        "    \"lastname\": \"" + payload.getShipping_address().getLastname() + "\",\n" +
		        "    \"customer_id\": \"" + payload.getShipping_address().getCustomer_id() + "\",\n" +
		        "    \"email\": \"" + payload.getShipping_address().getEmail() + "\",\n" +
		        "    \"same_as_billing\": " + payload.getShipping_address().getSame_as_billing() + ",\n" +
		        "    \"custom_attributes\": [\n" +
		        "      {\n" +
		        "        \"attribute_code\": \"" + payload.getShipping_address().getCustom_attributes().get(0).getAttribute_code() + "\",\n" +
		        "        \"value\": \"" + payload.getShipping_address().getCustom_attributes().get(0).getValue() + "\"\n" +
		        "      },\n" +
		        "      {\n" +
		        "        \"attribute_code\": \"" + payload.getShipping_address().getCustom_attributes().get(1).getAttribute_code() + "\",\n" +
		        "        \"value\": \"" + payload.getShipping_address().getCustom_attributes().get(1).getValue() + "\"\n" +
		        "      }\n" +
		        "    ]\n" +
		        "  }\n" +
		        "}";
		
		APILogger.setRequest(
		        requestBody);
		
	   Response	response = given()
				.spec(rs)
				.header("Authorization", "Bearer " + customerToken)
                .header("Content-Type",
		                "application/json")
		        .header("Journey","Magento")
		        .body(payload)
		     .when()
		        .post(Endpoints.postPlaceOrder)
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
