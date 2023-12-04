package chocAnSystem;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This is a JUnit test that tests the methods in ProviderRecord.
 *
 * @author Emily Steinbach
 * @version 1.0
 */
public class ProviderRecordTest {

    @Test
    public void testGetFee() {
        ProviderRecord providerRecord = new ProviderRecord("Emily Steinbach", 1234567890, "123 EZ Street", "Chicago", "Florida", 12345, 50.0);
        assertEquals(50.0, providerRecord.getFee(), .01);
    }

    @Test
    public void testManageFee() {
        ProviderRecord providerRecord = new ProviderRecord("Emily Steinbach", 1234567890, "123 EZ Street", "Chicago", "Florida", 12345, 50.0);
        providerRecord.manageFee(30.0);
        assertEquals(80.0, providerRecord.getFee(), .01);
        providerRecord.manageFee(-30.0);
        assertEquals(50.0, providerRecord.getFee(), .01);
    }

    @Test
    public void testDefaultConstructor() {
        ProviderRecord providerRecord = new ProviderRecord();
        assertEquals("", providerRecord.getName());
        assertEquals(1234567891, providerRecord.getNumber());
        assertEquals("", providerRecord.getAddress());
        assertEquals("", providerRecord.getCity());
        assertEquals("", providerRecord.getState());
        assertEquals(12345, providerRecord.getZip());
        assertEquals(0.0, providerRecord.getFee(), .01);
    }

    @Test
    public void testConstructorWithValues() {
        ProviderRecord providerRecord = new ProviderRecord("Emily Steinbach", 1234567890, "123 EZ Street", "Chicago", "Florida", 12345, 50.0);
        assertEquals("Emily Steinbach", providerRecord.getName());
        assertEquals(1234567890, providerRecord.getNumber());
        assertEquals("123 EZ Street", providerRecord.getAddress());
        assertEquals("Chicago", providerRecord.getCity());
        assertEquals("Florida", providerRecord.getState());
        assertEquals(12345, providerRecord.getZip());
        assertEquals(50.0, providerRecord.getFee(), .01);
    }

    @Test
    public void testSetFee() {
        ProviderRecord providerRecord = new ProviderRecord("Emily Steinbach", 1234567890, "123 EZ Street", "Chicago", "Florida", 12345, 50.0);
        providerRecord.manageFee(30.0);
        assertEquals(80.0, providerRecord.getFee(), .01);
    }
}