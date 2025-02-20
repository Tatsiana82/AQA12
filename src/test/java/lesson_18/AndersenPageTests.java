package lesson_18;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.driver.DriverSetUp;

public class AndersenPageTests {
    private static WebDriver driver;
    private static AndersenPage andersenPage;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.driverInit();
        andersenPage = new AndersenPage(driver);
    }
    @AfterClass
    public void close(){
        driver.quit();
    }

    //1. Go to website
    @Test
    public void checkOpenPage() {
        andersenPage.openAndersenLoginPage();
    }

    //2. Email and Password are visible
    @Test
    public void checkElementsLoginPage() {
        andersenPage.openAndersenLoginPage();
        andersenPage.visibilityOfLoginEmail();
        andersenPage.visibilityOfLoginPassword();
    }

    //3. Login positive test
    @Test
    public void loginPositiveTest() {
        andersenPage.openAndersenLoginPage();
        andersenPage.visibilityOfLoginEmail();
        andersenPage.setLoginEmail("tv_solovey@mail.com");
        andersenPage.setPassword("12345678");
    }
    //4. Login negative test: email
    @Test
    public void loginNegativeTestEmail() throws InterruptedException {
        andersenPage.openAndersenLoginPage();
        andersenPage.visibilityOfLoginEmail();
        andersenPage.setLoginEmail("tv_solovey@.com");
        andersenPage.setPassword("12345678");
        andersenPage.invalidEmail();
    }

    //5. Login negative test: email with letters
    @Test
    public void loginNegativeTestEmail2() throws InterruptedException {
        andersenPage.openAndersenLoginPage();
        andersenPage.visibilityOfLoginEmail();
        andersenPage.setLoginEmail("abcdefg");
        andersenPage.setPassword("12345678");
        andersenPage.invalidEmail();
    }
    //6. Login negative test: email with russian letters
    @Test
    public void loginNegativeTestEmail3() throws InterruptedException {
        andersenPage.openAndersenLoginPage();
        andersenPage.visibilityOfLoginEmail();
        andersenPage.setLoginEmail("абвгдежз");
        andersenPage.setPassword("12345678");
        andersenPage.invalidEmail();
    }

    //7. Login negative test: email without letters
    @Test
    public void loginNegativeTestEmail4() throws InterruptedException {
        andersenPage.openAndersenLoginPage();
        andersenPage.visibilityOfLoginEmail();
        andersenPage.setLoginEmail("     ");
        andersenPage.setPassword("12345678");
        andersenPage.invalidEmail();
    }
    //8. Visibility of placeholder
    @Test
    public void placeHolders() {
        andersenPage.openAndersenLoginPage();
        andersenPage.visibilityOfLoginPassword();
        andersenPage.setPlaceholder();
    }
    //9. Visibility of button
    @Test
    public void goToRegistrationPage() {
        andersenPage.openAndersenLoginPage();
        andersenPage.visibilityOfElementsRegistrationButton();
        andersenPage.registrationButton();
        andersenPage.visibilityRegistrationPageElement();
    }
   //10. Long password
    @Test
    public void errorCharacters() throws InterruptedException {
        andersenPage.openAndersenLoginPage();
        andersenPage.visibilityOfLoginEmail();
        andersenPage.setLoginEmail("tv_solovey@mail.com");
        andersenPage.setPassword("aaaaaaaaaaaaaaaaaaddddddddddddddd");
        andersenPage.errorCharacters();
    }
}