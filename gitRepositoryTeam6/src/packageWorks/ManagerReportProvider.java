package packageWorks;

import java.util.Vector;

public class ManagerReportProvider {

	private String provider;
	private int numConsult;
	private int fee;
	
	public ManagerReportProvider(String provider, int numConsult, int fee) {
		this.provider = provider;
		this.numConsult = numConsult;
		this.fee = fee;
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
		public Vector<ManagerReportProvider> getProviderList() {
			return getProviderList();
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
