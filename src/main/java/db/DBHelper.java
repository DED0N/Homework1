package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class DBHelper {
    static String url = "jdbc:mysql://db4free.net:3306/testdatabase9290";
    static String userName = "testdatabase9290";
    static String userPassword = "123qweASD";

    static Connection connection = null;
    static Statement statement = null;

    /**
     * Метод авторизации в БД
     * @return
     */
    public static Connection init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, userPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Получаем результат обработки селект
     * @param sql
     * @return
     */
    public static ArrayList<HashMap<String, Object>> getSqlResult(final String sql) {
        ResultSet resultSet = null;
        init();
        ArrayList<HashMap<String, Object>> sqlResult = new ArrayList<>();
        HashMap<String, Object> map = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                map = new HashMap<String, Object>(resultSetMetaData.getColumnCount());
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    if (resultSet.getObject(i) == null) {
                        map.put(resultSetMetaData.getColumnName(i), "");
                    } else {
                        map.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
                    }
                }
                sqlResult.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sqlResult;
    }

    /**
     * Я не знаю почему не работает, пробовал множество методов, всегда выдает ошибку Field 'id' doesn't have a default value
     * Этот метод должен был отвечать за генерацию рандомного Primaray Key(id) и вывод последующего селека на экран
     * @return
     */

/*   public static int getLastID() {
        init();

        try {
            statement = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        int id = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO REGISTRATION (last, first, age) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Neeraj");
            ps.setString(2, "pppsds");
            ps.setInt(3, 25);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("id:"+getLastID());
        return id;
    }*/

/*    public static void getGet(){
        init();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "INSERT INTO REGISTRATION (last, first, age) VALUES ('gg', 'wp', 25)";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * Метод загрузки информации в базу данных
     * @return
     */
    public static String insertIntoBD() {
        init();
        String sql = "INSERT INTO REGISTRATION (id, last, first, age) VALUES(?, ?, ?, ?)";

        try {
            statement = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (final PreparedStatement ppStatement = connection.prepareStatement(sql)) {
            ppStatement.setInt(1, getRandomNumber());
            ppStatement.setString(2, getRandomName());
            ppStatement.setString(3, getRandomPassword());
            ppStatement.setInt(4, getRandomAge());
            ppStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sql;
    }

    /**
     * Метод получения случайного id
     * @return
     */
    public static int getRandomNumber() {
        int max = 1000;
        int min = 100;
        int a;
        a = (int) ((Math.random() * (max - min)) + min);
        System.out.println(a);
        return a;
    }

    /**
     * Метод получения случайного возраста
     * @return
     */
    public static int getRandomAge() { //Генерация рандомного возраста
        int max = 0;
        int min = 100;
        return (int) ((Math.random() * (max - min)) + min);
    }

    /**
     * Метод получения случайного имени. На основе миллисекунд и имени в формате String
     * @return
     */
    public static String getRandomName() { //Генерация рандомного имени
        long unixTime = System.currentTimeMillis() / 100l;
        String testName = "testuser";
        String x = testName + unixTime;
        return x;
    }

    /**
     * Метод генерации пароля на основе UUID
     * @return
     */
    public static String getRandomPassword() { //Генерация рандомного пароля
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }

    /**
     * Метод, отвечающий за поиск добавленной записи вручную.
     */
/*    public static boolean isExist() {
        init();
        boolean isUserExists = false;
        try (PreparedStatement ps = connection.prepareStatement("SELECT 1 FROM REGISTRATION WHERE id = ?")) {
            ps.setInt(1, );
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    isUserExists = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (isUserExists) {
            System.out.println("User exists!");
        }
        return isUserExists;
    }*/

}

