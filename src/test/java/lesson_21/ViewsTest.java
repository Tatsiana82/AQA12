package lesson_21;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
//1
public class ViewsTest {
    @BeforeMethod
    public void setUp(){
        driver =  new AppiumDriverInit().getDriver();
        androidPage = new AndroidPage(driver);
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Views']")
    private AndroidElement viewsOption;

    @AndroidFindBy(className = "android.widget.TextView")
    private List<AndroidElement> viewElements;

    @Test
    public void testElementsCount() {
        viewsOption.click();
        Assert.assertEquals(viewElements.size(), 42, "Количество элементов 42");
    }
}