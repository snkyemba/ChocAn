package chocAnSystem;

import org.junit.Before;
import org.junit.Test;
import java.io.File;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
public class SKyembaJUnitTest {
	//unit test for method I created
	@Test
	public final void testGenerateMemberReport() {
		ReportController reportController = new ReportController();
		reportController.generateMemberReport();
		assertTrue(new File("memberReport.txt").exists());
	}
	//unit test for another method I created
	@Test
	public final void testGenerateProviderReport() {
		ReportController reportController = new ReportController();
		reportController.generateProviderReport();
		assertTrue(new File("providerReport.txt").exists());
	}

	//unit test for method I did not create
	@Test(expected = AssertionError.class)
	public void testStartOperatorTerminalOutput(){
		OperatorTerminal operatorTerminal = new OperatorTerminal();
		String input = "123456789";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		operatorTerminal.startOperatorTerminal();
		String expectedOutput = "Hello, this is the wrong Operator Output.";
		assertTrue(outContent.toString().contains(expectedOutput));
	}
}
