package chocAnSystem;
//This is Evan's test for ManagerReport
//Manager Report was created by Evan Childers
import static org.junit.Assert.*;

//all of the included test cases test for failure.
public class ManagerReportJUnitTest {
    ManagerReportProvider provider1 = new ManagerReportProvider("provider1", 1, 1);
    ManagerReportProvider wrongProvider = new ManagerReportProvider("provider2", 2, 2);
    @org.junit.Test
    public void addProvider() {
        ManagerReport managerReport = new ManagerReport();
        managerReport.addProvider(provider1);
        assertFalse(managerReport.providerList.get(0) == wrongProvider);
    }

    @org.junit.Test
    public void calculateTotals() {
        ManagerReport managerReport = new ManagerReport();
        managerReport.addProvider(provider1);
        managerReport.calculateTotals();
        assertFalse(managerReport.totalNumConsults != 1);
        assertFalse(managerReport.totalFee != 1);
    }
}