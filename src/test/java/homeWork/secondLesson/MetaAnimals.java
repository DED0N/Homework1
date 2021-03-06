package homeWork.secondLesson;

import java.util.ArrayList;
import java.util.Arrays;

public class MetaAnimals {

    private String name;
    private String color;
    private String voice;
    private String nickname;
    private String age;

    //Создаем конструктор

    MetaAnimals(String name, String color, String voice, String nickname, String age) {
        this.name = name;
        this.color = color;
        this.voice = voice;
        this.nickname = nickname;
        this.age = age;

    }

    //Создаем второй пустой контсруктор, чтобы можно было создавать класс без параметров

    MetaAnimals() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    /**
     * Получение информации о животном
     * @return
     */

    public ArrayList<String> getInfo() {
        ArrayList<String> animalInfo = new ArrayList<>(Arrays.asList(
                "Тип: " + name,
                "Цвет: " + color,
                "Общение: " + voice,
                "Кличка: " + nickname,
                "Возраст: " + age)
        );
        return animalInfo;
    }


}
