package homeWork.secondLesson;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class baseFarm {
    public static void main(String[] args) {


        //Создаем собакена
        metaAnimals Dog = new metaAnimals("Собака", "Черная", "Лай", "Жулька", "2 года");
        System.out.println(Dog.getInfo() + " " + Dog.getColor());

        //Создаем котяру
        metaAnimals Cat = new metaAnimals("Кошка", "Белая", "Мяуканье", "Симка", "1 год");
        System.out.println(Cat.getInfo());

        //Прошел год :)
        System.out.println("Год спустя..." + " \n");

        Cat.setAge("2 года");
        Cat.setVoice("Мурлыканье/Мяуканье");
        Cat.setName("Котяра");

        Dog.setAge("3 года");
        System.out.println(Cat.getInfo() + " \n");

        System.out.println(Dog.getInfo());

    }
}
