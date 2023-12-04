package chocAnSystem;
import java.util.Vector;
import java.util.Date;
//Member Report class by EvanChilders
/*
 * This class is used to create a member report for the manager to view
 *
 * @author Evan Childers
 * @version 1.0
 */
public class MemberReport {
	private String name;
	private int memNumber;
	private String address;
	private String city;
	private String state;
	private int zip;
	
	Vector<MemberReportService> serviceList;
	/*
	 * This method creates a member report with inputted information
	 *
	 * @param name the name of the member
	 * @param memNumber the member number
	 * @param address the address of the member
	 * @param city the city of the member
	 * @param state the state of the member
	 * @param zip the zip code of the member
	 */
	public MemberReport(String name, int memNumber, String address, String city, String state, int zip){
		this.name = name;
		this.memNumber = memNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.serviceList = new Vector<MemberReportService>();
	}
	/*
	 * This method adds a service to the vector of services
	 * @param newService the service to be added
	 */
	public void addService(MemberReportService newService) {
		serviceList.add(newService);
	}
	/*
	 * This method returns the vector of services
	 * @return the vector of services
	 */
	public Vector<MemberReportService> getServiceList(){
		return serviceList;
	}

	//getter and setter methods
	/*
	 * This method returns the name of the member
	 * @return the name of the member
	 */
	public String getName() {
		return name;
	}
	/*
	 * This method returns the member number
	 * @return the member number
	 */
	public int getMemNumber() {
        return memNumber;
    }

	/*
	 * This method returns the address of the member
	 * @return the address of the member
	 */
    public String getAddress() {
        return address;
    }

	/*
	 * This method returns the city of the member
	 * @return the city of the member
	 */
    public String getCity() {
        return city;
    }

	/*
	 * This method returns the state of the member
	 * @return the state of the member
	 */
    public String getState() {
        return state;
    }

	/*
	 * This method returns the zip code of the member
	 * @return the zip code of the member
	 */
    public int getZip() {
        return zip;
    }
	/*
	 * This method sets the name of the member
	 * @param newName the new name of the member
	 */
    public void setName(String newName) {
    	name = newName;
    }
	/*
	 * This method sets the member number
	 * @param newNumber the new member number
	 */
    public void setMemNumber(int newNumber) {
    	memNumber = newNumber;
    }
	/*
	 * This method sets the address of the member
	 * @param newAddress the new address of the member
	 */
    public void setAddress(String newAddress) {
    	address = newAddress;
    }
	/*
	 * This method sets the city of the member
	 * @param newCity the new city of the member
	 */
    public void setCity(String newCity) {
    	city = newCity;
    }
	/*
	 * This method sets the state of the member
	 * @param newState the new state of the member
	 */
    public void setState(String newState) {
    	state = newState;
    }
	/*
	 * This method sets the zip code of the member
	 * @param newZip the new zip code of the member
	 */
    public void setZip(int newZip) {
    	zip = newZip;
    }
}
