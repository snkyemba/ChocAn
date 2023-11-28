package chocAnSystem;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class ProviderControllerTests {
    int serviceCode = 123456;
    String serviceName = "Test Service";
    float serviceFee = 123.45f;
    String filePath = "chocAnSystem/TestFiles/testProviderDirectory.json";

    @Test
    public void testSaveServiceType() {
        ProviderController testController = new ProviderController();
        try {
            testController.saveServiceType(serviceCode, serviceName, serviceFee, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}