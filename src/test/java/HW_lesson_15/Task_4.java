package HW_lesson_15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Task_4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/login");

        driver.findElement(By.name("email")).sendKeys("123@mail.ru");
        driver.findElement(By.name("password")).sendKeys("123456789");

        WebElement button = driver.findElement(By.xpath("//button"));
        button.click();

        Thread.sleep(2000);
        driver.quit();
    }
}