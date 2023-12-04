package chocAnSystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chocAnSystem.ReportController;

/** This test was written by Sophia Kyemba */
public class ReportControllerTest {
	ReportController reportController;
	@Before
	public void setUp() throws Exception {
		reportController = new ReportController();
	}

	@Test
	public final void testGenerateMemberReport() {
		reportController.generateMemberReport();


	}

}
