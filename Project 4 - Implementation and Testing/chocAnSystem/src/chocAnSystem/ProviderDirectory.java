package chocAnSystem;

import com.google.gson.Gson;

/**
 * Class for Provider Directory entries
 *
 * @author Walter Mink
 * @version 1.0
 */
public class ProviderDirectory {
    // Class Attributes. Service code should be 6 digits and service name should be no more than 20 characters
    private int serviceCode;
    private String serviceName;
    private float serviceFee;

    /**
     * Basic class constructor for creating new instances of the class
     *
     * @param serviceCode 6 digit service code stored as an integer
     * @param serviceName Service name stored as a string
     * @param serviceFee Service fee stored as a float
     */
    public ProviderDirectory(int serviceCode, String serviceName, float serviceFee) {
        // Validate service code
        if (Integer.toString(serviceCode).length() != 6) {
            throw new IllegalArgumentException("Service code must be 6 digits");
        }

        // Validate service name
        if (serviceName.length() > 20) {
            throw new IllegalArgumentException("Service name must be no more than 20 characters");
        }

        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceFee = serviceFee;
    }

    /**
     * Constructor that allows a class instance to be rebuilt from a JSON string. Uses Gson library for convenience.
     *
     * @param jsonString JSON string to be converted to a Provider Directory Entry
     */
    public ProviderDirectory(String jsonString) {
        Gson gson = new Gson();
        ProviderDirectory directoryEntry = gson.fromJson(jsonString, ProviderDirectory.class);

        // Validate service code
        if (Integer.toString(directoryEntry.serviceCode).length() != 6) {
            throw new IllegalArgumentException("Service code must be 6 digits");
        }

        // Validate service name
        if (directoryEntry.serviceName != null && directoryEntry.serviceName.length() > 20) {
            throw new IllegalArgumentException("Service name must be no more than 20 characters");
        }

        this.serviceCode = directoryEntry.serviceCode;
        this.serviceName = directoryEntry.serviceName;
        this.serviceFee = directoryEntry.serviceFee;
    }

    /**
     * Method to convert a Provider Directory Entry to a JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    /**
     * Method to get the service code
     *
     * @return Service code as an integer
     */
    public int getServiceCode() {
        return serviceCode;
    }

    /**
     * Method to get the service name
     *
     * @return Service name as a string
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Method to get the service fee
     *
     * @return Service fee as a float
     */
    public float getServiceFee() {
        return serviceFee;
    }
}
