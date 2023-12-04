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
        Vector<MemberRecord> vector = new Vector<MemberRecord>();
        Vector<ServiceRecord> vector2 = new Vector<ServiceRecord>();
        String filePath = "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/memberFile.json";
        String filePath2 = "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/serviceRecords.json";
            // Step 1: Deserialize the existing JSON file into a Vector of objects
            try {
                vector = GenericSerializer.deserializeJsonArray(filePath, (Class<MemberRecord>) MemberRecord.class);
                vector2 = GenericSerializer.deserializeJsonArray(filePath2, (Class<ServiceRecord>) ServiceRecord.class);
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
                    for (int j = 0; j < vector2.size(); j++){
                        ServiceRecord record2 = vector2.get(j);
                        if (record2.getMemberNumber() == memberReport.getMemNumber()){
                            myWriter.write("Service date: " + record2.getServiceDate() + "\n");
                            myWriter.write("Provider number: " + record2.getProviderNumber() + "\n");
                            myWriter.write("Service code: " + record2.getServiceCode() + "\n");
                            myWriter.write("Comments: " + record2.getComments() + "\n");
                            myWriter.write("\n");
                        }
                    }
                }

                myWriter.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void generateManagerReport() {
        System.out.println("generate manager report here");
    }

    public void generateProviderReport() {
        Vector<ProviderRecord> vector = new Vector<ProviderRecord>();
        String filePath = "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/providerFile.json";

        // Step 1: Deserialize the existing JSON file into a Vector of objects
        try {
            ProviderRecord record = new ProviderRecord();
            vector = GenericSerializer.deserializeJsonArray(filePath, (Class<ProviderRecord>) record.getClass());
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions or return from the method
        }
        //loop through vector and write contents to file
        try {
            FileWriter myWriter = new FileWriter("providerReport.txt");
            for (int i = 0; i < vector.size(); i++) {
                ProviderRecord record = vector.get(i);
                myWriter.write("Provider name: " + record.getName() + "\n");
                myWriter.write("Provider number: " + record.getNumber() + "\n");
                myWriter.write("Provider address: " + record.getAddress() + "\n");
                myWriter.write("Provider city: " + record.getCity() + "\n");
                myWriter.write("Provider state: " + record.getState() + "\n");
                myWriter.write("Provider zip: " + record.getZip() + "\n");
                myWriter.write("\n");
            }
            myWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
