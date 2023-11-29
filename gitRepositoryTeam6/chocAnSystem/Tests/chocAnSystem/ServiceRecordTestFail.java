package chocAnSystem;

import static org.junit.Assert.*;
import org.junit.Test;

public class ServiceRecordTestFail {
    // Test data with bad values
    int providerNumShort = 12345678;
    int providerNumLong = 1234567890;
    int providerNum = 123456789;
    int memberNumShort = 87654321;
    int memberNumLong = 9876543210;
    int memberNum = 987654321;
    int serviceCodeShort = 12345;
    int serviceCodeLong = 1234567;
    int serviceCode = 123456;
    String comments = "This is a test comment"; // Corrected the data type and added a sample comment
    String logDate = "2023-11-27"; // Added a sample date
    String serviceDate = "2023-11-28"; // Added a sample date

    @Test
    public void testBadProviderNumber() {
        ServiceRecord serviceRecord = new ServiceRecord(providerNumShort, memberNum, serviceCode, comments, logDate, serviceDate);
        assertFalse("Provider number is too short", serviceRecord.isValid());
    }

    @Test
    public void testBadMemberNumber() {

        ServiceRecord serviceRecord = new ServiceRecord(providerNum, memberNumLong, serviceCode, comments, logDate, serviceDate);
        assertFalse("Member number is too long", serviceRecord.isValid());
    }

    @Test
    public void testBadServiceCode() {

        ServiceRecord serviceRecord = new ServiceRecord(providerNum, memberNum, serviceCodeShort, comments, logDate, serviceDate);
        assertFalse("Service code is too short", serviceRecord.isValid());
    }

}