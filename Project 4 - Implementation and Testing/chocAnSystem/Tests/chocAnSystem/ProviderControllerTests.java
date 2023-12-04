package chocAnSystem;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProviderControllerTests {
    // Test data for saving provider directory entries
    int serviceCode = 123456;
    String serviceName = "Test Service";
    float serviceFee = 123.45f;
    String testSaveServiceFilePath = "Project 4 - Implementation and Testing/chocAnSystem/TestFiles/testProviderDirectory.json";

    // Test data for saving service records
    String serviceDate = "01/01/2020";
    int providerNumber = 123456789;
    int memberNumber = 987654321;
    String comments = "Test comments";
    String testServiceRecordFilePath = "Project 4 - Implementation and Testing/chocAnSystem/TestFiles/testServiceRecords.json";
    String testUserIDNumberFilePath = "Project 4 - Implementation and Testing/chocAnSystem/TestFiles/testIDNumbers.json";

    // Test to make sure the saveServiceType method works
    @Test
    public void testSaveServiceType() {
        ProviderController testController = new ProviderController();
        testController.saveServiceType(serviceCode, serviceName, serviceFee, testSaveServiceFilePath);
    }

    // Test to make sure the saveServiceRecord method works
    @Test
    public void testSaveServiceRecord() {
        ProviderController testController = new ProviderController();
        testController.saveServiceRecord(serviceDate, providerNumber, memberNumber, serviceCode, comments, testServiceRecordFilePath);
    }

    // Test to make sure the saveIDNumber method works
    @Test
    public void testSaveIDNumber() {
        ProviderController testController = new ProviderController();
        testController.saveIDNumber(providerNumber, testUserIDNumberFilePath);
    }

    // Test to make sure the checkIDNumber method works
    @Test
    public void testCheckIDNumber() {
        ProviderController testController = new ProviderController();
        testController.saveIDNumber(providerNumber, testUserIDNumberFilePath);
        assertTrue(testController.checkIDNumber(providerNumber, testUserIDNumberFilePath));
    }
}