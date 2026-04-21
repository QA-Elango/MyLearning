package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {
    
ExtentReports extents;

    public  static ExtentReports getReport(){
        String path = System.getProperty("user.dir")+"//report//index.html";

         ExtentSparkReporter reporter = new ExtentSparkReporter(path);
         reporter.config().setReportName("Automation result");
         reporter.config().setDocumentTitle("Test Results");

       ExtentReports extents = new ExtentReports();
        extents.attachReporter(reporter);
        extents.setSystemInfo("Elango", " Learning");

        return extents;
    }
}
