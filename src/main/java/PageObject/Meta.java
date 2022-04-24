package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Meta {

    private WebDriver driver;

    public Meta(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Получаем драйвер
     * @return
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Метод клика по элементу сайта
     * @param element
     */
    public void click(final WebElement element) {
        waitVisibleElement(element);
        element.click();
    }

    /**
     * Метод ввода данных в текстовые поля
     * @param element
     * @param text
     */
    public void setText(final WebElement element, final String text) {
        waitVisibleElement(element);
        element.sendKeys(text);
    }

    /**
     * Метод получения данных с поля
     * @param element
     * @return
     */
    public String getText(final WebElement element) {
        waitVisibleElement(element);
        return element.getText();
    }

    /**
     * Метод ожидания отображения элемента на сайте
     * @param element
     * @return
     */
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

    /**
     * Метод загрузки файла на сайт
     * @param element
     * @param filePath
     */

    public void loadFile(final WebElement element, final String filePath) {
        waitVisibleElement(element);
        element.sendKeys(filePath);
    }

    /**
     * Метод для подтверждения всплывающих форм
     * @param element
     */

    public void submitChoice(final WebElement element) {
        element.submit();
    }

    /**
     * Метод нажатия клавиши "Enter"
     * @param element
     */
    public void pressEnter(final WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

}
