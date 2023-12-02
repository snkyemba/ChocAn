package chocAnSystem;
//
//import static org.junit.Assert.*;
//import org.junit.Test;
//
//public class ServiceRecordTestFail {
//    // Test data with bad values
//    int providerNumShort = 12345678;
//    int providerNumLong = 1234567890;
//    int providerNum = 123456789;
//    int memberNumShort = 87654321;
//    int memberNumLong = 9876543210;
//    int memberNum = 987654321;
//    int serviceCodeShort = 12345;
//    int serviceCodeLong = 1234567;
//    int serviceCode = 123456;
//    String comments = "This is a test comment";
//    String logDate = "2023-11-27";
//    String serviceDate = "2023-11-28";
//
//    @Test
//    public void testBadProviderNumShort() {
//        ServiceRecord serviceRecord = new ServiceRecord(providerNumShort, memberNum, serviceCode, comments, logDate, serviceDate);
//        assertFalse("Provider number is too short", serviceRecord.isValid());
//    }
//
//    @Test
//    public void testBadProviderNumLong() {
//        ServiceRecord serviceRecord = new ServiceRecord(providerNumLong, memberNum, serviceCode, comments, logDate, serviceDate);
//        assertFalse("Provider number is too long", serviceRecord.isValid());
//    }
//
//    @Test
//    public void testBadMemberNumShort() {
//        ServiceRecord serviceRecord = new ServiceRecord(providerNum, memberNumShort, serviceCode, comments, logDate, serviceDate);
//        assertFalse("Member number is too short", serviceRecord.isValid());
//    }
//
//    @Test
//    public void testBadMemberNumLong() {
//        ServiceRecord serviceRecord = new ServiceRecord(providerNum, memberNumLong, serviceCode, comments, logDate, serviceDate);
//        assertFalse("Member number is too long", serviceRecord.isValid());
//    }
//
//    @Test
//    public void testBadServiceCodeShort() {
//        ServiceRecord serviceRecord = new ServiceRecord(providerNum, memberNum, serviceCodeShort, comments, logDate, serviceDate);
//        assertFalse("Service code is too short", serviceRecord.isValid());
//    }
//
//    @Test
//    public void testBadServiceCodeLong() {
//        ServiceRecord serviceRecord = new ServiceRecord(providerNum, memberNum, serviceCodeLong, comments, logDate, serviceDate);
//        assertFalse("Service code is too long", serviceRecord.isValid());
//    }
//}