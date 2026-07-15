package payloads;

public class OrderListinngPayload {
	
	private String page="";
	private String is_previous="";
	private String offline_order_no="";
	private String order_entity_id="";
	private String order_id="";
	
	public void setPage(String page)
	{
		this.page=page;
	}
	
	public String getPage()
	{
		return page;
	}
	
	public void setIs_Previous(String is_previous)
	{
		this.is_previous= is_previous;
	}
	
	public String getIs_Previous()
	{
		return is_previous;
	}
	
	
	public void setOffline_Order_No(String offline_order_no)
	{
		this.offline_order_no=offline_order_no;
	}
	
	public String getOffline_Order_No()
	{
		return offline_order_no;
	}
	
	public void setOrderEntityNo(String order_entity_id)
	{
		this.order_entity_id= order_entity_id;
	}
	
	public String getOrderEntity()
	{
		return order_entity_id;
	}
	
	public void setOrder_Id(String order_id)
	{
		this.order_id= order_id;
	}
	
	public String getOrder_ID()
	{
		return order_id;
	}

}
