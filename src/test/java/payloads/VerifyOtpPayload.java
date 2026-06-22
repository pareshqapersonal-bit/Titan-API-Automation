package payloads;

public class VerifyOtpPayload {
	
	private String mobile_no;
	private String otp;
	
	public String getMobile_no()
	{
		return mobile_no;
	}
	
	public void setMoble_no(String mobile_no) {
		this.mobile_no= mobile_no;
	}
	
	public String getOtp()
	{
		return otp;
	}
	
	public void setOtp(String otp)
	{
		this.otp=otp;
	}

}
