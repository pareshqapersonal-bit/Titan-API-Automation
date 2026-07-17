package constants;

import utilities.APILogger;

public final class Endpoints {

	public static final String sendOTP="api/auth/send-otp" ;
	public static final String verifyOTP ="api/auth/verify-otp";
	public static final String addToFav="api/cart/add-to-favorites";
	public static final String checkSession="api/auth/check-session";
	public static final String getWishList="api/my-accounts/wishlist";
	public static final String removeFromFav="api/cart/remove-from-favorites";
	public static final String getSunglassProducts="api/products/get-list/sunglasses";
	public static final String getEyeglassProducts="api/products/get-list/eyeglasses";
	public static final String getPoweredSunglassesProducts="api/products/get-list/power-sunglasses";
	public static final String getComputerGlassesProducts="api/products/get-list/computer-glasses";
	public static final String getContactLenseProducts="api/products/get-list/contact-lenses";
    public static final String getAccessoriesProducts="api/products/get-list/accessories";
    public static final String getReadyReaderProducts="api/products/get-list/ready-readers";
    public static final String getSmartGlassesProducts="api/products/get-list/sunglasses/collection/smart_sunglasses";
    public static final String getLensDetails="https://adobe-eyeplus.newstore.co.in/api/lens/get-lens-data";
    public static final String getToCart="api/lens/add-to-cart";
    public static final String getLensAddons="api/lens/get-lens-addons";
    public static final String addToCartSun="api/cart/add-to-cart";
    public static final String getDelData="api/cart/check-delivery";
    public static final String getStoreDaa="api/products/get-stores";
    public static final String getProductDetails="V2/titan-mobileapi/getProductDetailsOptimized";
    public static final String verifyAdminToken="V2/titan-mobileapi/getadmintoken";
    public static final String customerAddToCart="V2/titan-mobileapi/customerAddToCart";
    public static final String generateOTP="V2/titan-mobileapi/generate-otp";
    public static final String generateCustomerCart="V2/titan-mobileapi/genratecustomercart";
    public static final String veriftRestOTP="V2/titan-mobileapi/verify-otp";
    public static final String removeCartItem="V2/titan-mobileapi/removeCartItem";
    public static final String cartTotal="V2/titan-mobileapi/getcarttotal";
    public static final String getStateDetailsapi="V1/directory/countries";
    public static final String getaddress="V1/customers/me";
    public static final String getpayment="V2/titan-webapi/RazorpayMethods";
    public static final String postPlaceOrder="V2/titan-mobileapi/paymentInformationV2";
    public static final String getShippingMethod="V1/carts/mine/shipping-information";
    public static final String getMagentoProductList="V2/titan-mobileapi/getproductlist";
    public static final String getOrders="V2/titan-mobileapi/customerMyOrderOptimize";
    public static final String cancelOrdrEndpoint="V2/titan-mobileapi/cancelCustomerOrder";
    public static final String getInfoEndpoints="V2/titan-mobileapi/genralInfo";
    public static final String getProfilrMenuEndpoint="V2/titan-mobileapi/myProfileMenu";
    public static final String getstorelocatortopcities="V2/titan-mobileapi/getstorelocatortopcities";

}
