package chocAnSystem;

import java.util.Date;
import java.util.Vector;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.util.Optional;

public class ProviderController {
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

    // Method to check JSON file for user ID for verification
    public boolean checkIDNumber(int idNumber, String filePath) {
        // Create new Vector to hold ID numbers
        Vector<Integer> idNumbers = new Vector<>();

        // Deserialize JSON file into Vector
        try {
            idNumbers = GenericSerializer.deserializeJsonArray(filePath, Integer.class);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions or return from the method
        }

        // Check if ID number is in Vector
        return idNumbers.contains(idNumber);
    }

    // Method to search JSON file for service code and return ProviderDirectory object
    public Optional<ProviderDirectory> searchServiceCode(int serviceCode, String filePath) {
        // Create new Vector to hold service codes
        Vector<ProviderDirectory> serviceTypes = new Vector<>();

        // Deserialize JSON file into Vector
        try {
            serviceTypes = GenericSerializer.deserializeJsonArray(filePath, ProviderDirectory.class);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions or return from the method
        }

        // Search Vector for service code
        for (ProviderDirectory entry : serviceTypes) {
            if (entry.getServiceCode() == serviceCode) {
                return Optional.of(entry);
            }
        }

        // Return empty Optional if service code is not found
        return Optional.empty();
    }

    // Method to search JSON file for service name and return ProviderDirectory object
    public Optional<ProviderDirectory> searchServiceName(String serviceName, String filePath) {
        // Create new Vector to hold service codes
        Vector<ProviderDirectory> serviceTypes = new Vector<>();

        // Deserialize JSON file into Vector
        try {
            serviceTypes = GenericSerializer.deserializeJsonArray(filePath, ProviderDirectory.class);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions or return from the method
        }

        // Search Vector for service code
        for (ProviderDirectory entry : serviceTypes) {
            if (entry.getServiceName().equalsIgnoreCase(serviceName)) {
                return Optional.of(entry);
            }
        }

        // Return empty Optional if service code is not found
        return Optional.empty();
    }
}
