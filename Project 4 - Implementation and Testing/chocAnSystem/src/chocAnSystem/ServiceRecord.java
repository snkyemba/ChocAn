package chocAnSystem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Class for Service Records
 *
 * @author Walter Mink
 * @version 1.0
 */
public class ServiceRecord {
    // Class Attributes. Current date should be in the format MM-dd-yyyy HH:mm:ss
    private String currentDate;
    // Service date should be in the format MM-dd-yyyy
    private String serviceDate;
    // Provider number and Member number should be 9 digits
    private int providerNumber;
    private int memberNumber;
    // Service code should be 6 digits
    private int serviceCode;
    // Comments should be no more than 100 characters
    private String comments;

    /**
     * Basic class constructor for creating new instances of the class
     *
     * @param currentDate Date service was logged in the format MM-dd-yyyy HH:mm:ss stored as a string
     * @param serviceDate Date service was provided in the format MM-dd-yyyy stored as a string
     * @param providerNumber Provider number stored as an integer
     * @param memberNumber Member number stored as an integer
     * @param serviceCode Service code stored as an integer
     * @param comments Comments stored as a string
     */
    public ServiceRecord(String currentDate, String serviceDate, int providerNumber, int memberNumber, int serviceCode, String comments) {
        this.currentDate = currentDate;
        this.serviceDate = serviceDate;

        // Validate provider number
        if (Integer.toString(providerNumber).length() != 9) {
            throw new IllegalArgumentException("Provider number must be 9 digits");
        }

        this.providerNumber = providerNumber;

        // Validate member number
        if (Integer.toString(memberNumber).length() != 9) {
            throw new IllegalArgumentException("Member number must be 9 digits");
        }

        this.memberNumber = memberNumber;

        // Validate service code
        if (Integer.toString(serviceCode).length() != 6) {
            throw new IllegalArgumentException("Service code must be 6 digits");
        }

        this.serviceCode = serviceCode;

        // Validate comments
        if (comments.length() > 100) {
            throw new IllegalArgumentException("Comments must be no more than 100 characters");
        }

        this.comments = comments;
    }

    /**
     * Constructor that allows a class instance to be rebuilt from a JSON string. Uses Gson library for convenience.
     *
     * @param jsonString JSON string to be converted to a Service Record
     */
    public ServiceRecord(String jsonString) {
        // Create a Gson instance
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        ServiceRecord serviceRecord = gson.fromJson(jsonString, ServiceRecord.class);

        this.currentDate = serviceRecord.currentDate;
        this.serviceDate = serviceRecord.serviceDate;

        // Validate provider number
        if (Integer.toString(serviceRecord.providerNumber).length() != 9) {
            throw new IllegalArgumentException("Provider number must be 9 digits");
        }

        this.providerNumber = serviceRecord.providerNumber;

        // Validate member number
        if (Integer.toString(serviceRecord.memberNumber).length() != 9) {
            throw new IllegalArgumentException("Member number must be 9 digits");
        }

        this.memberNumber = serviceRecord.memberNumber;

        // Validate service code
        if (Integer.toString(serviceRecord.serviceCode).length() != 6) {
            throw new IllegalArgumentException("Service code must be 6 digits");
        }

        this.serviceCode = serviceRecord.serviceCode;

        // Validate comments
        if (serviceRecord.comments.length() > 100) {
            throw new IllegalArgumentException("Comments must be no more than 100 characters");
        }

        this.comments = serviceRecord.comments;
    }

    /**
     * Method to convert a Service Record to a JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    /**
     * Method to get the current date
     *
     * @return Current date as a string
     */
    public String getCurrentDate() {
        return currentDate;
    }

    /**
     * Method to get the service date
     *
     * @return Service date as a string
     */
    public String getServiceDate() {
        return serviceDate;
    }

    /**
     * Method to get the provider number
     *
     * @return Provider number as an integer
     */
    public int getProviderNumber() {
        return providerNumber;
    }

    /**
     * Method to get the member number
     *
     * @return Member number as an integer
     */
    public int getMemberNumber() {
        return memberNumber;
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
     * Method to get the comments
     *
     * @return Comments as a string
     */
    public String getComments() {
        return comments;
    }
}
