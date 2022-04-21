package homeWork.pageObject;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import io.qameta.allure.Attachment;
import utils.PropertyLoader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {

    WebDriver driver;

    Assert anAssert;
    String testName;

    public String setStandKey = System.setProperty("standKey", "stand1");
    public String standKey = System.getProperty("standKey");
    public String standURL = PropertyLoader.loadProperty(standKey);




    @BeforeTest
    public void beforeTest() {
        System.setProperty("web-driver.chrome.driver", "/src/main/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(chromeOptions.CAPABILITY, chromeOptions);
        driver = new ChromeDriver();
        System.out.println("Старт теста");


    }


    @AfterTest
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Завершение теста");
    }


    public WebDriver getDriver() {
        return driver;
    }

    @Attachment(value = "Screenshot result", type = "image/png")
    public byte[] getScreenShots(){

        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    public void takeScreenshot(String testName) {
            File file = new File("./src/main/resources/" + testName + ".jpg");
            try {
                FileUtils.writeByteArrayToFile(file, getScreenShots());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
