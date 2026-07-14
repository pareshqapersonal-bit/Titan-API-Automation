package payloads;

import java.util.List;

public class AddressPayload {
	 private String region_id = "";
	    private String region_code = "";
	    private String country_id = "";
	    private List<String> street;
	    private String telephone = "";
	    private String postcode = "";
	    private String city = "";
	    private String firstname = "";
	    private String lastname = "";
	    private String customer_id = "";
	    private String email = "";
	    private int same_as_billing;
	    private String region = "";
	    private List<CustomAttributePayload> custom_attributes;

	    public String getRegion_id() {
	        return region_id;
	    }

	    public void setRegion_id(String region_id) {
	        this.region_id = region_id;
	    }

	    public String getRegion_code() {
	        return region_code;
	    }

	    public void setRegion_code(String region_code) {
	        this.region_code = region_code;
	    }

	    public String getCountry_id() {
	        return country_id;
	    }

	    public void setCountry_id(String country_id) {
	        this.country_id = country_id;
	    }

	    public List<String> getStreet() {
	        return street;
	    }

	    public void setStreet(List<String> street) {
	        this.street = street;
	    }

	    public String getTelephone() {
	        return telephone;
	    }

	    public void setTelephone(String telephone) {
	        this.telephone = telephone;
	    }

	    public String getPostcode() {
	        return postcode;
	    }

	    public void setPostcode(String postcode) {
	        this.postcode = postcode;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	    public String getFirstname() {
	        return firstname;
	    }

	    public void setFirstname(String firstname) {
	        this.firstname = firstname;
	    }

	    public String getLastname() {
	        return lastname;
	    }

	    public void setLastname(String lastname) {
	        this.lastname = lastname;
	    }

	    public String getCustomer_id() {
	        return customer_id;
	    }

	    public void setCustomer_id(String customer_id) {
	        this.customer_id = customer_id;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public int getSame_as_billing() {
	        return same_as_billing;
	    }

	    public void setSame_as_billing(int same_as_billing) {
	        this.same_as_billing = same_as_billing;
	    }

	    public String getRegion() {
	        return region;
	    }

	    public void setRegion(String region) {
	        this.region = region;
	    }

	    public List<CustomAttributePayload> getCustom_attributes() {
	        return custom_attributes;
	    }

	    public void setCustom_attributes(List<CustomAttributePayload> custom_attributes) {
	        this.custom_attributes = custom_attributes;
	    }
	    
	    

}
