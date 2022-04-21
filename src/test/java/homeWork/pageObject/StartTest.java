package homeWork.pageObject;

import PageObject.DemoQA.DemoQA;
import PageObject.DemoQA.Forms;
import PageObject.DemoQA.TextBox;
import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class StartTest extends BaseTest {



    @Test(suiteName = "DemoQAHome")



    public void startDemoQA() {
        DemoQA demoQA = new DemoQA(getDriver());

        getDriver().get(standURL);
        getDriver().manage().window().maximize();
        try {
            anAssert.assertNotNull(getDriver().findElement(By.xpath(".//h5[contains(., 'Elements')]")).isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ОШИБКА! Элемента не существует");
        }
        demoQA.clickElements();
        demoQA.setHome();
        demoQA.clickForms();

        takeScreenshot("startDemoQA");
    }


    @Test(testName = "textBoxTest")
    public void startTextBox() {
        getDriver().get(standURL);
        getDriver().manage().window().maximize();

        DemoQA demoQA = new DemoQA(getDriver());
        demoQA.clickElements();


        TextBox textBox = new TextBox(getDriver());
        textBox.clickTextBox();

        try {
            anAssert.assertNotNull(getDriver().findElement(By.xpath(".//input[@id='userName']")).isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ОШИБКА! Элемента не существует");
        }

            textBox.setFullName("Иванов Иван Иванович");
            textBox.setEmail("autotestCOOL@testov.net");
            textBox.setCurrentAddress("Ул. Пушкина, д. Колотушкина");
            textBox.setPermanentAddress("Ул. Пушкина, д. Колотушкина");
            takeScreenshot("startTextBox");

        }


        @Test()
        public void startForms () {
            getDriver().get(standURL);
            getDriver().manage().window().maximize();

            DemoQA demoQA = new DemoQA(getDriver());
            demoQA.clickForms();

            Forms forms = new Forms(getDriver());
            forms.clickForms();
            forms.setFilData("Василий", "Петров", "autotestCOOL@testov.net", "8917771337", "Живу там, где по кайфу");
            forms.setDatePicker();
            forms.setGender();
            forms.setHobbies();
            forms.setPhoto(System.getProperty("user.dir") + "\\src\\main\\resources\\мем.jpg");
            forms.setStateAndCity("NCR", "Delhi");
            forms.setSubmitAndClose();

            takeScreenshot("startForms");

        }
    }
