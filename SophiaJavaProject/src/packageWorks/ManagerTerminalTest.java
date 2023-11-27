package packageWorks;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class ManagerTerminalTest {

    private ManagerTerminal managerTerminal;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        managerTerminal = new ManagerTerminal();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testValidManagerLoginAndReportGeneration() {
        String input = "123456789\n3\n";
        simulateUserInput(input);

        managerTerminal.startManagerTerminal();

        String expectedOutput = "Welcome manager! Which report would you like to request?\n" +
                "Enter 1 for Member Report, 2 for Provider Report, and 3 for Manager Report.\n";
        assertEquals(expectedOutput, outputStream.toString());
    }


    private void simulateUserInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
