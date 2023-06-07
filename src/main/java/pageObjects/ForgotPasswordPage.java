package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.ExtentFactory;
import reusableComponents.Log;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import static com.aventstack.extentreports.Status.INFO;

public class ForgotPasswordPage {

    private WebDriver driver;
    private Random rand = SecureRandom.getInstanceStrong();

    public ForgotPasswordPage(WebDriver driver) throws NoSuchAlgorithmException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[contains(text(),'Forgot Your Password?')]")
    private WebElement forgotPasswordLink;
    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement emailId;

    @FindBy(xpath = "//li[@class='success-msg']")
    private WebElement successMessage;
    @FindBy(xpath = "//button[@title='Submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='validation-advice']")
    private WebElement blankEmailErrMsg;


    public void clickForgotPasswordLink() throws InterruptedException {

        Thread.sleep(5000);
        forgotPasswordLink.click();
        ExtentFactory.getInstance().getExtent().log(INFO, "Click on forgot password link");
        Log.info("Click on forgot password link");
    }

    public void enterEmail() {
        int rValue = this.rand.nextInt(1000);
        String email="dummyEmail" + rValue + "@gmail.com";
        emailId.sendKeys(email);
        ExtentFactory.getInstance().getExtent().log(INFO,"Enter emailId :"+email);
        Log.info("Enter emailId :"+email);
    }

    public void clickSubmit() {
        submitButton.click();
        ExtentFactory.getInstance().getExtent().log(INFO, "click on submit button");
        Log.info("click on submit button");
    }

    public void verifySuccessMessage(String emailTeXt) {
        successMessage.isDisplayed();
        ExtentFactory.getInstance().getExtent().log(INFO, "forgot password email sent to :" + emailTeXt);
        Log.info("forgot password email sent to :"+emailTeXt);
    }


    public void verifyBlankEmailMessage() {
        blankEmailErrMsg.isDisplayed();
        ExtentFactory.getInstance().getExtent().log(INFO, "Email id can not be blank");
        Log.info("Email id can not be blank");
    }
}
