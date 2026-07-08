package payloads;

public class CartPayload {
	 private CartItemPayload cartItem;

	    public CartItemPayload getCartItem() {
	        return cartItem;
	    }

	    public void setCartItem(CartItemPayload cartItem) {
	        this.cartItem = cartItem;
	    }
}
