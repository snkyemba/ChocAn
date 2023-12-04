package chocAnSystem;

public class MemberReportService{
	private String date;
	private String providerName;
	private String serviceName;
	
	public MemberReportService(String date, String providerName, String serviceName) {
		this.date = date;
		this.providerName = providerName;
		this.serviceName = serviceName;
		
	}
	public String getDate(){
		return date;
	}
	public String getProviderName() {
		return providerName;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setDate(String newDate) {
		date = newDate;
	}
	public void setProviderName(String newProviderName) {
		providerName = newProviderName;
	}
	public void setServiceName(String newServiceName) {
		serviceName = newServiceName;
	}
}
