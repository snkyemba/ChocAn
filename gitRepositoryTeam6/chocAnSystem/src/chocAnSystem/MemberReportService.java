package chocAnSystem;

import java.util.Date;

public class MemberReportService{
	//note that I changed date to type String instead of Date type because it should
	//be in the form "MM-DD-YY"
	private Date date;
	private String providerName;
	private String serviceName;
	
	public MemberReportService(Date date, String providerName, String serviceName) {
		this.date = date;
		this.providerName = providerName;
		this.serviceName = serviceName;
		
	}
	public Date getDate(){
		return date;
	}
	public String getProviderName() {
		return providerName;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setDate(Date newDate) {
		date = newDate;
	}
	public void setProviderName(String newProviderName) {
		providerName = newProviderName;
	}
	public void setServiceName(String newServiceName) {
		serviceName = newServiceName;
	}
}
