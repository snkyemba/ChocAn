package chocAnSystem;

import junit.framework.TestCase;
//This is Evan's test for RosterRecord
//Roster Record was created by Emily Steinbach

//all of the included test cases test for success.

public class RosterRecordJUnitTest extends TestCase {
    public void testGetName() {
        RosterRecord rosterRecord = new RosterRecord("Evan Childers", 1234567890, "123 Awesome Street", "Lit City", "Alabama", 12345);
        assertEquals("Evan Childers", rosterRecord.getName());
    }

    public void testGetNumber() {
        RosterRecord rosterRecord = new RosterRecord("Evan Childers", 1234567890, "123 Awesome Street", "Lit City", "Alabama", 12345);
        assertEquals(1234567890, rosterRecord.getNumber());
    }

    public void testGetAddress() {
        RosterRecord rosterRecord = new RosterRecord("Evan Childers", 1234567890, "123 Awesome Street", "Lit City", "Alabama", 12345);
        assertEquals("123 Awesome Street", rosterRecord.getAddress());
    }

    public void testGetCity() {
        RosterRecord rosterRecord = new RosterRecord("Evan Childers", 1234567890, "123 Awesome Street", "Lit City", "Alabama", 12345);
        assertEquals("Lit City", rosterRecord.getCity());
    }

    public void testGetState() {
        RosterRecord rosterRecord = new RosterRecord("Evan Childers", 1234567890, "123 Awesome Street", "Lit City", "Alabama", 12345);
        assertEquals("Alabama", rosterRecord.getState());
    }

    public void testGetZip() {
        RosterRecord rosterRecord = new RosterRecord("Evan Childers", 1234567890, "123 Awesome Street", "Lit City", "Alabama", 12345);
        assertEquals(12345, rosterRecord.getZip());
    }

    public void testSetName() {
        RosterRecord rosterRecord = new RosterRecord("Evan Childers", 1234567890, "123 Awesome Street", "Lit City", "Alabama", 12345);
        rosterRecord.setName("Evan Childers");
        assertEquals("Evan Childers", rosterRecord.getName());
    }

    public void testSetNumber() {
        RosterRecord rosterRecord = new RosterRecord("Evan Childers", 1234567890, "123 Awesome Street", "Lit City", "Alabama", 12345);
        rosterRecord.setNumber(1134567890);
        assertEquals(1134567890, rosterRecord.getNumber());
    }

    public void testSetAddress() {
        RosterRecord rosterRecord = new RosterRecord("Evan Childers", 1234567890, "123 AwesomeStreet", "Lit City", "Alabama", 12345);
    }
}