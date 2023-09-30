package googleFinancePack;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlTest;

import java.text.SimpleDateFormat;
import java.util.Date;
public class TestListener implements ITestListener {

        //@Override
        public void onStart(ITestContext context) {
            // Get current timestamp
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            // Set the output directory for the report with timestamp
            for (XmlTest xmlTest : context.getCurrentXmlTest().getSuite().getTests()) {
                xmlTest.addParameter("outputdir", "test-output" + timestamp);
            }
        }

     
    }