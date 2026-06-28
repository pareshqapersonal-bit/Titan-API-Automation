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
		   

		    Object[] params = result.getParameters();
		    if (params.length > 0) {
		        testName += " - " + params[0];
		    }

		    test.set(extent.createTest(testName));

		    

		    System.out.println(
		            result.getName()
		            + " Started");
	}
	
	
	@Override
	public void onTestSuccess(
	        ITestResult result) {
		
		System.out.println("===== onTestSuccess =====");
		System.out.println("Test : " + result.getName());
		System.out.println("Endpoint : " + APILogger.getEndpoint());
		System.out.println("Request : " + APILogger.getRequest());
		System.out.println("Status : " + APILogger.getStatusCode());
		System.out.println("Response Null? " + (APILogger.getResponse() == null));
		System.out.println("Response Length : " +
		    (APILogger.getResponse() == null ? 0 : APILogger.getResponse().length()));
		
		System.out.println("onTestSuccess called for : "
	            + result.getName());

		 test.get().pass("Test Passed");
		   test.get().info("<b>EndPoint:</b><pre> "+APILogger.getEndpoint()+"</pre>");

		   test.get().info(
				    "<b>Request:</b><br><pre>"
				    + APILogger.getRequest()
				    + "</pre>");
		    
		    test.get().info("<b>Status code:</b><pre> "+APILogger.getStatusCode()+"</pre>");

		    test.get().info(
		    	    "<b>Response:</b><br><pre>"
		    	    + APILogger.getResponse()
		    	    + "</pre>");

		    APILogger.clear();
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
