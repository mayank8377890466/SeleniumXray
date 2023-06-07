/**
 * Author: Prakash Narkhede
 * Blog: www.AutomationTalks.com
 * LinkedIn: https://www.linkedin.com/in/panarkhede89/
 */
package testBase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

    //create webdriver object for given browser
    public WebDriver createBrowserInstance(String browser) throws MalformedURLException {

        WebDriver driver = null;
        //RemoteWebDriver driver = null;


        if (browser.equalsIgnoreCase("Chrome")) {

            WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.silentOutput", "true");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            DriverFactory.getInstance().setDriver(driver);
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            //System.setProperty("webdriver.gecko.driver", "true");
            //FirefoxOptions options = new FirefoxOptions();
            //options.addArguments("--incognito");
            DriverFactory.getInstance().setDriver(driver);
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("grid")) {
            WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.silentOutput", "true");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new RemoteWebDriver(new URL(System.getProperty("grid_hub")), DesiredCapabilities.chrome());
            //driver = new FirefoxDriver(foptions);

        }else if (browser.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            InternetExplorerOptions iOptions = new InternetExplorerOptions();
            iOptions.addCommandSwitches("-private");

            driver = new InternetExplorerDriver(iOptions);
        }
        else if (browser.equalsIgnoreCase("chromelinux"))
        {
            WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.silentOutput", "true");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("disable-infobars"); // disabling infobars
            options.addArguments("--disable-extensions"); // disabling extensions
            options.addArguments("--disable-gpu"); // applicable to windows os only
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--no-sandbox"); // Bypass OS security model
            DriverFactory.getInstance().setDriver(driver);
            driver = new ChromeDriver(options);

        }
        return driver;
    }
}
