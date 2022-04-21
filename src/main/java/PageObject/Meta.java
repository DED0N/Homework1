package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.List;

public class Meta {

    private WebDriver driver;

    public Meta(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void click(final WebElement element) {
        waitVisibleElement(element);
        element.click();
    }

    public void setText(final WebElement element, final String text) {
        waitVisibleElement(element);
        element.sendKeys(text);
    }

    public String getText(final WebElement element) {
        waitVisibleElement(element);
        return element.getText();
    }

    public boolean waitVisibleElement(final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 3);

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void loadFile(final WebElement element, final String filePath) {
        waitVisibleElement(element);
        element.sendKeys(filePath);
    }

    public void submitChoice(final WebElement element){
        element.submit();
    }

    public void pressEnter(final WebElement element){
        element.sendKeys(Keys.ENTER);
    }

}
