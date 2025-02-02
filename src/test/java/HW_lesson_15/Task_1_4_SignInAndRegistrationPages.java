package HW_lesson_15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_1_4_SignInAndRegistrationPages {
    //number4_RegistrationForm
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/registration");
        driver.findElement(By.className("text-2xl"));
        driver.quit();
    }
}