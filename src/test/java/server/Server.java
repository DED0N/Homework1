package server;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Server {

    public static void main(String[] args) {

        int portNumber = 4446;

        // int portNumber = Integer.parseInt(System.getProperty("ServerPort"));

        HttpServer sv = null;

        try {
            sv = HttpServer.create();
            sv.bind(new InetSocketAddress(portNumber), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Задаем параметры контекста для сервера
         */
        HttpContext svCon = sv.createContext("/", new Server.echoHandler());

        HttpContext svCon2 = sv.createContext("/help", new Server.echoHandlerHelp());

        HttpContext svCon3 = sv.createContext("/calculate", new Server.echoHandlerCalculate());

        HttpContext svCon4 = sv.createContext("/employees", new Server.echoHandlerEmployees());

        sv.setExecutor(null);
        sv.start();
    }

    /**
     * Страница информации о клиентах
     */

    static class echoHandlerEmployees implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            ArrayList<String> headers = new ArrayList<>();
            exchange.getRequestHeaders().values().forEach(o -> headers.add(o.toString()));
            exchange.getRequestHeaders().values().forEach(o -> System.out.println("header: " + o));

            for (String a : headers) {
                if (a.contains("Employees")) {
                    stringBuilder.append("List of employees: \n");
                    stringBuilder.append(employeesList());
                }
            }


            byte[] byteArray = stringBuilder.toString().getBytes();
            exchange.sendResponseHeaders(200, byteArray.length);
            OutputStream os = exchange.getResponseBody();

            os.write(byteArray);
            os.close();
            exchange.close();
        }
    }

    /**
     * Страница подсчета заработной платы + премия
     */
    static class echoHandlerCalculate implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            ArrayList<String> headers = new ArrayList<>();
            exchange.getRequestHeaders().values().forEach(o -> headers.add(o.toString()));
            exchange.getRequestHeaders().values().forEach(o -> System.out.println("header: " + o));

            for (String a : headers) {
                if (a.contains("Calculate")) {
                    stringBuilder.append("Welcome to Calculate Page! Data: \n");
                    stringBuilder.append(calculateSalary(45000, 1000, 20));

                }
            }

            byte[] byteArray = stringBuilder.toString().getBytes();
            exchange.sendResponseHeaders(200, byteArray.length);
            OutputStream os = exchange.getResponseBody();

            os.write(byteArray);
            os.close();
            exchange.close();
        }
    }

    /**
     * Страница справочной информации
     */

    static class echoHandlerHelp implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            ArrayList<String> headers = new ArrayList<>();
            exchange.getRequestHeaders().values().forEach(o -> headers.add(o.toString()));
            exchange.getRequestHeaders().values().forEach(o -> System.out.println("header: " + o));

            for (String a : headers) {
                if (a.contains("Help")) {
                    stringBuilder.append("Welcome to Help Page\n Commands: \n 1. /calculate \n 2. /employees \n 3./employees");
                }
            }

            byte[] byteArray = stringBuilder.toString().getBytes();
            exchange.sendResponseHeaders(200, byteArray.length);
            OutputStream os = exchange.getResponseBody();

            os.write(byteArray);
            os.close();
            exchange.close();
        }
    }

    /**
     * Начальная страница сайта
     */

    static class echoHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            ArrayList<String> headers = new ArrayList<>();
            exchange.getRequestHeaders().values().forEach(o -> headers.add(o.toString()));
            exchange.getRequestHeaders().values().forEach(o -> System.out.println("header: " + o));

            for (String a : headers) {
                if (a.contains("Hello")) {
                    stringBuilder.append("Hello to, my friend ");
                }
            }

            byte[] byteArray = stringBuilder.toString().getBytes();
            exchange.sendResponseHeaders(200, byteArray.length);
            OutputStream os = exchange.getResponseBody();

            os.write(byteArray);
            os.close();
            exchange.close();
        }
    }

    /**
     * Метод подсчета заработной платы сотрудника
     * @param baseSalary
     * @param prize
     * @param ndfl
     * @return
     */

    public static int calculateSalary(int baseSalary, int prize, float ndfl) {
        ndfl = (baseSalary + prize) * 20 / 100;
        int x = (int) (baseSalary + prize - ndfl);
        //System.out.println("Имя сотрудника: " + employeeName + "Зарплата: " + x);
        return x;
    }

    /**
     * Метод вывода информации о сотрудниках
     * @return
     */

    public static String employeesList() {
        ArrayList<String> empList = new ArrayList<>();
        empList.add("Володя");
        empList.add("Михаил");
        empList.add("Василий");

        empList.forEach(s -> System.out.println(empList));
        return listToJavascript(empList);
    }

    /**
     * Метод конвертации листа сотрудника, для корректного отображения на сайте
     * @param list
     * @return
     */

    public static String listToJavascript(List<String> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append("\"").append(list.get(i)).append("\"");
            if (i + 1 < list.size()) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
