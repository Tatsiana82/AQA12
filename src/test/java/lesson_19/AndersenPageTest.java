package lesson_19;

import driver.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.AndersenPage;
import listeners.AllureListeners;
import io.qameta.allure.Description;

@Listeners({AllureListeners.class})
public class AndersenPageTest {

    private static WebDriver driver;
    private static AndersenPage andersenPage;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.startDriver();
        andersenPage = new AndersenPage(driver);
    }
    @AfterClass
    public void close(){
        driver.quit();
    }

    @Description("1 Go to website")
    @Test
    public void testOpenPage() {
        andersenPage.openAndersenPage();
    }
    @Description("2 Email and Password are visible")
    @Test
    public void testCheckElementsLoginPage() {
        andersenPage.openAndersenPage();
        andersenPage.visibilityOfEmail();
        andersenPage.visibilityOfPassword();
    }
    @Description("3 SignIn positive test")
    @Test
    public void testSignInPositive() {
        andersenPage.openAndersenPage();
        andersenPage.visibilityOfEmail();
        andersenPage.setEmail("tv_solovey@mail.com");
        andersenPage.setPassword("12345678");
    }
    @Description("4 Negative test: email")
    @Test
    public void testNegativeEmail() throws InterruptedException {
        andersenPage.openAndersenPage();
        andersenPage.visibilityOfEmail();
        andersenPage.setEmail("tv_solovey@.com");
        andersenPage.setPassword("12345678");
        andersenPage.InvalidEmail();
    }
    @Description("5 Login negative test: email with letters")
    @Test
    public void testNegativeEmailLetters() throws InterruptedException {
        andersenPage.openAndersenPage();
        andersenPage.visibilityOfEmail();
        andersenPage.setEmail("abcdefg");
        andersenPage.setPassword("12345678");
        andersenPage.InvalidEmail();
    }
    @Description("6 Login negative test: email with russian letters")
    @Test
    public void testNegativeEmailRussianLetters() throws InterruptedException {
        andersenPage.openAndersenPage();
        andersenPage.visibilityOfEmail();
        andersenPage.setEmail("абвгдежз");
        andersenPage.setPassword("12345678");
        andersenPage.InvalidEmail();
    }

    @Description("7 Login negative test: email without letters")
    @Test
    public void testNegativeEmailVoid() throws InterruptedException {
        andersenPage.openAndersenPage();
        andersenPage.visibilityOfEmail();
        andersenPage.setEmail("     ");
        andersenPage.setPassword("12345678");
        andersenPage.InvalidEmail();
    }

    @Description("8 Visibility of placeholder")
    @Test
    public void testPlaceholder() {
        andersenPage.openAndersenPage();
        andersenPage.visibilityOfEmail();
        andersenPage.setPlaceholder();
    }
}