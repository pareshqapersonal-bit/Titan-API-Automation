package utilities;

import java.util.List;
import java.util.Map;

import io.restassured.response.Response;
import payloads.AddressInformationPayload;
import payloads.AddressPayload;
import payloads.CustomAttributePayload;
import payloads.ProductListingPayload;
import payloads.ShippingInformationPayload;


public class PayloadBuilder {

	public static CustomAttributePayload buildAttribute(
	        String code,
	        String value) {

	    CustomAttributePayload attribute = new CustomAttributePayload();
	    attribute.setAttribute_code(code);
	    attribute.setValue(value);

	    return attribute;
	}
	
	
	
	
	public static AddressPayload buildAddress(
	        String regionId,
	        String regionCode,
	        String countryId,
	        List<String> street,
	        String telephone,
	        String postcode,
	        String city,
	        String firstName,
	        String lastName,
	        String customerId,
	        String email,
	        int sameAsBilling,
	        String region,
	        String latitude,
	        String longitude) {

	    CustomAttributePayload latitudeAttr =
	            buildAttribute("latitude", latitude);

	    CustomAttributePayload longitudeAttr =
	            buildAttribute("longitude", longitude);

	    AddressPayload address = new AddressPayload();

	    address.setRegion_id(regionId);
	    address.setRegion_code(regionCode);
	    address.setCountry_id(countryId);
	    address.setStreet(street);
	    address.setTelephone(telephone);
	    address.setPostcode(postcode);
	    address.setCity(city);
	    address.setFirstname(firstName);
	    address.setLastname(lastName);
	    address.setCustomer_id(customerId);
	    address.setEmail(email);
	    address.setSame_as_billing(sameAsBilling);
	    address.setRegion(region);

	    address.setCustom_attributes(
	            List.of(latitudeAttr, longitudeAttr));

	    return address;
	    
	    
	    
	}
	
	
	public static AddressPayload buildAddress(
	        Response response,
	        boolean isBilling)
	{
		String defaultAddressId;

		if (isBilling) {
		    defaultAddressId = response.jsonPath().getString("default_billing");
		} else {
		    defaultAddressId = response.jsonPath().getString("default_shipping");
		}
		
		List<Map<String, Object>> addresses =
		        response.jsonPath().getList("addresses");
		
		for (Map<String, Object> addr : addresses) {

		    if (defaultAddressId.equals(
		            String.valueOf(addr.get("id")))) {

		        AddressPayload address = new AddressPayload();

		        address.setRegion_id(String.valueOf(addr.get("region_id")));
		        address.setCountry_id(String.valueOf(addr.get("country_id")));
		        address.setTelephone(String.valueOf(addr.get("telephone")));
		        address.setPostcode(String.valueOf(addr.get("postcode")));
		        address.setCity(String.valueOf(addr.get("city")));
		        address.setFirstname(String.valueOf(addr.get("firstname")));
		        address.setLastname(String.valueOf(addr.get("lastname")));
		        
		        Map<String, Object> region =
		                (Map<String, Object>) addr.get("region");

		        address.setRegion_code(
		                String.valueOf(region.get("region_code")));

		        address.setRegion(
		                String.valueOf(region.get("region")));
		        
		        
		        @SuppressWarnings("unchecked")
		        List<String> street =
		                (List<String>) addr.get("street");

		        address.setStreet(street);
		        address.setCustomer_id(
		                response.jsonPath().getString("id"));
		        address.setEmail(
		                response.jsonPath().getString("email"));
		        
		        if (isBilling) {
		            address.setSame_as_billing(1);
		        } else {
		            address.setSame_as_billing(0);
		        }
		        
		        
		        CustomAttributePayload latitude =
		                buildAttribute("latitude", "44.712776");

		        CustomAttributePayload longitude =
		                buildAttribute("longitude", "-44.005974");

		        address.setCustom_attributes(
		                List.of(latitude, longitude));
		        
		        
		        return address;
		    }
		}

		return null;
	}
	
	 public static ShippingInformationPayload buildShippingInformation(
	            Response response) {
		 
		 AddressPayload shippingAddress = buildAddress(response, false);

		    AddressInformationPayload addressInfo = new AddressInformationPayload();

		    addressInfo.setShipping_address(shippingAddress);
		    addressInfo.setShipping_carrier_code("tablerate");
		    addressInfo.setShipping_method_code("bestway");

		    ShippingInformationPayload payload =
		            new ShippingInformationPayload();

		    payload.setAddressInformation(addressInfo);

		    return payload;
	 }

	 
	 //product list payload 
	 public static ProductListingPayload buildProductListingPayload(String type) {

		    ProductListingPayload payload = new ProductListingPayload();

		    payload.setType(type);
		    payload.setPage(1);
		    payload.setMin_price("");
		    payload.setMax_price("");
		    payload.setSelected_price_filter("");
		    payload.setFilters(List.of());
		    payload.setSort_by(List.of());
		    payload.setCategoryId("");
		    payload.setFindMyFitFlag("0");
		    payload.setLens_width("");
		    payload.setBridge_width("");
		    payload.setTemple_length("");

		    return payload;
		}
	
	
	
}
