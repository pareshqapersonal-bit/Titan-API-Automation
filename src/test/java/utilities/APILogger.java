package utilities;

public class APILogger {
	
	public static ThreadLocal<String> request = new ThreadLocal<String>();
	public static ThreadLocal<String> response= new ThreadLocal<String>();
	
	public static void setRequest(String rq)
	{
		request.set(rq);
	}
	
	public static ThreadLocal<String> getRequest()
	{
		return request;
	}
	
	public static void setResponse(String rs)
	{
		response.set(rs);
	}
	
	public static ThreadLocal<String> getResponse()
	{
		return response;
	}

}
