import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability( "appActivity", "io.appium.android.apis.ApiDemos");
        capabilities.setCapability("appPackage","io.appium.android.apis");

        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
       // WebDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //AndroidDriver, IOSDriver'ın ikisini birden kapsar ---> AppiumDriver
        //WebDriver ve AppiumDriverın ikisini birden kapsar ---> RemoteWebdriver

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Animation\"]")).click();
        List<WebElement> elements = driver.findElements(By.id("android:id/text1"));
        for (WebElement el:elements) {
            System.out.println(el.getText());
        }
}}