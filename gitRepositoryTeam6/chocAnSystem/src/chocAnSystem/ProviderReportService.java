package chocAnSystem;

import java.util.Date;

class ProviderReportService{
	private String date;
	private String providerName;
	private String serviceName;
	private double fee;
	
	public ProviderReportService(String date, String providerName, String serviceName, double fee) {
		this.date = date;
		this.providerName = providerName;
		this.serviceName = serviceName;
		this.fee = fee;
		
	}
	//getter and setter methods
	public String getDate(){
		return date;
	}
	public String getProviderName() {
		return providerName;
	}
	public String getServiceName() {
		return serviceName;
	}
	public double getFee() {
		return fee;
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
	public void setFee(double newFee) {
		fee = newFee;
	}
}