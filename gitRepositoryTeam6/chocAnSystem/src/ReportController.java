package chocAnSystem;

import java.util.Calendar;
import java.util.Date;
/** This class is by Sophia Kyemba. */
public class ReportController {

	private MemberReport memberReport;
	private ManagerReport managerReport;
	private ProviderReport providerReport;
	//private ManagerTerminal view;
	
	public ReportController() {
        this.memberReport = new MemberReport("John Doe", 123, "123 Main St", "City", "State", 12345);
        this.managerReport = new ManagerReport();
        this.providerReport = new ProviderReport("Provider Name", 456, "456 Oak St", "City", "State", 67890);
    }

    public void generateMemberReport() {
    	Calendar cal = Calendar.getInstance();
    	cal.set(Calendar.YEAR, 1988);
    	cal.set(Calendar.MONTH, Calendar.JANUARY);
    	cal.set(Calendar.DAY_OF_MONTH, 1);
    	Date myDate = cal.getTime();
    	MemberReportService myService = new MemberReportService(myDate, "Provider1", "Service1");
        memberReport.addService(myService);
        System.out.println("generate member report here");
    }

    public void generateManagerReport() {
        ManagerReportProvider provider1 = new ManagerReportProvider("Provider1", 10, 100);
        managerReport.addProvider(provider1);
        managerReport.calculateTotals();
        System.out.println("generate manager report here");
    }

    public void generateProviderReport() {
    	Calendar cal = Calendar.getInstance();
    	cal.set(Calendar.YEAR, 1988);
    	cal.set(Calendar.MONTH, Calendar.JANUARY);
    	cal.set(Calendar.DAY_OF_MONTH, 1);
    	Date myDate = cal.getTime();
        providerReport.addService(new ProviderReportService(myDate, "Provider1", "Service1", 50.0));
        System.out.println("generate provider report here");
    }

}
