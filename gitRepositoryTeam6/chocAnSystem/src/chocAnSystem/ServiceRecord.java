package chocAnSystem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// This class for Service Record entries is by Walter Mink
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

    // Basic class constructor for creating new instances of the class
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

    // Constructor that allows a class instance to be rebuilt from a JSON string. Uses Gson library for convenience.
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

    // Class function that converts a Service Record to a JSON string for saving in a file
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // Value getters
    public String getCurrentDate() {
        return currentDate;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public int getProviderNumber() {
        return providerNumber;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public int getServiceCode() {
        return serviceCode;
    }

    public String getComments() {
        return comments;
    }
}
