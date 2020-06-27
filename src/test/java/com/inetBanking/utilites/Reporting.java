package com.inetBanking.utilites;



//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.markuputils.ExtentColor;
//import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
////import com.aventstack.extentreports.reporter.configuration.ChartLocation;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//public class Reporting extends TestListenerAdapter
//{
//	public ExtentHtmlReporter htmlReporter;
//	public ExtentReports extent;
//	public ExtentTest logger;
//	
//
//	public void onStart(ITestContext testContext)
//	{
//		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
//		String repName="Test-Report-"+timeStamp+".html";
//		
//		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report
//		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
//		
//		extent=new ExtentReports();
//		
//		extent.attachReporter(htmlReporter);
//		extent.setSystemInfo("Host name","localhost");
//		extent.setSystemInfo("Environemnt","QA");
//		extent.setSystemInfo("user","1303");
//		
//		htmlReporter.config().setDocumentTitle("InetBanking Test Project"); // Tile of report
//		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
//		 //location of the chart
//		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
//		htmlReporter.config().setTheme(Theme.DARK);
//		  htmlReporter.config().setDocumentTitle(repName);
//	        htmlReporter.config().setEncoding("utf-8");
//	        htmlReporter.config().setReportName(repName);
//	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
//	}
//	
//	
//	public void onTestSuccess(ITestResult tr)
//	{
//		logger=extent.createTest(tr.getName()); // create new entry in th report
//		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
//	}
//	
//	public void onTestFailure(ITestResult tr)
//	{
//		logger=extent.createTest(tr.getName()); // create new entry in th report
//		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
//		
//		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
//		
//		File f = new File(screenshotPath); 
//		
//		if(f.exists())
//		{
//		try {
//			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
//			} 
//		catch (IOException e) 
//				{
//				e.printStackTrace();
//				}
//		}
//		
//	}
//	public void onTestSkipped(ITestResult tr)
//	{
//		logger=extent.createTest(tr.getName()); // create new entry in th report
//		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
//	}
//	
//	public void onFinish(ITestContext testContext)
//	{
//		extent.flush();
//	}
//}
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//public class Reporting {
//    private static ExtentReports extent;
//    private static String reportFileName = "Test-Automaton-Report"+".html";
//    private static String fileSeperator = System.getProperty("file.separator");
//    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
//    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
//  
// 
//    public static ExtentReports getInstance() {
//        if (extent == null)
//            createInstance();
//        return extent;
//    }
// 
//    //Create an extent report instance
//    public static ExtentReports createInstance() {
//        String fileName = getReportPath(reportFilepath);
//       
//        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
//        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
//        htmlReporter.config().setChartVisibilityOnOpen(true);
//        htmlReporter.config().setTheme(Theme.STANDARD);
//        htmlReporter.config().setDocumentTitle(reportFileName);
//        htmlReporter.config().setEncoding("utf-8");
//        htmlReporter.config().setReportName(reportFileName);
//        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
// 
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//        //Set environment details
//		extent.setSystemInfo("OS", "Windows");
//		extent.setSystemInfo("AUT", "QA");
// 
//        return extent;
//    }
//     
//    //Create the report path
//    private static String getReportPath (String path) {
//    	File testDirectory = new File(path);
//        if (!testDirectory.exists()) {
//        	if (testDirectory.mkdir()) {
//                System.out.println("Directory: " + path + " is created!" );
//                return reportFileLocation;
//            } else {
//                System.out.println("Failed to create directory: " + path);
//                return System.getProperty("user.dir");
//            }
//        } else {
//            System.out.println("Directory already exists: " + path);
//        }
//		return reportFileLocation;
//    }
// 
//}

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporting {

public static ExtentHtmlReporter htmlReporter;
public static ExtentReports extent;
public static ExtentTest extentTest;

@BeforeSuite
public void setUp() {

    htmlReporter = new ExtentHtmlReporter("E://Jdk jre-Selenium and Maven real time Projects//Eclipse//inetBankingV1//src//test//java//com//inetBanking//utilites//Reporting//ExtentReporting.html");
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);

}

@AfterMethod
public void getResult(ITestResult result) {

    if (result.getStatus()==ITestResult.FAILURE) {

        extentTest.fail(MarkupHelper.createLabel(result.getName()+" Test Case Failed", ExtentColor.RED));
        extentTest.fail(result.getThrowable());
    }

    else if (result.getStatus()==ITestResult.SUCCESS) {

        extentTest.pass(MarkupHelper.createLabel(result.getName()+" Test Case Passed", ExtentColor.GREEN));
        extentTest.pass(result.getThrowable());

    }

    else {

        extentTest.skip(MarkupHelper.createLabel(result.getName()+" Test Case Skipped", ExtentColor.ORANGE));
        extentTest.skip(result.getThrowable());

    }


}

@AfterSuite
public void tearDown() {

    extent.flush(); 

}

}