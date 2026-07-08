package payloads;

public class CartItemPayload {
	 private String sku;
	    private int qty;
	    private String quote_id;
	    private ProductOptionsPayload product_option;

	    public String getSku() {
	        return sku;
	    }

	    public void setSku(String sku) {
	        this.sku = sku;
	    }

	    public int getQty() {
	        return qty;
	    }

	    public void setQty(int qty) {
	        this.qty = qty;
	    }

	    public String getQuote_id() {
	        return quote_id;
	    }

	    public void setQuote_id(String quote_id) {
	        this.quote_id = quote_id;
	    }

	    public ProductOptionsPayload getProduct_option() {
	        return product_option;
	    }

	    public void setProduct_option(ProductOptionsPayload product_option) {
	        this.product_option = product_option;
	    }
}
