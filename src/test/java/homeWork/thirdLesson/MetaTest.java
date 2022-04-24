package homeWork.thirdLesson;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MetaTest {
    String getOSCheck;
    String filePath;
    String curDir = System.getProperty("user.dir");


    /**
     * Действия перед началом теста
     */
    @BeforeTest
    public void beforeTest() {
        System.out.println("Действия после начала теста");
    }

    /**
     * Действия перед началом метода. Проверяем ОС
     * @param getOSCheck
     * @return
     */
    @BeforeMethod
    public String getOS(String getOSCheck) {
        if (System.getProperty("os.name").contains("Windows")) {
            System.out.println("Запуск теста на Windows");
            getOSCheck = "Windows";
        } else {
            System.out.println("Внимание! Данный тест не актуален");
            getOSCheck = "Other";
        }
        return getOSCheck;
    }

    /**
     * Метод получения профессии из списка
     * @param prof
     * @return
     */
    public static ArrayList<String> getProf(String prof) {
        ArrayList<String> profGet = new ArrayList<>();
        profGet.add(prof);
        return profGet;
    }

    /**
     * Метод получения информации о клиенте
     * @return
     */

    public String infoClient() {
        if (System.getProperty("os.name").contains("Windows")) {
            filePath = curDir + "\\src\\main\\resources\\infoWindows";
        } else {
            filePath = curDir + "src/main/resources/infOther";
        }
        String line = null;

        try {
            BufferedReader bf = new BufferedReader(new FileReader(filePath));
            line = bf.readLine();
            bf.lines().forEach(s -> System.out.println(" " + s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    /**
     * Действия после теста
     */
    @AfterTest
    public void afterTest() {
        System.out.println("Действия после завершения теста");
    }


}
