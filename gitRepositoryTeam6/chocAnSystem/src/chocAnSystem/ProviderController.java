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
    If the file or folder do not exist, they will be created. If they do exist, the new entries will be appended to
    the end of the file... I hope.
     */
    public void saveServiceType(int code, String name, float fee, String filePath) {
        // Create a new instance of the ProviderDirectory class
        ProviderDirectory service = new ProviderDirectory(code, name, fee);

        // Convert the ProviderDirectory instance to a JSON string
        String jsonString = service.toJson();

        // Create a new file object for the file we want to save to
        File file = new File(filePath);

        // Create the folders on the absolute path if they don't exist
        // TODO: Does this even work?
        file.getParentFile().mkdirs();

        // Write the JSON string to the file
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(jsonString);
            writer.close();
        } catch (IOException e) {
            //TODO: Handle this exception
        }
    }
}
