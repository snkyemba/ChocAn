package chocAnSystem;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertTrue;

public class ManagerTerminalTest {

	@Test
	public void testStartManagerTerminalOutput() {
		ManagerTerminal managerTerminal = new ManagerTerminal();
		String input = "123456789";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		managerTerminal.startManagerTerminal();
		String expectedOutput = "Welcome manager! Which report would you like to request?\n"
				+ "Enter 1 for Member Report, 2 for Provider Report, and 3 for Manager Report.\n";
		assertTrue(outContent.toString().contains(expectedOutput));
	}
}
