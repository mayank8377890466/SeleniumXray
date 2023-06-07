package reusableComponents;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {

    //Initialize Log4j logs
    //private static Logger log = Logger.getLogger(log.class.getName());//
    //private static final Logger log =  LogManager.getLogger(log.class);

    private static Logger log = Logger.getLogger(Log.class.getName());
    // This is to print log for the beginning of the test case, as we usually run so many test ExecutionEngine as a test suite
    public static void startTestCase(String sTestCaseName){
        log.info("****************************************************************************************");
        log.info("$$$$$$$$$$$$$$$$$$$$$ Starting Test : "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
        log.info("****************************************************************************************");
    }

    //This is to print log for the ending of the test case
    public static void endTestCase(String sTestCaseName){
        log.info("****************************************************************************************");
        log.info("$$$$$$$$$$$$$$$$$$$$$ Ending Test :   "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
        log.info("****************************************************************************************");
        log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
    }

    // Need to create these methods, so that they can be called
    public static void info(String message) {
        log.info(message);
    }

    public static void warn(String message) {
        log.warn(message);
    }

    public static void error(String message) {
        log.error(message);
    }

    public static void fatal(String message) {
        log.fatal(message);
    }

    public static void debug(String message) {
        log.debug(message);
    }

}

