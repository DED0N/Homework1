package homeWork.pageObject;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.qameta.allure.Attachment;
import utils.PropertyLoader;

import java.io.File;
import java.io.IOException;


public class BaseTest {

    WebDriver driver;
    Assert anAssert;
    String testName;

    public String setStandKey = System.setProperty("standKey", "stand1");
    public String standKey = System.getProperty("standKey");
    public String standURL = PropertyLoader.loadProperty(standKey);

    /**
     * Действия перед началом теста. Объявление локального драйвера хром.
     */
    @BeforeTest
    public void beforeTest() {
        System.setProperty("web-driver.chrome.driver", "/src/main/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(chromeOptions.CAPABILITY, chromeOptions);
        driver = new ChromeDriver();
        System.out.println("Старт теста");

        //Подключение к селеноид и компиляция проекта на Дженкинс, в браузере FireFox.
        //Закоммитил, так как паралелльно работал с файлом и не всегда было удобно запускать докер и дженкинс для проверки :)

        // driver = new FirefoxDriver();
        /*firefoxOptions.setCapability("version", "97.0");
        URL hub = null;
        try {
            hub = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new RemoteWebDriver(hub, firefoxOptions);*/
    }

    /**
     * Действия после тестов
     */
    @AfterTest
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Завершение теста");
    }

    /**
     * Получение драйвера
     * @return
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Получение скриншота, после завершения прогона
     * @return
     */
    @Attachment(value = "Screenshot result", type = "image/png")
    public byte[] getScreenShots() {

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
