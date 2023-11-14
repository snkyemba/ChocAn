package chocAnSystem;
import com.google.gson.Gson;

/*
Class for entries in a Provider Directory that has elements for a service code, service name, and service fee.
 */
public class ProviderDirectory {

    // Class Attributes. Service code should be 6 digits and service name should be no more than 20 characters
    private int serviceCode;
    private String serviceName;
    private float serviceFee;

    // Basic class constructor for creating new instances of the class
    public ProviderDirectory(int serviceCode, String serviceName, float serviceFee) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceFee = serviceFee;
    }

    // Constructor that allows a class instance to be rebuilt from a JSON string. Uses Gson library for convenience.
    public ProviderDirectory(String jsonString) {
        Gson gson = new Gson();
        ProviderDirectory directoryEntry = gson.fromJson(jsonString, ProviderDirectory.class);

        this.serviceCode = directoryEntry.serviceCode;
        this.serviceName = directoryEntry.serviceName;
        this.serviceFee = directoryEntry.serviceFee;
    }

    // Class function that converts a Provider Directory Entry to a JSON string for saving in a file
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // Value getters
    public int getServiceCode() {
        return serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public float getServiceFee() {
        return serviceFee;
    }
}
