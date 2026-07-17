package payloads;

public class GetInfoPayload {
	
	private String environment="";
	
	public void setEnvironment(String environment)
	{
		this.environment=environment;
	}
	
	public String getEnviornment()
	{
		return environment;
	}

}
