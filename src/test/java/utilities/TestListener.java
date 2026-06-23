package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class TestListener implements ITestListener {
	private static ExtentReports extent =
	        ExtentManager.getExtentReport();

	private static ThreadLocal<ExtentTest>
	        test =
	        new ThreadLocal<>();

	public void onTestStart(ITestResult result)
	{
		System.out.println("Test started");
		 String testName =
		            result.getMethod()
		                  .getDescription();

		    if (testName == null ||
		        testName.isEmpty()) {

		        testName =
		                result.getMethod()
		                      .getMethodName();
		    }

		    test.set(
		            extent.createTest(
		                    testName));

		    System.out.println(
		            result.getName()
		            + " Started");
	}
	
	
	@Override
	public void onTestSuccess(
	        ITestResult result) {

	    test.get()
	        .pass(
	                "Test Passed");

	    System.out.println(
	            result.getName()
	            + " Passed");
	}
	
	@Override
	public void onTestFailure(
	        ITestResult result) {

	    test.get()
	        .fail(
	                result.getThrowable());

	    System.out.println(
	            result.getName()
	            + " Failed");
	}
	
	@Override
	public void onTestSkipped(
	        ITestResult result) {

	    test.get()
	        .skip(
	                "Test Skipped");

	    System.out.println(
	            result.getName()
	            + " Skipped");
	}
	
	@Override
	public void onFinish(
	        ITestContext context) {

	    extent.flush();

	    System.out.println(
	            "Extent Report Generated");
	}
}
