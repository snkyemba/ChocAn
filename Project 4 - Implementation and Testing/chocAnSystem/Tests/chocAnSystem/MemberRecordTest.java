package chocAnSystem;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MemberRecordTest {
    @Test
    public void testManageFee() {
        // Create a MemberRecord object
        MemberRecord memberRecordTest = new MemberRecord("Jennifer", 1234567890, "16 Main St", "Moscow", "Russia", 54321, 0.0);

        // Add a positive amount to the balance
        memberRecordTest.manageBalance(30.0);
        assertEquals(30.0, memberRecordTest.getBalance(), 0.001);

        // Add the negative of the previous amount to the balance
        memberRecordTest.manageBalance(-30.0);
        assertEquals(0.0, memberRecordTest.getBalance(), 0.001);
    }
}
