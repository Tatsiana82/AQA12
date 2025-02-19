package Lesson_17;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterTest;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import utils.driver.DriverSetUp;
import java.time.Duration;
public class Task_3_Alerts {
    private static class FindLocators {
        private static By button = By.id("AlertButton");
        private static String alertText_1 = "You have called alert!";
        private static String alertText_2 = "Are you sure you want to apply the discount?";
        private static String alertText_3 = "Here you may describe a reason why you are cancelling your registration (or leave this field empty).";
        private static By clickLocatorDiscount = By.xpath("//button[text()='Get Discount']");
        private static By checkText = By.xpath("//button[@data-test-id='PromptButton']");
    }
    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    @AfterTest
    public void close() {
        driver.quit();
    }

@Test
public void signInPage() throws InterruptedException {
    driver = DriverSetUp.driverInit();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    actions = new Actions(driver);
    driver.get("https://qa-course-01.andersenlab.com/login");

        Thread.sleep(2000);
        driver.findElement(By.name("email")).sendKeys("tv_solovey@mail.ru");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Task_1_Select.FindLocators.techStack));
        actions.moveToElement(driver.findElement(Task_1_Select.FindLocators.techStack)).perform();
        driver.findElement(By.xpath("//div[text()='Actions, Alerts & Iframes']")).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath
                ("//iframe[@title='Finish your registration']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FindLocators.button));
        WebElement button = driver.findElement(By.id("AlertButton"));
        button.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.getText();
        assertEquals(alert.getText(), FindLocators.alertText_1);
        alert.accept();
        WebElement actualText1Locator = driver.findElement(By.xpath
                ("//span[text()='Congratulations, you have successfully enrolled in the course!']"));
        String expectedText = "Congratulations, you have successfully enrolled in the course!";
        String actualText = actualText1Locator.getText();
        Assert.assertEquals(actualText, expectedText, "The search result message is incorrect!");

        Thread.sleep(2000);

        actions.doubleClick(driver.findElement(FindLocators.clickLocatorDiscount)).perform();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.getText();
        assertEquals(alert.getText(), FindLocators.alertText_2);
        alert.accept();
        WebElement actualDoubleClickLocator = driver.findElement(By.xpath
                ("//span[contains(text(),'You received a 10% discount')]"));
        String expectedText_2 = "You received a 10% discount on the second course.";
        String actualText_2 = actualDoubleClickLocator.getText();
        Assert.assertEquals(actualText_2, expectedText_2, "The search result message is incorrect!");

        Thread.sleep(2000);

        actions.contextClick(driver.findElement(FindLocators.checkText)).perform();
        Alert alert_3 = driver.switchTo().alert();
        alert_3.getText();
        assertEquals(alert_3.getText(), FindLocators.alertText_3);
        String textTest = "Test";
        alert_3.sendKeys(textTest);
        alert_3.accept();
        WebElement locatorText = driver.findElement(By.xpath
                ("//span[text()='Your course application has been cancelled. Reason: Test']"));
        String actualText_3 = locatorText.getText();
        assertTrue(actualText_3.contains(textTest));
    }
}