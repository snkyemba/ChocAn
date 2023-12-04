package chocAnSystem;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ServiceRecordConstructorTestSuccess {

    // Test data and expected values
    SimpleDateFormat currentFormatter = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
    SimpleDateFormat serviceFormatter = new SimpleDateFormat("MM-dd-yyyy");
    String currentDate = currentFormatter.format(new Date());
    String serviceDate = serviceFormatter.format(new Date());
    int providerNumber = 123456789;
    int memberNumber = 123456789;
    int serviceCode = 123456;
    String comments = "Test comments";
    String jsonString = "{\"currentDate\":\"" + currentDate + "\",\"serviceDate\":\"" + serviceDate + "\",\"providerNumber\":" + providerNumber + ",\"memberNumber\":" + memberNumber + ",\"serviceCode\":" + serviceCode + ",\"comments\":\"" + comments + "\"}";

    // Test objects
    ServiceRecord testEntry1;
    ServiceRecord testEntry2;

    // Test using main constructor
    @Test
    public void testMainConstructor () {
        testEntry1 = new ServiceRecord(currentDate, serviceDate, providerNumber, memberNumber, serviceCode, comments);
        assertEquals(testEntry1.getCurrentDate(), currentDate);
        assertEquals(testEntry1.getServiceDate(), serviceDate);
        assertEquals(testEntry1.getProviderNumber(), providerNumber);
        assertEquals(testEntry1.getMemberNumber(), memberNumber);
        assertEquals(testEntry1.getServiceCode(), serviceCode);
    }

    // Test using JSON constructor
    @Test
    public void testJsonConstructor () {
        testEntry2 = new ServiceRecord(jsonString);
        assertEquals(testEntry2.getCurrentDate(), currentDate);
        assertEquals(testEntry2.getServiceDate(), serviceDate);
        assertEquals(testEntry2.getProviderNumber(), providerNumber);
        assertEquals(testEntry2.getMemberNumber(), memberNumber);
        assertEquals(testEntry2.getServiceCode(), serviceCode);
    }
}