package packageWorks;

import static org.junit.Assert.*;


public class ManagerReportJUnitTest {
    ManagerReportProvider provider1 = new ManagerReportProvider("provider1", 1, 1);
    @org.junit.Test
    public void addProvider() {
        ManagerReport managerReport = new ManagerReport();
        managerReport.addProvider(provider1);
        assertEquals(managerReport.providerList.get(0), provider1);
    }

    @org.junit.Test
    public void calculateTotals() {
        ManagerReport managerReport = new ManagerReport();
        managerReport.addProvider(provider1);
        managerReport.calculateTotals();
        assertEquals(managerReport.totalNumConsults, 1);
        assertEquals(managerReport.totalFee, 1, 0.001);
    }
}