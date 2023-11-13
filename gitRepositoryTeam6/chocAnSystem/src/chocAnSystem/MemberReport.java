package chocAnSystem;
//import chocAnSystem.ManagerReport;
import java.util.Vector;
//Member Report class by EvanChilders
public class MemberReport {
	private String name;
	private int memNumber;
	private String address;
	private String city;
	private String state;
	private int zip;
	

	
		class Service{
			//note that I changed date to type String instead of Date type because it should
			//be in the form "MM-DD-YY"
			private String date;
			private String providerName;
			private String serviceName;
			
			public Service(String date, String providerName, String serviceName) {
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
	Vector<Service> serviceList;
	
	public MemberReport(String name, int memNumber, String address, String city, String state, int zip){
		this.name = name;
		this.memNumber = memNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
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
	public int getMemNumber() {
        return memNumber;
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
    	memNumber = newNumber;
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