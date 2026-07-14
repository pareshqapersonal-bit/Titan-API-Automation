package payloads;

public class ShippingInformationPayload {

	

	private AddressInformationPayload addressInformation;

    public AddressInformationPayload getAddressInformation() {
        return addressInformation;
    }

    public void setAddressInformation(AddressInformationPayload addressInformation) {
        this.addressInformation = addressInformation;
    }
}
