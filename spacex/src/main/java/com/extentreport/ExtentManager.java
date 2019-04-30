package com.extentreport;
 
import com.relevantcodes.extentreports.ExtentReports;
import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.
 
public class ExtentManager {
 
    private static ExtentReports extent;
 
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            DateFormat dateFormat = new SimpleDateFormat("dd_mm_yy_hh-mm-ss");
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir+"\\ExtentReports\\ExtentReportResults_"+dateFormat.format(System.currentTimeMillis())+".html", false);
        }
        return extent;
    }
}