package PageObject.DemoQA;

import PageObject.Meta;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Forms extends Meta {
    /**
     * Методы и локаторы для страницы "Forms"
     */
    @FindBy(xpath = ".//span[contains(., 'Practice Form')]")
    private WebElement practiceForm;

    @FindBy(xpath = ".//input[@id='firstName']")
    private WebElement fullName;

    @FindBy(xpath = ".//input[@id='lastName']")
    private WebElement lastName;

    @FindBy(xpath = ".//input[@id='userEmail']")
    private WebElement email;

    @FindBy(xpath = ".//label[contains(., 'Male')]")
    private WebElement genderButton;

    @FindBy(xpath = ".//input[@id='userNumber']")
    private WebElement mobile;

    @FindBy(xpath = ".//input[@id='dateOfBirthInput']")
    private WebElement dateOfBirth;

    @FindBy(xpath = ".//div[@aria-label='Choose Tuesday, April 26th, 2022']")
    private WebElement getDateOfBirth;

    @FindBy(xpath = ".//label[contains(., 'Sports')]")
    private WebElement hobbies;

    @FindBy(xpath = ".//input[@id='uploadPicture']")
    private WebElement photo;

    @FindBy(xpath = ".//textarea[@id='currentAddress']")
    private WebElement currentAddress;

    @FindBy(xpath = ".//div[@id='state']")
    private WebElement state;

    @FindBy(xpath = ".//input[@id='react-select-3-input']")
    private WebElement stateText;

    @FindBy(xpath = ".//div[@id='city']")
    private WebElement city;

    @FindBy(xpath = ".//input[@id='react-select-4-input']")
    private WebElement cityText;

    @FindBy(xpath = ".//button[@id='submit']")
    private WebElement submitButton;

    @FindBy(xpath = ".//button[@id='closeLargeModal']")
    private WebElement closeModalWindowsButton;

    public Forms(WebDriver driver) {
        super(driver);
    }

    public void clickForms() {
        click(practiceForm);
    }

    public void setFilData(String textFullName, String textLastName, String textEmail, String textMobile, String currentAddres) {
        setText(fullName, textFullName);
        setText(lastName, textLastName);
        setText(email, textEmail);
        setText(mobile, textMobile);
        setText(currentAddress, currentAddres);
    }

    public void setFilData(String text) {
        setText(fullName, text);
        setText(lastName, text);
        setText(email, text);
    }

    public void setDatePicker() {
        click(dateOfBirth);
        click(getDateOfBirth);
    }

    public void setGender() {
        click(genderButton);
    }

    public void setHobbies() {
        click(hobbies);
    }

    public void setPhoto(String filePath) {
        loadFile(photo, filePath);
    }

    public void setStateAndCity(String setState, String setCity) {
        click(state);
        setText(stateText, setState);
        pressEnter(stateText);
        click(city);
        setText(cityText, setCity);
        pressEnter(cityText);
    }

    public void setEnter() {

    }

    public void setSubmitAndClose() {
        submitChoice(submitButton);
        click(closeModalWindowsButton);
    }

}
