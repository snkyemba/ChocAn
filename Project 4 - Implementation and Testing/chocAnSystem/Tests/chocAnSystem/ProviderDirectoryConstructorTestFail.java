package chocAnSystem;

import org.junit.Test;

public class ProviderDirectoryConstructorTestFail {
    // Test data with bad values
    int serviceCodeShort = 12345;
    int serviceCodeLong = 1234567;
    int serviceCode = 123456;
    String serviceNameLong = "This service name is too long to be valid.";
    String serviceName = "Test Service";
    float serviceFee = 123.45f;
    String jsonStringShortCode = "{\"serviceCode\":12345,\"serviceName\":\"Test Service\",\"serviceFee\":123.45}";
    String jsonStringLongCode = "{\"serviceCode\":1234567,\"serviceName\":\"Test Service\",\"serviceFee\":123.45}";
    String jsonStringLongName = "{\"serviceCode\":123456,\"serviceName\":\"This service name is too long to be valid.\",\"serviceFee\":123.45}";

    // Test objects
    ProviderDirectory testMainShortCode;
    ProviderDirectory testMainLongCode;
    ProviderDirectory testMainLongName;
    ProviderDirectory testJsonShortCode;
    ProviderDirectory testJsonLongCode;
    ProviderDirectory testJsonLongName;

    // Tests main & Json constructors with bad values
    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorShortCode() {
        testMainShortCode = new ProviderDirectory(serviceCodeShort, serviceName, serviceFee);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorLongCode() {
        testMainLongCode = new ProviderDirectory(serviceCodeLong, serviceName, serviceFee);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMainConstructorLongName() {
        testMainLongName = new ProviderDirectory(serviceCode, serviceNameLong, serviceFee);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJsonConstructorShortCode() {
        testJsonShortCode = new ProviderDirectory(jsonStringShortCode);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJsonConstructorLongCode() {
        testJsonLongCode = new ProviderDirectory(jsonStringLongCode);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJsonConstructorLongName() {
        testJsonLongName = new ProviderDirectory(jsonStringLongName);
    }
}