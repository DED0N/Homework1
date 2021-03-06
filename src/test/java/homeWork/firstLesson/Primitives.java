package homeWork.firstLesson;

public class Primitives {

    public static void main(String[] args) {


        //Вызов методов
        simpleCalculate(1, 2);
        checkParity(3, 2);

        //Примитивы

        int a = 1;
        int b = 2;
        int x = 10;
        int y = 20;
        int resultData = x ^ y;

        boolean result = a == b;
        System.out.println("a == b :" + result);

        result = a != b;
        System.out.println("a != b :" + result);

        result = a > b;
        System.out.println("a >  b :" + result);

        result = a >= b;
        System.out.println("a >= b :" + result);

        result = a < b;
        System.out.println("a <  b :" + result);

        result = a <= b;
        System.out.println("a <= b :" + result);

        String morning1 = "доброе";
        String morning2 = "не доброе, потому что сегодня понедельник";

        System.out.println("Сегодня утро " + morning1);
        System.out.println("Сегодня утро " + morning2);

        System.out.println(x + " ^ " + y);
        System.out.println("Result = " + resultData);
        System.out.println("Result in binary String = " + Integer.toBinaryString(resultData));

        Cycles cycle = new Cycles();

        cycle.keyName = "* ";
        cycle.repeatCount = 8;
        cycle.startCycle();
        cycle.startWhile();


        //Массивы

        ReferenceType ref = new ReferenceType();
        System.out.println("Customer data: \n" + ref.name("Zigmund Freud") + "\n________" + "\n" + ref.date("06.05.1856") + "\n" + "________");

        int[] array = new int[5];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 3;
        array[4] = 4;

        for (int i = 0; i < array.length; ++i) {
            System.out.println("Вывод: " + array[i]);
        }

    }

    /**
     * Простой калькулятор :)
     * @param a
     * @param b
     * @return
     */

    public static int simpleCalculate(int a, int b) {
        int x = a + b;
        System.out.println(x);
        return x;
    }

    /**
     * Вычесление четности и нечотности числа
     * @param a
     * @param b
     * @return
     */

    public static int checkParity(int a, int b) {
        int x = a % b;
        if (a % b == 0) {
            System.out.println("Число четное");
        } else {
            System.out.println("Число нечетное");
        }
        return x;
    }


}
