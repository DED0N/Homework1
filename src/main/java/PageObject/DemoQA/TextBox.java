package PageObject.DemoQA;

import PageObject.Meta;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBox extends Meta {

    public TextBox(WebDriver driver) {
        super(driver);
    }

    /**
     * Методы и локаторы для страницы TextBox
     */

    @FindBy(xpath = ".//span[contains(., 'Text Box')]")
    private WebElement textBox;

    @FindBy(xpath = ".//input[@id='userName']")
    private WebElement fullName;

    @FindBy(xpath = ".//input[@id='userEmail']")
    private WebElement email;

    @FindBy(xpath = ".//textarea[@id='currentAddress']")
    private WebElement currentAddress;

    @FindBy(xpath = ".//textarea[@id='permanentAddress']")
    private WebElement permanentAddress;

    public void clickTextBox(){
        click(textBox);
    }

    public void setFullName(String text) {
        setText(fullName, text);
    }

    public void setEmail(String text) {
        setText(email, text);
    }

    public void setCurrentAddress(String text) {
        setText(currentAddress, text);
    }

    public void setPermanentAddress(String text) {
        setText(permanentAddress, text);
    }
}
