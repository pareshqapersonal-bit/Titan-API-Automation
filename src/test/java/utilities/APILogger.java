package utilities;

public class APILogger {
	
	   private static ThreadLocal<String> request =
	            new ThreadLocal<>();

	    private static ThreadLocal<String> response =
	            new ThreadLocal<>();
	    
	    private static ThreadLocal<Integer> statuscode = new ThreadLocal<>();
	    
	    private static ThreadLocal<String> endpoint = new ThreadLocal<>();

	    public static void setRequest(String rq)
	    {
	        request.set(rq);
	    }

	    public static String getRequest()
	    {
	        return request.get();
	    }

	    public static void setResponse(String rs)
	    {
	        response.set(rs);
	    }

	    public static String getResponse()
	    {
	        return response.get();
	        
	       
	    }
	    
	    public static Integer getStatusCode()
        {
        	return statuscode.get();
        }
	    public static void setStatusCode(Integer sc )
	    {
	    	statuscode.set(sc);
	    }
	    
	    
	    public static String getEndpoint()
	    {
	    	return endpoint.get();
	    }
	    
	    public static void setEndpoint(String ep)
	    {
	    	endpoint.set(ep);
	    }
	    

	    public static void clear()
	    {
	        request.remove();
	        response.remove();
	        statuscode.remove();
	        endpoint.remove();
	    }

}
