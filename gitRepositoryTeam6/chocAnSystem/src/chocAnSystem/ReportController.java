package chocAnSystem;
import chocAnSystem.Report;

public class ReportController {
	
	private MemberReport memberReport;
	private ManagerReport managerReport;
	private ProviderReport providerReport;
	private ManagerTerminal view;
	
	public ReportController() {
        this.memberReport = new MemberReport("John Doe", 123, "123 Main St", "City", "State", 12345);
        this.managerReport = new ManagerReport();
        this.providerReport = new ProviderReport("Provider Name", 456, "456 Oak St", "City", "State", 67890);
    }

    public void generateMemberReport() {
        // Additional logic to generate member report
        // For example:
        memberReport.addService(new MemberReport.Service("01-01-22", "Provider1", "Service1"));
        //memberReport.toFile();
    }

    public void generateManagerReport() {
        // Additional logic to generate manager report
        // For example:
        ManagerReport.Provider provider1 = new ManagerReport.Provider("Provider1", 10, 100);
        managerReport.addProvider(provider1);
        managerReport.calculateTotals();
        //managerReport.toFile();
    }

    public void generateProviderReport() {
        // Additional logic to generate provider report
        // For example:
        providerReport.addService(new ProviderReport.Service("01-01-22", "Service1", 50.0));
        //providerReport.toFile();
    }
}
