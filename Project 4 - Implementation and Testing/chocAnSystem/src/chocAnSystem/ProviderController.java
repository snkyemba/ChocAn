package chocAnSystem;

import java.util.Date;
import java.util.Vector;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.util.Optional;

/**
 * Class for controlling logic for Provider Terminal
 *
 * @author Walter Mink, Rayshaun Dunkin
 * @version 1.0
 */
public class ProviderController {
    /**
     * Function to save service type to JSON file
     *
     * @param code Six digit service code stored as an integer
     * @param name Service name stored as a string
     * @param fee Service fee stored as a float
     * @param filePath Path to JSON file to be written to
     */
    public void saveServiceType(int code, String name, float fee, String filePath) {
        // Create new ProviderDirectory object and convert to JSON string
        ProviderDirectory entry = new ProviderDirectory(code, name, fee);

        // Write JSON string to file
        GenericSerializer.processJsonFile(filePath, entry);
    }

    /**
     * Function to save service record to JSON file
     *
     * @param serviceDate Date service was provided in the format MM-dd-yyyy stored as a string
     * @param providerNumber Provider number stored as an integer
     * @param memberNumber Member number stored as an integer
     * @param serviceCode Service code stored as an integer
     * @param comments Comments stored as a string
     * @param filePath Path to JSON file to be written to
     */
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

    /**
     * Function to save user ID number to JSON file
     *
     * @param idNumber ID number to be saved
     * @param filePath Path to JSON file to be written to
     */
    public void saveIDNumber(int idNumber, String filePath) {
        // Write JSON string to file
        GenericSerializer.processJsonFile(filePath, idNumber);
    }

    /**
     * Function to check if ID number is in JSON file
     *
     * @param idNumber ID number to be checked
     * @param filePath Path to JSON file to be read from
     * @return Boolean value indicating whether ID number is in JSON file
     */
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

        if (idNumbers.isEmpty()) {
            return false;
        }

        // Check if ID number is in Vector
        return idNumbers.contains(idNumber);
    }

    /**
     * Function to search JSON file for service code and return ProviderDirectory object
     *
     * @param serviceCode Service code to be searched for
     * @param filePath Path to JSON file to be read from
     * @return Optional containing ProviderDirectory object if service code is found, empty Optional otherwise
     */
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

    /**
     * Function to search JSON file for service name and return ProviderDirectory object
     *
     * @param serviceName Service name to be searched for
     * @param filePath Path to JSON file to be read from
     * @return Optional containing ProviderDirectory object if service name is found, empty Optional otherwise
     */
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

    /**
     * Function to get all service types from JSON file
     *
     * @param filePath Path to JSON file to be read from
     * @return Vector containing all service types
     */
    public Vector<ProviderDirectory> getServiceTypes(String filePath) {
        // Create new Vector to hold service types
        Vector<ProviderDirectory> serviceTypes = new Vector<>();

        // Deserialize JSON file into Vector
        try {
            serviceTypes = GenericSerializer.deserializeJsonArray(filePath, ProviderDirectory.class);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions or return from the method
        }

        // Return Vector
        return serviceTypes;
    }

    /**
     * Function to get all service records from JSON file
     *
     * @param filePath Path to JSON file to be read from
     * @return Vector containing all service records
     */
    public Vector<ServiceRecord> getServiceRecords(String filePath) {
        // Create new Vector to hold service records
        Vector<ServiceRecord> serviceRecords = new Vector<>();

        // Deserialize JSON file into Vector
        try {
            serviceRecords = GenericSerializer.deserializeJsonArray(filePath, ServiceRecord.class);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions or return from the method
        }

        // Return Vector
        return serviceRecords;
    }
}
