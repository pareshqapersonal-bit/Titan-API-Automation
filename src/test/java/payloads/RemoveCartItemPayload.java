package payloads;

public class RemoveCartItemPayload {

	private String ItemId="";
	private String isencircleApplied="";
	private String iscouponApplied="";
	private String isstoreCeditApplied="";
	private String encircleAppliedBalance="";
	private String encircleCardNumber="";
	private String cartId="";
	
	
	public void setItemId(String itemId)
	{
		this.ItemId = itemId;
	}
	
	public String getItemId()
	{
		return ItemId;
	}
	
	public void setIsEncircleApplied(String isencircleApplied)
	{
		this.isencircleApplied= isencircleApplied;
	}
	
	public String getisencircleApplied()
	{
		return isencircleApplied;
	}
	
	
	public void setiscouponApplied(String iscouponApplied)
	{
		this.iscouponApplied= iscouponApplied;
	}
	
	
	public String getiscouponApplied()
	{
		return iscouponApplied;
	}
	
	public void setisstoreCeditApplied(String isstoreCeditApplied)
	{
		this.isstoreCeditApplied= isstoreCeditApplied;
	}
	
	public String getisstoreCeditApplied()
	{
		return isstoreCeditApplied;
	}
	
	public void setencircleAppliedBalance(String encircleAppliedBalance)
	{
		this.encircleAppliedBalance= encircleAppliedBalance;
	}
	
	public String getencircleAppliedBalance()
	{
		return encircleAppliedBalance;
	}
	
	public void setencircleCardNumber(String encircleCardNumber)
	{
		this.encircleCardNumber= encircleCardNumber;
	}
	
	public String getencircleCardNumber()
	{
		return encircleCardNumber;
	}
	
	public void setcartId(String cartId)
	{
		this.cartId= cartId;
	}
	
	public String getcartId()
	{
		return cartId;
	}
	
	
	
}
