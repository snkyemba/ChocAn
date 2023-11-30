package chocAnSystem;
//This is Evan's test for ServiceRecord
//Service Record was created by Walter Mink
import junit.framework.TestCase;

public class ServiceRecordTest extends TestCase {
    ServiceRecord serviceRecord = new ServiceRecord("currentDate", "serviceDate", 123456789, 123456789, 123456, "comments");
    public void testGetCurrentDate() {
        assertEquals(serviceRecord.getCurrentDate(), "currentDate");
    }

    public void testGetServiceDate() {
        assertEquals(serviceRecord.getServiceDate(), "serviceDate");
    }

    public void testGetProviderNumber() {
        assertEquals(serviceRecord.getProviderNumber(), 123456789);
    }

    public void testGetMemberNumber() {
        assertEquals(serviceRecord.getMemberNumber(), 123456789);
    }

    public void testGetServiceCode() {
        assertEquals(serviceRecord.getServiceCode(), 123456);
    }

    public void testGetComments() {
        assertEquals(serviceRecord.getComments(), "comments");
    }
}