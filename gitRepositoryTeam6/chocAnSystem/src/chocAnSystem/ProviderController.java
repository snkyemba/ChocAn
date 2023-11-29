package chocAnSystem;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class ProviderController {
    /*
    List of Methods we need to implement:
    - verifyProvider
    - verifyMember
    - addMember (Testing only) STARTED
        - Needs to save member to file, create new file if it doesn't exist yet
    - addProvider (Testing only) STARTED
        - Needs to save provider to file, create new file if it doesn't exist yet
    - lookupServiceByCode
    - lookupServiceByName
    - listServices
    - addService (testing only) STARTED
        - Needs to save service to file, create new file if it doesn't exist yet
    - addServiceRecord STARTED
        - Needs to save service record to file, create new file if it doesn't exist yet
     */

    /*
    I need a function that can read a JSON file and deserialize it into an array regardless of what type of object is in the file.
    How can I do this?
     */

    /*
    Testing method for creating a provider directory with entries. Takes service info and a file path as parameters.
    If the file doesn't exist, it will be created. If it does exist, the new entry will be appended to the end of the file.
     */
    public void saveServiceType(int code, String name, float fee, String filePath) {
        // Create new ProviderDirectory object and convert to JSON string
        ProviderDirectory entry = new ProviderDirectory(code, name, fee);
        String jsonString = entry.toJson();

        // Write JSON string to file
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(jsonString + " ");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to create / add to file containing provider or member ID Numbers
    public void saveIDNumber(int idNumber, String filePath) {
        // Convert ID number to string
        String idString = Integer.toString(idNumber);

        // Write ID number to file
        // TODO: Can I make this a separate method? It would make the code more concise
        // TODO: Make function write to end of array since JSON only allows one object per file
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(idString + " ");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to create / add to file containing service records
    public void saveServiceRecord(String serviceDate, int providerNumber, int memberNumber, int serviceCode, String comments, String filePath) {
        // Get current date and time
        Date date = new Date();
        SimpleDateFormat currentFormatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        String currentDateString = currentFormatter.format(date);

        // Convert service record info to JSON string
        ServiceRecord record = new ServiceRecord(currentDateString, currentDateString, providerNumber, memberNumber, serviceCode, comments);
        String jsonString = record.toJson();

        // Write JSON string to file
        // TODO: Can I make this a separate method? It would make the code more concise
        // TODO: Make function write to end of array since JSON only allows one object per file
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(jsonString + " ");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
