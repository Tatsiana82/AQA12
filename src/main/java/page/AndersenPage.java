package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;

public class AndersenPage {
    static final Logger logger = LoggerFactory.getLogger(AndersenPage.class);

    private WebDriver driver;
    private WebDriverWait wait;

    public AndersenPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    private static WebElement loginEmail;
    @FindBy(name = "password")
    private static WebElement loginPassword;
    @FindBy(xpath = "//span[text()='Invalid email address']")
    private static WebElement invalidEmail;
    public void openAndersenPage(){
        driver.get("https://qa-course-01.andersenlab.com/login");
    }

    public void visibilityOfEmail(){
        wait.until(ExpectedConditions.visibilityOf(loginEmail));
        logger.info("Visibility of email is present");
    }
    public void visibilityOfPassword(){
        wait.until(ExpectedConditions.visibilityOf(loginPassword));
        logger.info("Visibility of password is correct");
    }
    public void InvalidEmail(){
        String invalidAssert = invalidEmail.getText();
        logger.info("Read text");
        Assert.assertEquals(invalidAssert, "Invalid email address");
    }
    public void setPlaceholder(){
        String placeholderTextEmail = loginEmail.getAttribute("placeholder");
        Assert.assertEquals(placeholderTextEmail, "Enter email", "Placeholder incorrect");
        String placeholderTextPassword = loginPassword.getAttribute("placeholder");
        logger.info("Check placeholder");
        Assert.assertEquals(placeholderTextPassword, "Enter password", "Placeholder incorrect");
    }
        public void setEmail(String email){
        loginEmail.sendKeys(email);
    }

    public void setPassword(String password){
        loginPassword.sendKeys(password);
        logger.info("Password is correct");
    }
}