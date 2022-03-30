package homeWork.firstLesson;

public class primitives {

    public static void main(String[] args) {

        //////////////////////////////////////
        ///////////// ПРИМИТИВЫ /////////////
        ////////////////////////////////////


/*        byte b = 216; // ОШИБКА!!!, т.к. у нас диапазон от -128 до 127!
        char a = 'a', b = 'b', c = 'c';
        System.out.println(a + b + c/2 + " " + a ); // Выведет символ 'b'
        short s = 1123;
        int i = 64536;
        long l = 2147483648L;
        float e = 2.74f;
        double db = e * 5.5f;
        System.out.println(i);
        //System.out.println(b);
        System.out.println(s);
        System.out.println(l);
        System.out.println("Флоат будет равен: " + e + " " + "Дабл будет равен: " + db);

        System.out.println("Сложение: " + simpleCalculate(5, 5));*/


        ////////////////////////////////////////////////
        ////////// ССЫЛОЧНЫЕ ТИПЫ, ЦИКЛЫ И МАССИВЫ ////
        //////////////////////////////////////////////

        cycles cycle = new cycles();

        cycle.keyName = "* ";
        cycle.repeatCount = 8;
        cycle.startCycle();



        referenceType ref = new referenceType();
        System.out.println("Customer data: \n" + ref.name("Zigmund Freud") + "\n________" + "\n"  + ref.date("06.05.1856") + "\n" + "________" );

        int[] array = new int [5];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 3;
        array[4] = 4;

        for (int i = 0; i < array.length; ++i){
            System.out.println("Вывод: " + array[i]);
        }




    }

    public static int simpleCalculate(int a, int b) {
        int x = a + b;
        return x;
    }





}
