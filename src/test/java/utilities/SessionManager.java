package utilities;

public class SessionManager {

	private static String customerHash;
	private static String authToken;
	
	public static String getCustomerHash()
	{
		return customerHash;
	}
	
	public static void setCustomerHash(String customerHash)
	{
		SessionManager.customerHash=customerHash;
	}
	
	public static String getauthToken()
	{
		return authToken;
	}
	
	public static void setauthToken(String authToken)
	{
		SessionManager.authToken= authToken;
	}
	
	
}
