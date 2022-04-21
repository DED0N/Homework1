package homeWork.secondLesson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ListsAndArrays {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Первое значение");
        list.add("Второе значение");
        list.add("Третье значение");


        list.get(0);

        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }

        for (String s : list) {
            System.out.println("\n" + s);
        }

        list.forEach(s -> System.out.println("Casual method " + s));

        list.stream().filter(s -> s.length() >= 15).forEach(s -> System.out.println("Filter method: " + s));

        list.stream().filter(s -> s.contains("П")).forEach(s -> System.out.println("Filter method contains: " + s));

        ArrayList<String> secondList = (ArrayList<String>)
                list.stream().filter(s -> s.length() >= 15).collect(Collectors.toList());
        secondList.forEach(s -> System.out.println("Second list items: " + s));

        int[] array = new int[5];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;

        for (int i : array) {
            System.out.println(i);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Бургер", 300);
        hashMap.put("Наггетсы", 199);
        hashMap.put("Картофель фри", 130);
        hashMap.put("Сырный соус", 50);
        hashMap.put("Кока-кола", 150);


        hashMap.forEach((s, i) -> System.out.println("Товар: " + s + " | " + "Цена: " + i));


    }
}
