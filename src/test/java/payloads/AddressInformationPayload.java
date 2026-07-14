package payloads;

public class AddressInformationPayload {
	
	 private AddressPayload shipping_address;
	    private String shipping_carrier_code = "";
	    private String shipping_method_code = "";

	    public AddressPayload getShipping_address() {
	        return shipping_address;
	    }

	    public void setShipping_address(AddressPayload shipping_address) {
	        this.shipping_address = shipping_address;
	    }

	    public String getShipping_carrier_code() {
	        return shipping_carrier_code;
	    }

	    public void setShipping_carrier_code(String shipping_carrier_code) {
	        this.shipping_carrier_code = shipping_carrier_code;
	    }

	    public String getShipping_method_code() {
	        return shipping_method_code;
	    }

	    public void setShipping_method_code(String shipping_method_code) {
	        this.shipping_method_code = shipping_method_code;
	    }

}
