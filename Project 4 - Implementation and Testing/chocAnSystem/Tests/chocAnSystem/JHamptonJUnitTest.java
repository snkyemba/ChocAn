package chocAnSystem;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class JHamptonJUnitTest {
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
    @Test
    public void testStartOperatorTerminalOutput(){
        OperatorTerminal operatorTerminal = new OperatorTerminal();
        String input = "123456789";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        operatorTerminal.startOperatorTerminal();
        String expectedOutput = "Hello, please input your 9 digit Operator ID";
        assertTrue(outContent.toString().contains(expectedOutput));
    }
    @Test
    public void testAddProvider() throws IOException {
        ProviderControllerOp providerController = new ProviderControllerOp();
        providerController.addProvider("John", 1234567891, "123 Main St", "Moscow", "Russia", 54321, 32.25,"Project 4 - Implementation and Testing/chocAnSystem/TestFiles/testProviderFile.json");
        assertTrue(providerController.getProviderName("John", "Project 4 - Implementation and Testing/chocAnSystem/TestFiles/testProviderFile.json"));
    }
}


