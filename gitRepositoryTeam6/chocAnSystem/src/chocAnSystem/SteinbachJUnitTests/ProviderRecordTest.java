package chocAnSystem.SteinbachJUnitTests;

import chocAnSystem.ProviderRecord;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProviderRecordTest extends ProviderRecord {

    // Default constructor
    public ProviderRecordTest() {
        super("Jennifer", 1234567890, "16 Main St", "Moscow", "Russia", 54321, 0.0);
    }

    @Test
    public void testManageFee() {
        // Create a ProviderRecordTest object
        ProviderRecordTest providerRecordTest = new ProviderRecordTest();

        // Add a positive amount to the fee
        providerRecordTest.manageFee(30.0);
        assertEquals(30.0, providerRecordTest.getFee(), 0.001); // Assuming double comparison, use a delta for precision

        // Add the negative of the previous amount to the fee
        providerRecordTest.manageFee(-30.0);
        assertEquals(0.0, providerRecordTest.getFee(), 0.001); // Fee should be zero after subtracting the same amount
    }
}