package homeWork.firstLesson;

public class Cycles {

    public static String keyName = "";

    public static int repeatCount;

        public static void startCycle()
        {
            for (int i = 0; i < repeatCount; i++){
                System.out.println(keyName += keyName);
            }
        }


    }
