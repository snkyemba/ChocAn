package chocAnSystem;

import junit.framework.TestCase;
//This is Evan's test for ManagerReport
//Member Report was created by EvanChilders
public class MemberReportTest extends TestCase {
    MemberReport memberReport = new MemberReport("Evan Childers", 1, "123 Awesome Street", "Lit City", "Alabama", 12345);
    public void testGetName() {
        assertEquals("Evan Childers", memberReport.getName());
    }
    public void testGetMemNumber() {
        assertEquals(1, memberReport.getMemNumber());
    }
    public void testGetAddress() {
        assertEquals("123 Awesome Street", memberReport.getAddress());
    }
    public void testGetCity() {
        assertEquals("Lit City", memberReport.getCity());
    }
    public void testGetState() {
        assertEquals("Alabama", memberReport.getState());
    }
    public void testGetZip() {
        assertEquals(12345, memberReport.getZip());
    }
    public void testSetName() {
        memberReport.setName("Evan Childers");
        assertEquals("Evan Childers", memberReport.getName());
    }
    public void testSetMemNumber() {
        memberReport.setMemNumber(1);
        assertEquals(1, memberReport.getMemNumber());
    }
    public void testSetAddress() {
        memberReport.setAddress("123 Awesome Street");
        assertEquals("123 Awesome Street", memberReport.getAddress());
    }
    public void testSetCity() {
        memberReport.setCity("service1");
        assertEquals("service1", memberReport.getCity());
    }
    public void testSetState() {
        memberReport.setState("11/27/2023");
        assertEquals("11/27/2023", memberReport.getState());
    }
    public void testSetZip() {
        memberReport.setZip(12345);
        assertEquals(12345, memberReport.getZip());
    }
    public void testAddService() {
        MemberReportService service1 = new MemberReportService("11/27/2023", "Aijun Song", "ECE 380");
        memberReport.addService(service1);
        assertEquals(service1, memberReport.getServiceList().elementAt(0));
    }
    public void testToFile() {
        //figure out formatting for vector data into file or database

    }
}