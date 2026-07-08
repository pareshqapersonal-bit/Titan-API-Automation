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
    public static final String veriftRestOTP="V2/titan-mobileapi/verify-otp";

}
