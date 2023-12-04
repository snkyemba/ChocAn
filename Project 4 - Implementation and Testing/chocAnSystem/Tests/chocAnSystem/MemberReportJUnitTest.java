package chocAnSystem;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This is a JUnit test that tests the MemberReport class.
 *
 * @author Emily Steinbach
 * @version 1.0
 */
public class MemberReportJUnitTest {

    @Test
    public void testGetName() {
        MemberReport memberReport = new MemberReport("Emily Steinbach", 123456, "456 Nice Street", "Happy City", "Florida", 54321);
        assertEquals("Emily Steinbach", memberReport.getName());
    }

    @Test
    public void testGetMemNumber() {
        MemberReport memberReport = new MemberReport("Emily Steinbach", 123456, "123 EZ Street", "Chicago", "Florida", 54321);
        assertEquals(123456, memberReport.getMemNumber());
    }

    @Test
    public void testGetAddress() {
        MemberReport memberReport = new MemberReport("Emily Steinbach", 123456, "123 EZ Street", "Chicago", "Florida", 54321);
        assertEquals("123 EZ Street", memberReport.getAddress());
    }

    @Test
    public void testGetCity() {
        MemberReport memberReport = new MemberReport("Emily Steinbach", 123456, "123 EZ Street", "Chicago", "Florida", 54321);
        assertEquals("Chicago", memberReport.getCity());
    }

    @Test
    public void testGetState() {
        MemberReport memberReport = new MemberReport("Emily Steinbach", 123456, "123 EZ Street", "Chicago", "Florida", 54321);
        assertEquals("Florida", memberReport.getState());
    }

    @Test
    public void testGetZip() {
        MemberReport memberReport = new MemberReport("Emily Steinbach", 123456, "123 EZ Street", "Chicago", "Florida", 54321);
        assertEquals(54321, memberReport.getZip());
    }

    @Test
    public void testSetters() {
        MemberReport memberReport = new MemberReport("Emily Steinbach", 123456, "123 EZ Street", "Chicago", "Florida", 54321);

        memberReport.setName("Jennifer");
        memberReport.setMemNumber(654321);
        memberReport.setAddress("123 Circle");
        memberReport.setCity("New York City");
        memberReport.setState("New York");
        memberReport.setZip(98765);

        assertEquals("Jennifer", memberReport.getName());
        assertEquals(654321, memberReport.getMemNumber());
        assertEquals("123 Circle", memberReport.getAddress());
        assertEquals("New York City", memberReport.getCity());
        assertEquals("New York", memberReport.getState());
        assertEquals(98765, memberReport.getZip());
    }
}