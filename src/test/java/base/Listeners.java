package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentReporterNg;
import utils.screenshot;

public class Listeners extends screenshot implements ITestListener {
WebDriver driver;
ExtentTest test;
ExtentReports extents = ExtentReporterNg.getReport();

    @Override
    public void onTestStart(ITestResult result){
    test = extents.createTest(result.getMethod().getMethodName());
    }

      @Override
    public void onTestSuccess(ITestResult result){
    test.log(Status.PASS, "Test Passed");
    }
      @Override
    public void onTestFailure(ITestResult result){
        test.fail(result.getThrowable());
        
        try {
            java.lang.reflect.Field driverField = null;
            Class<?> clazz = result.getTestClass().getRealClass();
            
            // Search up the class hierarchy
            while (clazz != null) {
                try {
                    driverField = clazz.getDeclaredField("driver");
                    break;
                } catch (NoSuchFieldException e) {
                    clazz = clazz.getSuperclass();
                }
            }
            
            if (driverField != null) {
                driverField.setAccessible(true);
                driver = (WebDriver) driverField.get(result.getInstance());
                String filePath = captureScreenshot(result.getMethod().getMethodName(),driver);
                test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

     @Override
    public void onFinish(ITestContext result){
        extents.flush();
    }
}
