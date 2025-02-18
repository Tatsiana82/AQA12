package Lesson_17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.driver.DriverSetUp;
import java.time.Duration;

public class Task_1_Select {
    public static class FindLocators {
        public static final By techStack = By.xpath("//div[text()='AQA Practice']");
        private static final By selectYourCountry =  By.xpath("//select[@data-lol='SelectCountry']");
    }
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeMethod
    public void driverInit(){
        driver = DriverSetUp.driverInit();
        wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
    @Test
    public void signInPage() throws InterruptedException {
        driver.get("https://qa-course-01.andersenlab.com/login");
        Thread.sleep(2000);

        driver.findElement(By.name("email")).sendKeys("tv_solovey@mail.ru");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(FindLocators.techStack));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(FindLocators.techStack)).perform();
        driver.findElement(By.xpath("//div[text()='Select']")).click();
        Thread.sleep(2000);

        WebElement countryDropdown = driver.findElement(By.xpath("//select[@title='Select country']"));
        Select selectUSA = new Select(countryDropdown);
        selectUSA.selectByVisibleText("USA");

        WebElement languageDropdown = driver.findElement(By.id("SelectLanguage"));
        Select selectEnglish = new Select(languageDropdown);
        selectEnglish.selectByVisibleText("English");

        WebElement typeDropdown = driver.findElement(By.xpath("//select[@data-doubtful-but-ok='SelectType']"));
        Select selectTesting = new Select(typeDropdown);
        selectTesting.selectByVisibleText("Testing");

        WebElement calendarDateFirst = driver.findElement(By.xpath("//input[@data-calendar='1']"));
        calendarDateFirst.sendKeys("18022025");

        WebElement calendarSecond = driver.findElement(By.xpath("//input[@data-calendar='2']"));
        calendarSecond.sendKeys("18032025");

        WebElement coursesSelectDropdown = driver.findElement(By.id("MultipleSelect"));
        Select select = new Select(coursesSelectDropdown);
        select.selectByVisibleText("AQA Java");
        select.selectByVisibleText("AQA Python");

        driver.findElement(By.xpath
                ("//button[@name='SelectPageSearchButton']")).click();
        Thread.sleep(2000);
        WebElement text = driver.findElement(By.xpath
                ("//h2[@class='mb-[35px] text-[24px] leading-[28.13px]']"));

        String expectedText = "Unfortunately, we did not find any courses matching your chosen criteria.";
        String actualText = text.getText();
        Assert.assertEquals(actualText, expectedText, "The search result message is incorrect!");
    }
}