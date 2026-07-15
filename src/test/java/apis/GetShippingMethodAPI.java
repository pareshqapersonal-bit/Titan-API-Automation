package apis;

import org.testng.annotations.Test;

import base.BaseTest;
import constants.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.AddressInformationPayload;
import payloads.ShippingInformationPayload;
import utilities.APILogger;

import static io.restassured.RestAssured.*;
public class GetShippingMethodAPI  {
	
	
	Response response;
	
	public Response getShippingMethod(RequestSpecification rs, String cutomerToken, ShippingInformationPayload payload)
	{
		
		
		String requestBody =
		        "{\n" +
		        "  \"addressInformation\": {\n" +
		        "    \"shipping_address\": {\n" +
		        "      \"region\": \"" + payload.getAddressInformation().getShipping_address().getRegion() + "\",\n" +
		        "      \"region_id\": \"" + payload.getAddressInformation().getShipping_address().getRegion_id() + "\",\n" +
		        "      \"region_code\": \"" + payload.getAddressInformation().getShipping_address().getRegion_code() + "\",\n" +
		        "      \"country_id\": \"" + payload.getAddressInformation().getShipping_address().getCountry_id() + "\",\n" +
		        "      \"street\": " + payload.getAddressInformation().getShipping_address().getStreet() + ",\n" +
		        "      \"telephone\": \"" + payload.getAddressInformation().getShipping_address().getTelephone() + "\",\n" +
		        "      \"postcode\": \"" + payload.getAddressInformation().getShipping_address().getPostcode() + "\",\n" +
		        "      \"city\": \"" + payload.getAddressInformation().getShipping_address().getCity() + "\",\n" +
		        "      \"firstname\": \"" + payload.getAddressInformation().getShipping_address().getFirstname() + "\",\n" +
		        "      \"lastname\": \"" + payload.getAddressInformation().getShipping_address().getLastname() + "\",\n" +
		        "      \"customer_id\": \"" + payload.getAddressInformation().getShipping_address().getCustomer_id() + "\",\n" +
		        "      \"email\": \"" + payload.getAddressInformation().getShipping_address().getEmail() + "\",\n" +
		        "      \"same_as_billing\": " + payload.getAddressInformation().getShipping_address().getSame_as_billing() + ",\n" +
		        "      \"custom_attributes\": [\n" +
		        "        {\n" +
		        "          \"attribute_code\": \"" + payload.getAddressInformation().getShipping_address().getCustom_attributes().get(0).getAttribute_code() + "\",\n" +
		        "          \"value\": \"" + payload.getAddressInformation().getShipping_address().getCustom_attributes().get(0).getValue() + "\"\n" +
		        "        },\n" +
		        "        {\n" +
		        "          \"attribute_code\": \"" + payload.getAddressInformation().getShipping_address().getCustom_attributes().get(1).getAttribute_code() + "\",\n" +
		        "          \"value\": \"" + payload.getAddressInformation().getShipping_address().getCustom_attributes().get(1).getValue() + "\"\n" +
		        "        }\n" +
		        "      ]\n" +
		        "    },\n" +
		        "    \"shipping_carrier_code\": \"" + payload.getAddressInformation().getShipping_carrier_code() + "\",\n" +
		        "    \"shipping_method_code\": \"" + payload.getAddressInformation().getShipping_method_code() + "\"\n" +
		        "  }\n" +
		        "}";
		
		APILogger.setRequest(requestBody);   
		
		response = given()
				.spec(rs)
				.header("Authorization", "Bearer " + cutomerToken)
                 .header("Content-Type",
 		                "application/json")
 		        .header("Journey","Magento")
			        .body(payload)
			     .when()
			          .post(Endpoints.getShippingMethod)
			          .then()
				         .log().all()
				         .extract()
					        .response()
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
