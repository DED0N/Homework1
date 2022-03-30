package homeWork.thirdLesson;


import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class starTest extends metaTest {
    String firstParam;
    String secondParam;

    @Parameters({"firstParam", "secondParam"})
    @Test(priority = 1)
    public void checkProf(String firstParam, String secondParam) {
        if (firstParam.equals("Иван Васильевич меняет профессию") && secondParam.equals("На какую?") && getOS(getOSCheck).contains("Windows")) {
            System.out.println("Иван Васильевич, сменил профессию на: " + getProf("Сварщик"));
            System.out.println("Информация о клиенте: " + infoClient());
        } else if (getOS("").contains("Other")) {
            System.out.println("Профессия: " + getProf("Неизвестно"));
        }

    }

    @Parameters({"firstParam", "secondParam"})
    @Test(priority = 2)
    public void checkUrl(String firstParam, String secondParam) {
        if (firstParam.equals("https://www.google.com/") && getOS(getOSCheck).contains("Windows")) {
            open("https://www.google.com/");
            $(By.name("q")).val(secondParam).pressEnter();
        }
    }
}
