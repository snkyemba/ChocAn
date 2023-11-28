package packageWorks.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import packageWorks.ManagerTerminal;

/** This class was written by Sophia Kyemba */
public class ManagerTerminalTest {
	ManagerTerminal managerTerminal;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	 private final PrintStream originalOut = System.out;
	@Before
	public void setUp() throws Exception {
		managerTerminal = new ManagerTerminal();
		System.setOut(new PrintStream(outputStream));
	}
	@Test
	public final void test() {
		//assertEquals(2,2);
		// Simulate valid manager login and report choice
        String input = "123456789\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        managerTerminal.startManagerTerminal();
        String consoleOutput = outputStream.toString().trim();
        // Check if the output contains the expected message
        
        
	}

}
