package payloads;

public class PlaceOrderPayload {

	
	 private String paymentMethod = "";
	    private AddressPayload billing_address;
	    private AddressPayload shipping_address;

	    public String getPaymentMethod() {
	        return paymentMethod;
	    }

	    public void setPaymentMethod(String paymentMethod) {
	        this.paymentMethod = paymentMethod;
	    }

	    public AddressPayload getBilling_address() {
	        return billing_address;
	    }

	    public void setBilling_address(AddressPayload billing_address) {
	        this.billing_address = billing_address;
	    }

	    public AddressPayload getShipping_address() {
	        return shipping_address;
	    }

	    public void setShipping_address(AddressPayload shipping_address) {
	        this.shipping_address = shipping_address;
	    }
}
