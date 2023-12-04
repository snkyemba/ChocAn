package chocAnSystem;

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
	public final void testGenerateMemberReportSuccess() {
		reportController.generateMemberReport();


	}
}
