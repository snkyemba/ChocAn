package chocAnSystem;
import java.util.Date;
import com.google.gson.Gson;

public class ServiceRecord {
    private Date currentDate;
    private Date serviceDate;
    private int providerNumber;
    private int memberNumber;
    private int serviceCode;
    private String comments;

    // Basic class constructor for creating new instances of the class
    public ServiceRecord(Date currentDate, Date serviceDate, int providerNumber, int memberNumber, int serviceCode, String comments) {
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
        Gson gson = new Gson();
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

    public Date getCurrentDate() {
        return currentDate;
    }

    public Date getServiceDate() {
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
