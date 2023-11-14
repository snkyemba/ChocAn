package chocAnSystem;

import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class tests the ProviderDirectory constructors.
 */
public class ProviderDirectoryConstructorTestSuccess {

    // Test data and expected values
    int serviceCode = 123456;
    String serviceName = "Test Service";
    float serviceFee = 123.45f;
    String jsonString = "{\"serviceCode\":123456,\"serviceName\":\"Test Service\",\"serviceFee\":123.45}";

    // Test objects
    ProviderDirectory testEntry1;
    ProviderDirectory testEntry2;

    // Test setup for main constructor
    @Before
    public void setUpMainConstructor() throws Exception {
        testEntry1 = new ProviderDirectory(serviceCode, serviceName, serviceFee);
    }

    // Test setup for JSON constructor
    @Before
    public void setUpJsonConstructor() throws Exception {
        testEntry2 = new ProviderDirectory(jsonString);
    }

    // Test main constructor works as expected
    @Test
    public void testMainConstructor() {
        assertEquals(testEntry1.getServiceCode(), serviceCode);
        assertEquals(testEntry1.getServiceName(), serviceName);
        assertEquals(testEntry1.getServiceFee(), serviceFee, 0.001);
    }

    // Test JSON constructor works as expected
    @Test
    public void testJsonConstructor() {
        assertEquals(testEntry2.getServiceCode(), serviceCode);
        assertEquals(testEntry2.getServiceName(), serviceName);
        assertEquals(testEntry2.getServiceFee(), serviceFee, 0.001);
    }
}