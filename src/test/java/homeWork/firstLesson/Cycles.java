package homeWork.firstLesson;

public class Cycles {

    public static String keyName = "";

    public static int repeatCount;

    public static void startCycle() {
        for (int i = 0; i < repeatCount; i++) {
            System.out.println(keyName += keyName);
        }
    }

    public static void startWhile() {

        int number = 3;
        int result = 1;
        int power = 1;
        while (power <= 10) {
            result = result * number;
            System.out.println(number + " в степени " + power + " = " + result);
            power++;
        }
    }
}


