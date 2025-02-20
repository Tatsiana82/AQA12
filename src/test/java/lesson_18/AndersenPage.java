package lesson_18;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
public class AndersenPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AndersenPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Registration")
    private static WebElement registrationLink;
    public void visibilityOfElementsRegistrationButton(){
        wait.until(ExpectedConditions.visibilityOf(registrationLink));
    }

    @FindBy(name = "email")
    private static WebElement loginEmail;
    @FindBy(name = "password")
    private static WebElement loginPassword;
    @FindBy(xpath = "//button[text()='Sign in']")
    private static WebElement loginSubmitButton;
    @FindBy(xpath = "//span[text()='Invalid email address']")
    private static WebElement loginInvalidEmail;

    @FindBy(xpath = "//span[text()='Maximum 20 characters']")
    private static WebElement maxCharacters;

    @FindBy(name = "firstName")
    private static WebElement registrationFirstName;

     public void openAndersenLoginPage(){
        driver.get("https://qa-course-01.andersenlab.com/login");
    }

    public void visibilityOfLoginEmail(){
        wait.until(ExpectedConditions.visibilityOf(loginEmail));
    }
    public void visibilityOfLoginPassword(){
        wait.until(ExpectedConditions.visibilityOf(loginPassword));
    }
    public void visibilityRegistrationPageElement(){
        wait.until(ExpectedConditions.visibilityOf(registrationFirstName));
    }

    public void invalidEmail(){
        String emailInvalidAssert = loginInvalidEmail.getText();
        Assert.assertEquals(emailInvalidAssert, "Invalid email address");
    }

    public void errorCharacters(){
        String passwordMaxCharacter = maxCharacters.getText();
        Assert.assertEquals(passwordMaxCharacter, "Maximum 20 characters");
    }

    public void setPlaceholder(){
        String placeholderTextEmail = loginEmail.getAttribute("placeholder");
        Assert.assertEquals(placeholderTextEmail, "Enter email", "Placeholder is wrong");
        String placeholderTextPassword = loginPassword.getAttribute("placeholder");
        Assert.assertEquals(placeholderTextPassword, "Enter password", "Placeholder is wrong!");
    }

    public void registrationButton(){
        registrationLink.click();
    }

    public void setLoginEmail(String email){
        loginEmail.sendKeys(email);
    }

    public void setPassword(String password){
        loginPassword.sendKeys(password);

    }
}