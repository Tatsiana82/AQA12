package android_package;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AndroidPage {
    AppiumDriver driver;
    WebDriverWait waiters;

    public AndroidPage(AppiumDriver driver) {
        this.driver = driver;
        waiters = new WebDriverWait(driver, 10);
    }

    private static final class Locators {
        private static final By views = MobileBy.AccessibilityId("Views");
        private static final By textClock = MobileBy.AccessibilityId("TextClock");
        private static final By time = MobileBy.xpath("//android.widget.TextView[4]");
    }

    public void clickOnViews() {
        waiters.until(ExpectedConditions.visibilityOfElementLocated(Locators.views)).click();
    }

    public void clickOnTextClick() {
        waiters.until(ExpectedConditions.visibilityOfElementLocated(Locators.textClock)).click();
    }

    public void scrollUntilTextClockAndClick() {
        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"TextClock\"))"));
        element.click();
    }

    public  void printTime(){
        System.out.println(waiters.until(ExpectedConditions.visibilityOfElementLocated(Locators.time)).getText());
    }

    public void checkClockWork(){
        int firstTime = Integer.parseInt(waiters.until(ExpectedConditions.visibilityOfElementLocated(Locators.time)).getText()
                .split("\\s")[0].split(":")[2]);
        int countOfSecondsToWait = 5;
        try {
            Thread.sleep(countOfSecondsToWait * 1000);
        }catch (Exception ignored){}

        int secondTime = Integer.parseInt(waiters.until(ExpectedConditions.visibilityOfElementLocated(Locators.time)).getText()
                .split("\\s")[0].split(":")[2]);
        Assert.assertEquals(secondTime - firstTime, countOfSecondsToWait, "Clock works incorrect!");
    }
}