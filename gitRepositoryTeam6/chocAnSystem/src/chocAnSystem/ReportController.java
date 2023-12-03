package chocAnSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

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
    	/*Calendar cal = Calendar.getInstance();
    	cal.set(Calendar.YEAR, 1988);
    	cal.set(Calendar.MONTH, Calendar.JANUARY);
    	cal.set(Calendar.DAY_OF_MONTH, 1);
    	String myDate = "01/01/1988";
    	MemberReportService myService = new MemberReportService(myDate, "Provider1", "Service1");
        memberReport.addService(myService);*/
        Vector<MemberRecord> vector = new Vector<MemberRecord>();
        String filePath = "memberFile.json";

            // Step 1: Deserialize the existing JSON file into a Vector of objects
            try {
                MemberRecord record = new MemberRecord();
                vector = GenericSerializer.deserializeJsonArray(filePath, (Class<MemberRecord>) record.getClass());
            } catch (IOException e) {
                e.printStackTrace();
                // Handle exceptions or return from the method
            }
            //loop through vector and write contents to file
            try {
                FileWriter myWriter = new FileWriter("memberReport.txt");
                for (int i = 0; i < vector.size(); i++) {
                    MemberRecord record = vector.get(i);
                    myWriter.write("Member name: " + record.getName() + "\n");
                    myWriter.write("Member number: " + record.getNumber() + "\n");
                    myWriter.write("Member address: " + record.getAddress() + "\n");
                    myWriter.write("Member city: " + record.getCity() + "\n");
                    myWriter.write("Member state: " + record.getState() + "\n");
                    myWriter.write("Member zip: " + record.getZip() + "\n");
                    myWriter.write("\n");
                }
                myWriter.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        //GenericSerializer.deserializeJsonArray("memberReport.json", MemberReport.class);
        //System.out.println("generate member report here");
    }

    public void generateManagerReport() {
        /*ManagerReportProvider provider1 = new ManagerReportProvider("Provider1", 10, 100);
        managerReport.addProvider(provider1);
        managerReport.calculateTotals();*/
        System.out.println("generate manager report here");
    }

    public void generateProviderReport() {
    	/*Calendar cal = Calendar.getInstance();
    	cal.set(Calendar.YEAR, 1988);
    	cal.set(Calendar.MONTH, Calendar.JANUARY);
    	cal.set(Calendar.DAY_OF_MONTH, 1);
        String myDate = "01/01/1988";
        providerReport.addService(new ProviderReportService(myDate, "Provider1", "Service1", 50.0));*/
        System.out.println("generate provider report here");
    }

}
