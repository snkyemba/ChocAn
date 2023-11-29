package packageWorks;
import java.util.Vector;
import java.util.Iterator;
//Manager Report class by EvanChilders
public class ManagerReport {
	
	
	Vector<ManagerReportProvider> providerList = new Vector<>();
	int numProviders;
	int totalNumConsults = 0;
	double totalFee = 0;
	
	
	public void addProvider(ManagerReportProvider provider) {
		providerList.add(provider);
		
	}
	//runs through the provider vector and adds up the total amount of consultations and fees
	//potentially add something that clears the vector at the end of each week?
	public void calculateTotals() {
		Iterator<ManagerReportProvider> iterator = providerList.iterator();
		numProviders = providerList.size();
		
		while(iterator.hasNext()) {
			ManagerReportProvider currentProvider = iterator.next();
			totalNumConsults += currentProvider.getNumConsult();
			totalFee += currentProvider.getFee();
		}
	}
	public void toFile() {
		//figure out formatting for vector data into file or database
	}
	public void fromFile() {
		//figure out formatting for vector data from file or database
	}
	
	
}
