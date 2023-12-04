package chocAnSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 * Class for controlling the request report logic for the Manager Terminal
 *
 * @author Sophia Kyemba
 * @version 1.0
 */
public class ReportController {

	private MemberReport memberReport;
	private ManagerReport managerReport;
	private ProviderReport providerReport;
	//private ManagerTerminal view;

    /**
     * Constructor for ReportController
     *
     */
	public ReportController() {
        this.memberReport = new MemberReport("John Doe", 123, "123 Main St", "City", "State", 12345);
        this.managerReport = new ManagerReport();
        this.providerReport = new ProviderReport("Provider Name", 456, "456 Oak St", "City", "State", 67890);
    }

    /**
     * Function to generate a member report
     *
     */
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
                        if (record2.getMemberNumber() == record.getNumber()){
                            myWriter.write("\tService date: " + record2.getServiceDate() + "\n");
                            myWriter.write("\tProvider number: " + record2.getProviderNumber() + "\n");
                            myWriter.write("\tService code: " + record2.getServiceCode() + "\n");
                            myWriter.write("\tComments: " + record2.getComments() + "\n");
                            myWriter.write("\n");
                        }
                    }
                    myWriter.write("\n");
                }

                myWriter.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
    }

    /**
     * Function to generate a manager report
     *
     */
    public void generateManagerReport() {
        Vector<ProviderRecord> providerVector = new Vector<ProviderRecord>();
        Vector<ServiceRecord> serviceVector = new Vector<ServiceRecord>();
        int numConsults = 0;
        int numProvidersGivenConsults = 0;
        double totalFee = 0;
        String filePath = "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/providerFile.json";
        String filePath2 = "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/serviceRecords.json";
        try{
            FileWriter myWriter = new FileWriter("managerReport.txt");
            providerVector = GenericSerializer.deserializeJsonArray(filePath, (Class<ProviderRecord>) ProviderRecord.class);
            serviceVector = GenericSerializer.deserializeJsonArray(filePath2, (Class<ServiceRecord>) ServiceRecord.class);
            //list every provider to be paid
            for (int i = 0; i < providerVector.size(); i++){
                ProviderRecord record = providerVector.get(i);
                myWriter.write("Provider name: " + record.getName() + "\n");
                //list number of consultations for each provider
                for (int j = 0; j < serviceVector.size(); j++){
                    ServiceRecord record2 = serviceVector.get(j);
                    if (record2.getProviderNumber() == (int) record.getProviderNumber()){
                        numConsults++;
                    }
                }
                if(numConsults > 0){
                    numProvidersGivenConsults++;
                }
                myWriter.write("\tNumber of consultations: " + numConsults + "\n");
                //list total fee for each provider
                myWriter.write("\tTotal fee for week: " + record.getFee()*numConsults + "\n");
                totalFee += record.getFee()*numConsults;
                myWriter.write("\n");
            }
            //total number of providers with numconsults > 0
            myWriter.write("Total number of providers given consultations: " + numProvidersGivenConsults + "\n");
            //overall total fee for week
            myWriter.write("Overall total fee for week: " + totalFee + "\n");

        }
        catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions or return from the method
        }
    }

    /**
     * Function to generate a provider report
     *
     */
    public void generateProviderReport() {
        int numConsults = 0;
        Vector<ProviderRecord> vector = new Vector<ProviderRecord>();
        Vector<ServiceRecord> vector2 = new Vector<ServiceRecord>();
        Vector<MemberRecord> vector3 = new Vector<MemberRecord>();
        String filePath = "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/providerFile.json";
        String filePath2 = "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/serviceRecords.json";
        String filePath3 = "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/memberFile.json";
        // Step 1: Deserialize the existing JSON file into a Vector of objects
        try {
            ProviderRecord record = new ProviderRecord();
            vector = GenericSerializer.deserializeJsonArray(filePath, (Class<ProviderRecord>) ProviderRecord.class);
            vector2 = GenericSerializer.deserializeJsonArray(filePath2, (Class<ServiceRecord>) ServiceRecord.class);
            vector3 = GenericSerializer.deserializeJsonArray(filePath3, (Class<MemberRecord>) MemberRecord.class);

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
                for (int j = 0; j < vector2.size(); j++){
                    ServiceRecord record2 = vector2.get(j);
                    if (record2.getProviderNumber() == (int) record.getProviderNumber()){
                        numConsults++;
                        myWriter.write("\tService date: " + record2.getServiceDate() + "\n");
                        myWriter.write("\tDate received by computer: " + record2.getCurrentDate() + "\n");
                        for(int k = 0; k < vector.size(); k++){
                            MemberRecord record3 = vector3.get(k);
                            if(record3.getNumber() == record2.getMemberNumber()){
                                myWriter.write("\tMember name: " + record3.getName() + "\n");
                            }
                        }
                        myWriter.write("\tMember number: " + record2.getMemberNumber() + "\n");
                        myWriter.write("\tService code: " + record2.getServiceCode() + "\n");
                        myWriter.write("\tFee: " + record.getFee() + "\n");
                        myWriter.write("\n");
                    }
                }
                myWriter.write("Total number of consultations: " + numConsults + "\n");
                myWriter.write("Total fee for week: " + record.getFee()*numConsults + "\n\n");
            }
            myWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
