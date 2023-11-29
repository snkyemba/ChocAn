package chocAnSystem;
import java.util.Date;
import java.util.Vector;
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

    // Method to create / add to file containing provider records
    public void saveServiceType(int code, String name, float fee, String filePath) {
        // Create new ProviderDirectory object and convert to JSON string
        ProviderDirectory entry = new ProviderDirectory(code, name, fee);

        // Write JSON string to file
        GenericSerializer.processJsonFile(filePath, entry);
    }

    // Method to create / add to file containing service records
    public void saveServiceRecord(String serviceDate, int providerNumber, int memberNumber, int serviceCode, String comments, String filePath) {
        // Get current date and time
        Date date = new Date();
        SimpleDateFormat currentFormatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        String currentDateString = currentFormatter.format(date);

        // Convert service record info to JSON string
        ServiceRecord record = new ServiceRecord(currentDateString, serviceDate, providerNumber, memberNumber, serviceCode, comments);

        // Write JSON string to file
        GenericSerializer.processJsonFile(filePath, record);
    }

    // Method to create / add to JSON file containing user IDs
    public void saveIDNumber(int idNumber, String filePath) {
        // Write JSON string to file
        GenericSerializer.processJsonFile(filePath, idNumber);
    }
}
