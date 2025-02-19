package Lesson_17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.driver.DriverSetUp;

import java.time.Duration;

public class Task_2_DragAndDrop {
    private static class FindLocators {
        private static By manual_1 = By.id("manual1");
        private static By manual_2 = By.id("manual2");
        private static By auto_1 = By.id("auto1");
        private static By auto_2 = By.id("auto2");
        private static By targetManual1 = By.id("target-manual1");
        private static By targetManual2 = By.id("target-manual2");
        private static By targetAuto1 = By.id("target-auto1");
        private static By targetAuto2 = By.id("target-auto2");
    }

    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    @BeforeMethod
    public void driverInit(){
        driver = DriverSetUp.driverInit();
        wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
    }
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
        driver.findElement(By.xpath("//div[text()='Drag & Drop']")).click();
        Thread.sleep(2000);
    }

    @Test
    public void taskDragAndDrop() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FindLocators.manual_2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FindLocators.targetManual2));
        actions.clickAndHold(driver.findElement(FindLocators.manual_1))
                .moveToElement(driver.findElement(FindLocators.targetManual1))
                .release()
                .build()
                .perform();
        actions.clickAndHold(driver.findElement(FindLocators.manual_2))
                .moveToElement(driver.findElement(FindLocators.targetManual2))
                .release()
                .build()
                .perform();

        actions.dragAndDrop(driver.findElement(FindLocators.auto_1), driver.findElement(FindLocators.targetAuto1))
                .perform();
        actions.dragAndDrop(driver.findElement(FindLocators.auto_2), driver.findElement(FindLocators.targetAuto2))
                .perform();
        Thread.sleep(2000);

        WebElement text = driver.findElement(By.xpath
                ("//div[contains(text(), \"Congratulations! Let's test for the best!\")]"));

        String expectedText = "Congratulations! Let's test for the best!";
        String actualText = text.getText();
        Assert.assertEquals(actualText, expectedText, "The search result message is incorrect!");
        Thread.sleep(2000);
    }
}
