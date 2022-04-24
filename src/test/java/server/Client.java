package server;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {

    public static void main(String[] args) {

        startPage();
        helpPage();
        calculatePage();
        employeesPage();
    }

    /**
     * Запрос на начальную страницу сайта
     */

    public static void startPage() {
        HttpClient cl = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:4446"))
                .header("Type", "Hello")
                .build();

        HttpResponse<String> respons = null;

        try {
            respons = cl.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(respons.body());
    }

    /**
     * Запрос на страницу информации
     */

    public static void helpPage() {
        HttpClient cl = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:4446/help"))
                .header("Type", "Help")
                .build();

        HttpResponse<String> respons = null;

        try {
            respons = cl.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(respons.body());
    }

    /**
     * Запрос на страницу подсчета заработной платы
     */

    public static void calculatePage() {
        HttpClient cl = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:4446/calculate"))
                .header("Type", "Calculate")
                .build();

        HttpResponse<String> respons = null;

        try {
            respons = cl.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(respons.body());
    }

    /**
     * Запрос на страницу вывода списка сотрудников
     */
    public static void employeesPage() {
        HttpClient cl = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:4446/employees"))
                .header("Type", "Employees")
                .build();

        HttpResponse<String> respons = null;

        try {
            respons = cl.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(respons.body());
    }
}
