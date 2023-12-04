package chocAnSystem;
import junit.framework.TestCase;
import org.junit.Test;

public class RDunklinJUnitTests extends TestCase {

    // Test case for ServiceRecord.getProviderNumber()
    public void testServiceRecordGetProviderNumber() {
        // Create a ServiceRecord instance with a valid provider number
        ServiceRecord serviceRecord = new ServiceRecord(
                "12-04-2023 14:45:00",
                "12-04-2023",
                987654321, 123456789,
                654321, "Test Case ProviderNumber");

        // Get the provider number from the ServiceRecord instance
        int providerNumberResult = serviceRecord.getProviderNumber();

        // Assert that the provider number result is as expected
        assertEquals(987654321, providerNumberResult);
    }

    public void testServiceRecordGetMemberNumber() {
        // Create a ServiceRecord instance with a valid member number
        ServiceRecord serviceRecord = new ServiceRecord(
                "12-04-2023 14:45:00",
                "12-04-2023",
                987654321, 123456789,
                654321, "Test Case MemberNumber");

        // Get the member number from the ServiceRecord instance
        int memberNumberResult = serviceRecord.getMemberNumber();

        assertEquals(123456789, memberNumberResult);
    }
    public void testServiceRecordGetServiceCodeInvalid() {
        // Creating a ServiceRecord with an invalid service code (less than 6 digits)
        ServiceRecord serviceRecord = new ServiceRecord(
                "12-04-2023 14:45:00",
                "12-04-2023",
                987654321, 123456789,
                12345, "Test Case InvalidServiceCode");

        // Attempting to get the service code from the ServiceRecord instance
        int serviceCodeResult = serviceRecord.getServiceCode();

    }
}