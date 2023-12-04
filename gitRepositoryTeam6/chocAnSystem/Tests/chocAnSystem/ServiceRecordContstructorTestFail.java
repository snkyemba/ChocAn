package chocAnSystem;


import static org.junit.Assert.*;
import org.junit.Test;


public class ServiceRecordContstructorTestFail {
    // Test data with bad values
    int providerNumShort = 12345678;
    int providerNumLong = 1234567890;
    int providerNum = 123456789;
    int memberNumShort = 87654321;
    int memberNumLong = 1234567890;
    int memberNum = 987654321;
    int serviceCodeShort = 12345;
    int serviceCodeLong = 1234567;
    int serviceCode = 123456;
    String longComments = "I told my computer I needed a break from debugging. It responded, " +
            "'Error 404: Joke Not Found. Please try again or consider laughing at the last bug you fixed.'";
    String comments = "This is a test comment";
    String logDate = "2023-11-27";
    String serviceDate = "2023-11-28 12:00:00";


    @Test(expected = IllegalArgumentException.class)
    public void testServiceRecordConstructorFailProviderNumShort() {
        ServiceRecord record = new ServiceRecord(logDate, serviceDate, providerNumShort, memberNum, serviceCode, comments);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testServiceRecordConstructorFailProviderNumLong() {
        ServiceRecord record = new ServiceRecord(logDate, serviceDate, providerNumLong, memberNum, serviceCode, comments);
    }


    // Test to make sure ServiceRecord constructor fails with bad member number
    @Test(expected = IllegalArgumentException.class)
    public void testServiceRecordConstructorFailMemberNumShort() {
        ServiceRecord record = new ServiceRecord(logDate, serviceDate, providerNum, memberNumShort, serviceCode, comments);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testServiceRecordConstructorFailMemberNumLong() {
        ServiceRecord record = new ServiceRecord(logDate, serviceDate, providerNum, memberNumLong, serviceCode, comments);
    }


    // Test to make sure ServiceRecord constructor fails with bad service code
    @Test(expected = IllegalArgumentException.class)
    public void testServiceRecordConstructorFailServiceCodeShort() {
        ServiceRecord record = new ServiceRecord(logDate, serviceDate, providerNum, memberNum, serviceCodeShort, comments);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testServiceRecordConstructorFailServiceCodeLong() {
        ServiceRecord record = new ServiceRecord(logDate, serviceDate, providerNum, memberNum, serviceCodeLong, comments);
    }


    // Test to make sure ServiceRecord constructor fails with bad comments
    @Test(expected = IllegalArgumentException.class)
    public void testServiceRecordConstructorFailComments() {
        ServiceRecord record = new ServiceRecord(logDate, serviceDate, providerNum, memberNum, serviceCode, longComments);
    }
}
