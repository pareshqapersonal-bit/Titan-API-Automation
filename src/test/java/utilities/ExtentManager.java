package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	  private static ExtentReports extent;

	    public static ExtentReports getExtentReport() {

	        if (extent == null) {

	            ExtentSparkReporter spark =
	                    new ExtentSparkReporter(
	                            System.getProperty("user.dir")
	                            + "/Reports/APIAutomationReport.html");

	            spark.config()
	                 .setReportName(
	                         "Titan API Automation Report");

	            spark.config()
	                 .setDocumentTitle(
	                         "API Execution Report");

	            extent = new ExtentReports();
	            extent.attachReporter(spark);

	            extent.setSystemInfo(
	                    "Tester",
	                    "Paresh");

	            extent.setSystemInfo(
	                    "Framework",
	                    "Rest Assured + TestNG");
	        }

	        return extent;
	    }
	
}
