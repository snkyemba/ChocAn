package chocAnSystem;
import java.util.Vector;
import java.util.Iterator;
//Manager Report class by EvanChilders
/*
 * This class is used to create a manager report for the manager to view
 *
 * @author Evan Childers
 * @version 1.0
 */
public class ManagerReport {
	
	
	Vector<ManagerReportProvider> providerList = new Vector<>();
	int numProviders;
	int totalNumConsults = 0;
	double totalFee = 0;
	
	/*
	 * This method adds a provider to the vector of providers
	 * @param provider the provider to be added
	 */
	public void addProvider(ManagerReportProvider provider) {
		providerList.add(provider);
		
	}
	//runs through the provider vector and adds up the total amount of consultations and fees
	//potentially add something that clears the vector at the end of each week?
	/*
	 * This method calculates the total number of providers, total number of consultations, and total fees
	 */
	public void calculateTotals() {
		Iterator<ManagerReportProvider> iterator = providerList.iterator();
		numProviders = providerList.size();
		
		while(iterator.hasNext()) {
			ManagerReportProvider currentProvider = iterator.next();
			totalNumConsults += currentProvider.getNumConsult();
			totalFee += currentProvider.getFee();
		}
	}
	
	
}
