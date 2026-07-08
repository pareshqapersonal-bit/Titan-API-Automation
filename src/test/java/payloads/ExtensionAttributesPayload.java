package payloads;

import java.util.List;

public class ExtensionAttributesPayload {
	private List<CustomOptionsPayload> custom_options;

    public List<CustomOptionsPayload> getCustom_options() {
        return custom_options;
    }

    public void setCustom_options(List<CustomOptionsPayload> custom_options) {
        this.custom_options = custom_options;
    }
}
