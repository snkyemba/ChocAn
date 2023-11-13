package chocAnSystem;
import java.util.Vector;

import chocAnSystem.MemberReport.Service;
public class ProviderReport {
	String name;
	int number;
	String address;
	String city;
	String state;
	int zip;
	
	class Service{
		//note that I changed date to type String instead of Date type because it should
		//be in the form "MM-DD-YY"
		private String date;
		private String providerName;
		private String serviceName;
		private double fee;
		
		public Service(String date, String providerName, String serviceName, double fee) {
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
	public ProviderReport(String name, int number, String address, String city, String state, int zip){
		this.name = name;
		this.number = number;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	Vector<Service> serviceList;
	public void addService(Service newService) {
		serviceList.add(newService);
	}
	
	public void toFile() {
		//figure out formatting for vector data into file or database
	}
	public void fromFile() {
		//figure out formatting for vector data from file or database
	}
	
	//getter and setter methods
	public String getName() {
		return name;
	}
	public int getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }
    public void setName(String newName) {
    	name = newName;
    }
    public void setMemNumber(int newNumber) {
    	number = newNumber;
    }
    public void setAddress(String newAddress) {
    	address = newAddress;
    }
    public void setCity(String newCity) {
    	city = newCity;
    }
    public void setState(String newState) {
    	state = newState;
    }
    public void setZip(int newZip) {
    	zip = newZip;
    }
}
