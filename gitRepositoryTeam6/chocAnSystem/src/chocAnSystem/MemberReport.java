package chocAnSystem;
import java.util.Vector;
import java.util.Date;
//Member Report class by EvanChilders
public class MemberReport {
	private String name;
	private int memNumber;
	private String address;
	private String city;
	private String state;
	private int zip;
	
	Vector<MemberReportService> serviceList;
	
	public MemberReport(String name, int memNumber, String address, String city, String state, int zip){
		this.name = name;
		this.memNumber = memNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.serviceList = new Vector<MemberReportService>();
	}
	public void addService(MemberReportService newService) {
		serviceList.add(newService);
	}
	public Vector<MemberReportService> getServiceList(){
		return serviceList;
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
