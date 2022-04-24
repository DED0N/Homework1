package homeWork.secondLesson;

public class BaseFarm {
    public static void main(String[] args) {

        //Создаем собакена
        MetaAnimals dog = new MetaAnimals("Собака", "Черная", "Лай", "Жулька", "2 года");
        System.out.println(dog.getInfo() + " " + dog.getColor());

        //Создаем котяру
        MetaAnimals cat = new MetaAnimals("Кошка", "Белая", "Мяуканье", "Симка", "1 год");
        System.out.println(cat.getInfo());

        //Прошел год :)
        System.out.println("Год спустя..." + " \n");

        cat.setAge("2 года");
        cat.setVoice("Мурлыканье/Мяуканье");
        cat.setName("Котяра");

        dog.setAge("3 года");
        System.out.println(cat.getInfo() + " \n");

        System.out.println(dog.getInfo());

    }
}
