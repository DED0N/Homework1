package DBHomeWork;

import db.DBHelper;
import org.testng.annotations.Test;

public class DBTest {
    @Test
    public void startTest() {

        String getFromBD = "SELECT * FROM REGISTRATION";

        DBHelper.insertIntoBD(878787, "Dobrynia2", "qwerty1337", 25);

        DBHelper.getSqlResult(getFromBD).forEach(s -> System.out.println(s));
        DBHelper.isExist(878787);
        //System.out.println(DBHelper.getValueFirstRow(sql, "first"));
    }
}
