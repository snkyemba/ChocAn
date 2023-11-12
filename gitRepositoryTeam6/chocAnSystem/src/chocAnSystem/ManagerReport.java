package chocAnSystem;
import java.util.Vector;
import java.util.Iterator;

public class ManagerReport {
	
	class Provider{
		String provider;
		int numConsult;
		int fee;
	}
	Vector<Provider> providerList = new Vector<>();
	int numProviders;
	int totalNumConsults = 0;
	double totalFee = 0;
	
	
	public void addProvider(Provider provider) {
		providerList.add(provider);
		
	}
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
}
