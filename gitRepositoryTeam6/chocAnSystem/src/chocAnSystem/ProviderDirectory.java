package chocAnSystem;

public class ProviderDirectory {
    private int serviceCode;
    private String serviceName;

    public ProviderDirectory(int serviceCode, String serviceName) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
    }

    public int getServiceCode() {
        return serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }
}
