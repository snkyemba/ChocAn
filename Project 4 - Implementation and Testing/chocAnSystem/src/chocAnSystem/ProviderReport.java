package chocAnSystem;
import java.util.Vector;
//Provider Report Class created by EvanChilders
import java.util.*;
import java.util.Date;
//Provider Report class by EvanChilders
public class ProviderReport {
	String name;
	int number;
	String address;
	String city;
	String state;
	int zip;
	Vector<ProviderReportService> serviceList;
	
	public ProviderReport(String name, int number, String address, String city, String state, int zip){
		this.name = name;
		this.number = number;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.serviceList = new Vector<ProviderReportService>();
	}
	
	public void addService(ProviderReportService newService) {
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
