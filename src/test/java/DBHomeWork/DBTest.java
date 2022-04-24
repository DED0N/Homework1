package DBHomeWork;

import db.DBHelper;
import org.testng.annotations.Test;

public class DBTest {
    @Test
    public void startTest() {

        //DBHelper.getLastID(); //Данный метод должен был генерить случайный id и находить его. Но появляется блок. ошибка, при его выполнении
        //DBHelper.getGet(); //Метод аналогичный первому, таже самая ошибка: "Field 'id' doesn't have a default value"

        DBHelper.insertIntoBD();

        String getFromBD = "SELECT * FROM REGISTRATION";

        DBHelper.getSqlResult(getFromBD).forEach(s -> System.out.println());

    }
}
