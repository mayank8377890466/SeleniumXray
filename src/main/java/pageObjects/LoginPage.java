package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.ExtentFactory;
import reusableComponents.Log;

import static com.aventstack.extentreports.Status.INFO;


public class LoginPage {

    private WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "ACCOUNT")
    private WebElement accountLink;

    @FindBy(linkText = "ACCOUNT")
    private WebElement emailText;
    @FindBy(linkText = "Log In")
    private WebElement loginLink;
    @FindBy(xpath = "//input[@title='Email Address']")
    private WebElement email;
    @FindBy(xpath = "//button[@id='send2']")
    private WebElement loginButton;
    @FindBy(xpath = "//p[contains(text(),'Welcome')]")
    private WebElement welcomeText;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(xpath = "//a[contains(text(),'Forgot Your Password?')]")
    private WebElement forgotPasswordLink;

    public   void clickAccount() throws InterruptedException {
        Thread.sleep(5000);
        accountLink.click();
        ExtentFactory.getInstance().getExtent().log(INFO,"Click on account link");
        Log.info("clicked on account link");
    }

    public  void clickLoginLink() throws InterruptedException {
        Thread.sleep(5000);
        loginLink.click();
        ExtentFactory.getInstance().getExtent().log(INFO,"Click on login link");
        Log.info("Click on login link");
    }

    public void clickForgotPasswordLink() throws InterruptedException {
        Thread.sleep(5000);
        forgotPasswordLink.click();
        ExtentFactory.getInstance().getExtent().log(INFO,"Click on forgot password link");
        Log.info("Click on forgot password link");
    }

    public void enterEmail(String emailTeXt) {
        email.sendKeys(emailTeXt);
        ExtentFactory.getInstance().getExtent().log(INFO,"Enter email is :"+emailTeXt);
        Log.info("Enter email is :"+emailTeXt);
    }

    public void clickLoginButton() {
        loginButton.click();
        ExtentFactory.getInstance().getExtent().log(INFO,"Click on login button");
        Log.info("Click on login button");
    }

    public void verifyLogin() {
        welcomeText.isDisplayed();
        Log.info("login done...");
    }

    public void clickRegister() throws InterruptedException {
        Thread.sleep(5000);
        registerLink.click();
        ExtentFactory.getInstance().getExtent().log(INFO,"Click on register link");
        Log.info("clicked on register link");
    }
}
