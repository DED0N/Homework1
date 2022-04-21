package homeWork.secondLesson.Fixes;

public class MyFarm {
    public static void main(String[] args) {

        Cat simka = new Cat("Симка");
        Cat barsik = new Cat("Барсик");


        simka.setAge("10");
        simka.setVoice("Meow");
        simka.setFood("Лобстеры");

        System.out.println("Кличка: " + simka.getName());
        System.out.println("Голос: " + simka.getVoice());
        System.out.println("Возраст(лет): " + simka.getAge());
        System.out.println("Еда: " + simka.getFood());

        System.out.println("----------------------------------------------");

        barsik.setFood("Жидкий корм");
        barsik.setVoice("МЯЯЯЯЯЯУ!!!!");
        barsik.setAge("15");
        barsik.getColor();

        System.out.println("Кличка: " + barsik.getName());
        System.out.println("Голос: " + barsik.getVoice());
        System.out.println("Возраст: " + barsik.getAge());
        System.out.println("Еда: " + barsik.getFood());

    }
}
