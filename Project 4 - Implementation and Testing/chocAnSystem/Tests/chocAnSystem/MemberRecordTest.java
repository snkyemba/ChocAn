package chocAnSystem;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This is a JUnit test that tests the methods in MemberRecord.
 *
 * @author Emily Steinbach
 * @version 1.0
 */
public class MemberRecordTest {
    @Test
    public void testGetBalance() {
        MemberRecord memberRecord = new MemberRecord("Emily Steinbach", 1234567890, "123 EZ Street", "Chicago", "Florida", 12345, 100.0);
        assertEquals(100.0, memberRecord.getBalance(), .01);
    }
    @Test
    public void testManageBalance() {
        MemberRecord memberRecord = new MemberRecord("Emily Steinbach", 1234567890, "123 EZ Street", "Chicago", "Florida", 12345, 100.0);
        memberRecord.manageBalance(50.0);
        assertEquals(150.0, memberRecord.getBalance(), .01);
    }
    @Test
    public void testDefaultConstructor() {
        MemberRecord memberRecord = new MemberRecord();
        assertEquals("", memberRecord.getName());
        assertEquals(1234567891, memberRecord.getNumber());
        assertEquals("", memberRecord.getAddress());
        assertEquals("", memberRecord.getCity());
        assertEquals("", memberRecord.getState());
        assertEquals(12345, memberRecord.getZip());
        assertEquals(0.0, memberRecord.getBalance(), .01);
    }
    @Test
    public void testConstructorWithValues() {
        MemberRecord memberRecord = new MemberRecord("Emily Steinbach", 1234567890, "123 EZ Street", "Chicago", "Florida", 12345, 100.0);
        assertEquals("Emily Steinbach", memberRecord.getName());
        assertEquals(1234567890, memberRecord.getNumber());
        assertEquals("123 EZ Street", memberRecord.getAddress());
        assertEquals("Chicago", memberRecord.getCity());
        assertEquals("Florida", memberRecord.getState());
        assertEquals(12345, memberRecord.getZip());
        assertEquals(100.0, memberRecord.getBalance(), .01);
    }
    @Test
    public void testSetBalance() {
        MemberRecord memberRecord = new MemberRecord("Emily Steinbach", 1234567890, "123 EZ Street", "Chicago", "Florida", 12345, 100.0);
        memberRecord.manageBalance(50.0);
        assertEquals(150.0, memberRecord.getBalance(), .01);
    }
}

