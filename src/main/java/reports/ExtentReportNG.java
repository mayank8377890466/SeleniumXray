package reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.mongodb.MongoClientURI;
import reusableComponents.PropertiesOperations;

public class ExtentReportNG {
	
	static ExtentReports extent;

	public static ExtentReports setupExtentReport(){
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		
		String reportPath = System.getProperty("user.dir")+
				"/Reports/ExecutionReport_"+actualDate+".html";

		String reportPath2 = System.getProperty("user.dir")+
				"/Reports/ExecutionReport.html";

		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath)
				.viewConfigurer()
				.viewOrder()
				.as(new ViewName[]{
						ViewName.DASHBOARD,
						ViewName.TEST,
						ViewName.CATEGORY,
						ViewName.AUTHOR,
						ViewName.DEVICE,
						ViewName.EXCEPTION,
						ViewName.LOG
				})
				.apply();

		ExtentSparkReporter sparkReport2 = new ExtentSparkReporter(reportPath2)
				.viewConfigurer()
				.viewOrder()
				.as(new ViewName[]{
						ViewName.DASHBOARD,
						ViewName.TEST,
						ViewName.CATEGORY,
						ViewName.AUTHOR,
						ViewName.DEVICE,
						ViewName.EXCEPTION,
						ViewName.LOG
				})
				.apply();

		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		extent.attachReporter(sparkReport2);

		sparkReport.config().setDocumentTitle("");
		sparkReport.config().setTheme(Theme.STANDARD);
		sparkReport.config().setReportName("");
		sparkReport.config().setTimelineEnabled(true);
		sparkReport.config().setEncoding("utf-8");
		sparkReport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		sparkReport.config().thumbnailForBase64(true);

		sparkReport2.config().setDocumentTitle("");
		sparkReport2.config().setTheme(Theme.STANDARD);
		sparkReport2.config().setReportName("");
		sparkReport2.config().setTimelineEnabled(true);
		sparkReport2.config().setEncoding("utf-8");
		sparkReport2.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		sparkReport2.config().thumbnailForBase64(true);

		extent.setSystemInfo("Executed on Environment: ", PropertiesOperations.getPropertyValueByKey("url"));
		extent.setSystemInfo("Executed on Browser: ", PropertiesOperations.getPropertyValueByKey("browser"));
		extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("ENV", "QA");

		/*ExtentKlovReporter klov = new ExtentKlovReporter("test_klov_server", "test_klov");
		klov.initMongoDbConnection(new MongoClientURI("mongodb://user:password@localhost:57017"));
		klov.initKlovServerConnection("http://localhost:6780");
		extent.attachReporter(sparkReport,klov);*/


		return extent;
	}


}
