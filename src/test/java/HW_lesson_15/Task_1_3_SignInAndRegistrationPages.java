package HW_lesson_15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_1_3_SignInAndRegistrationPages {
    //number3_RegistrationForm navigate
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://qa-course-01.andersenlab.com/login");
        driver.navigate().to("https://qa-course-01.andersenlab.com/registration");
        Thread.sleep(2);
        System.out.println("After redirection to URL: " + driver.getTitle() + "," + driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("After redirection back: " + driver.getTitle() + "," + driver.getCurrentUrl());
        Thread.sleep(2);
        driver.navigate().forward();
        System.out.println("After redirection forward: " + driver.getTitle() + "," + driver.getCurrentUrl());
        Thread.sleep(2);
        driver.navigate().refresh();
        Thread.sleep(2);

        driver.quit();
    }
}