package chocAnSystem;
import java.util.Vector;
//Provider Report Class created by EvanChilders
import java.util.*;
import java.util.Date;
//Provider Report class by EvanChilders
/*
 * This class is used to create a provider report for the manager to view
 *
 * @Author Evan Childers
 * @version 1.0
 */
public class ProviderReport {
	String name;
	int number;
	String address;
	String city;
	String state;
	int zip;
	Vector<ProviderReportService> serviceList;
	/*
	 * This method creates a provider report with inputted information
	 *
	 * @param name the name of the provider
	 * @param number the provider number
	 * @param address the address of the provider
	 * @param city the city of the provider
	 * @param state the state of the provider
	 * @param zip the zip code of the provider
	 */
	public ProviderReport(String name, int number, String address, String city, String state, int zip){
		this.name = name;
		this.number = number;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.serviceList = new Vector<ProviderReportService>();
	}
	/*
	 * This method adds a service to the vector of services
	 * @param newService the service to be added
	 */
	public void addService(ProviderReportService newService) {
		serviceList.add(newService);
	}

	//getter and setter methods
	/*
	 * This method returns the name of the provider
	 * @return the name of the provider
	 */
	public String getName() {
		return name;
	}
	/*
	 * This method returns the provider number
	 * @return the provider number
	 */
	public int getNumber() {
        return number;
    }

	/*
	 * This method returns the address of the provider
	 * @return the address of the provider
	 */
    public String getAddress() {
        return address;
    }
	/*
	 * This method returns the city of the provider
	 * @return the city of the provider
	 */
    public String getCity() {
        return city;
    }
	/*
	 * This method returns the state of the provider
	 * @return the state of the provider
	 */
    public String getState() {
        return state;
    }
	/*
	 * This method returns the zip code of the provider
	 * @return the zip code of the provider
	 */
    public int getZip() {
        return zip;
    }
	/*
	 * This method sets the provider name
	 * @param newName the new name of the provider
	 */
    public void setName(String newName) {
    	name = newName;
    }
	/*
	 * This method sets the member number
	 * @param newNumber the new member number
	 */
    public void setMemNumber(int newNumber) {
    	number = newNumber;
    }
	/*
	 * This method sets the address of the provider
	 * @param newAddress the new address of the provider
	 */
    public void setAddress(String newAddress) {
    	address = newAddress;
    }
	/*
	 * This method sets the city of the provider
	 * @param newCity the new city of the provider
	 */
    public void setCity(String newCity) {
    	city = newCity;
    }
	/*
	 * This method sets the state of the provider
	 * @param newState the new state of the provider
	 */
    public void setState(String newState) {
    	state = newState;
    }
	/*
	 * This method sets the zip code of the provider
	 * @param newZip the new zip code of the provider
	 */
    public void setZip(int newZip) {
    	zip = newZip;
    }
}
