package chocAnSystem;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import packageWorks.ManagerTerminal;
//
///** This class was written by Sophia Kyemba */
//public class ManagerTerminalTest {
//	ManagerTerminal managerTerminal;
//	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//	 private final PrintStream originalOut = System.out;
//	@Before
//	public void setUp() throws Exception {
//		managerTerminal = new ManagerTerminal();
//		System.setOut(new PrintStream(outputStream));
//	}
//	@Test
//	public final void test() {
//		//assertEquals(2,2);
//		// Simulate valid manager login and report choice
//        String input = "123456789\n3\n";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//
//        managerTerminal.startManagerTerminal();
//        String consoleOutput = outputStream.toString().trim();
//        // Check if the output contains the expected message
//        assertTrue(consoleOutput.contains("Please enter your ID number:"));
//        assertTrue(consoleOutput.contains("Welcome Manager!"));
//        assertTrue(consoleOutput.contains("Please enter your choice:"));
//        assertTrue(consoleOutput.contains("1. Generate Provider Report"));
//        assertTrue(consoleOutput.contains("2. Generate Member Report"));
//        assertTrue(consoleOutput.contains("3. Exit"));
//
//        // Simulate invalid manager login
//        input = "987654321\n";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//
//        managerTerminal.startManagerTerminal();
//        consoleOutput = outputStream.toString().trim();
//        // Check if the output contains the expected message
//        assertTrue(consoleOutput.contains("Please enter your ID number:"));
//        assertTrue(consoleOutput.contains("Invalid ID number!"));
//
//        // Simulate valid manager login and invalid report choice
//        input = "123456789\n4\n";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//
//        managerTerminal.startManagerTerminal();
//        consoleOutput = outputStream.toString().trim();
//        // Check if the output contains the expected message
//        assertTrue(consoleOutput.contains("Please enter your ID number:"));
//        assertTrue(consoleOutput.contains("Welcome Manager!"));
//        assertTrue(consoleOutput.contains("Please enter your choice:"));
//        assertTrue(consoleOutput.contains("1. Generate Provider Report"));
//        assertTrue(consoleOutput.contains("2. Generate Member Report"));
//        assertTrue(consoleOutput.contains("3. Exit"));
//        assertTrue(consoleOutput.contains("Invalid choice!"));
//
//        // Simulate valid manager login and valid report choice
//        input = "123456789\n1\n";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//
//        managerTerminal.startManagerTerminal();
//        String consoleOutput = outputStream.toString().trim();
//        // Check if the output contains the expected message
//
//
//	}
//
//}
