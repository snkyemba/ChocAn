package chocAnSystem;
import java.util.Date;
import java.util.Vector;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class ProviderController {
    private List<ProviderDirectory> providerList;
    public boolean verifyProvider(int providerNumber) {
        List<ProviderDirectory> providers = getProviderList();
        for (ProviderDirectory provider : providers) {
            if (provider.getProviderNumber() == providerNumber) {
                return true; // Provider found
            }
        }
        return false; // Provider not found
    }
    private List<ProviderDirectory> getProviderList() {
        return providerList;
    }
    private List<MemberRecord> memberList;
    public boolean verifyMember(int memberNumber) {
        List<MemberRecord> members = getMemberList();
        for (MemberRecord member : members) {
            if (member.getMemberNumber() == memberNumber) {
                return true; // Member found
            }
        }
        return false; // Member not found
    }
    private List<MemberRecord> getMemberList() {
        return memberList;
    }
    private List<ServiceRecord> serviceList;
    public ServiceRecord lookupServiceByCode(int serviceCode) {
        List<ServiceRecord> services = getServiceList();
        for (ServiceRecord service : services) {
            if (service.getServiceCode() == serviceCode) {
                return service; // Service found
            }
        }
        return null; // Service not found
    }
    private List<ServiceRecord> getServiceList() {
        return serviceList;
    }
    private List<ServiceRecord> serviceList;
    public ServiceRecord lookupServiceByName(String serviceName) {
        List<ServiceRecord> services = getServiceList();
        for (ServiceRecord service : services) {
            if (service.getServiceName().equalsIgnoreCase(serviceName)) {
                return service; // Service found
            }
        }
        return null; // Service not found
    }
    private List<ServiceRecord> getServiceList() {
        return serviceList;
    }
    private List<ServiceRecord> serviceList;
    public List<ServiceRecord> listServices() {
        List<ServiceRecord> services = getServiceList();
        return services;
    }
    private List<ServiceRecord> getServiceList() {
        return serviceList;
    }
    /*
    List of Methods we need to implement:
    - verifyProvider
    - verifyMember
    - lookupServiceByCode
    - lookupServiceByName
    - listServices
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
