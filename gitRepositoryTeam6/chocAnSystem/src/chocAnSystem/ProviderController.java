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
    - addMember (Testing only)
        - Needs to save member to file, create new file if it doesn't exist yet
    - addProvider (Testing only)
        - Needs to save provider to file, create new file if it doesn't exist yet
    - lookupServiceByCode
    - lookupServiceByName
    - listServices
    - addService (testing only)
        - Needs to save service to file, create new file if it doesn't exist yet
    - addServiceRecord
        - Needs to save service record to file, create new file if it doesn't exist yet
     */

    /*
    Testing method for creating a provider directory with entries. Takes service info and a file path as parameters.
    If the file doesn't exist, it will be created. If it does exist, the new entry will be appended to the end of the file.
     */
    public void saveServiceType(int code, String name, float fee, String filePath) throws IOException {
        ProviderDirectory entry = new ProviderDirectory(code, name, fee);
        String jsonString = entry.toJson();

        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(jsonString + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Error writing to file");
        }
    }
}
