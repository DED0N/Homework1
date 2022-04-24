package PageObject.DemoQA;

import PageObject.Meta;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQA extends Meta {
    /**
     * Методы и локаторы для главной страницы сайта
     */

    @FindBy(xpath = ".//h5[contains(., 'Elements')]")
    private WebElement elements;

    @FindBy(xpath = ".//h5[contains(., 'Forms')]")
    private WebElement Forms;

    @FindBy(xpath = ".//h5[contains(., 'Alerts, Frame & Windows')]")
    private WebElement alerts;

    @FindBy(xpath = ".//h5[contains(., 'Widgets')]")
    private WebElement widgets;

    @FindBy(xpath = ".//h5[contains(., 'Interactions')]")
    private WebElement interactions;

    @FindBy(xpath = ".//a[@href='https://demoqa.com']")
    private WebElement home;

    public DemoQA(WebDriver driver) {
        super(driver);
    }

    public void clickElements() {
        click(elements);
    }

    public void clickForms() {
        click(Forms);
    }

    public void clickAlerts() {
        click(elements);
    }

    public void clickWidgets() {
        click(elements);
    }

    public void clickInteractions() {
        click(elements);
    }

    public void setHome() {
        click(home);
    }

}
