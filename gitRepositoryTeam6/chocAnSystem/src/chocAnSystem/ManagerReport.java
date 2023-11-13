package chocAnSystem;
import java.util.Vector;
import java.util.Iterator;
//Manager Report class by EvanChilders
public class ManagerReport {
	
	class Provider{
		private String provider;
		private int numConsult;
		private int fee;
		
		public Provider(String provider, int numConsult, int fee) {
			this.provider = provider;
			this.numConsult = numConsult;
			this.fee = fee;
	}
	Vector<Provider> providerList = new Vector<>();
	int numProviders;
	int totalNumConsults = 0;
	double totalFee = 0;
	
	
	public void addProvider(Provider provider) {
		providerList.add(provider);
		
	}
	//runs through the provider vector and adds up the total amount of consultations and fees
	//potentially add something that clears the vector at the end of each week?
	public void calculateTotals() {
		Iterator<Provider> iterator = providerList.iterator();
		numProviders = providerList.size();
		
		while(iterator.hasNext()) {
			Provider currentProvider = iterator.next();
			totalNumConsults += currentProvider.numConsult;
			totalFee += currentProvider.fee;
		}
	}
	public void toFile() {
		//figure out formatting for vector data into file or database
	}
	public void fromFile() {
		//figure out formatting for vector data from file or database
	}
	//getter and setter methods
	public String getProvider() {
		return provider;
	}
	public int getNumConsult() {
		return numConsult;
	}
	public int getFee() {
		return fee;
	}
	public Vector<Provider> getProviderList() {
		return providerList;
	}
	public void setProvider(String newProvider) {
		provider = newProvider;
	}
	public void setNumConsult(int newNumConsult) {
		numConsult = newNumConsult;
	}
	public void setFee(int newFee) {
		fee = newFee;
	}
	
}
}