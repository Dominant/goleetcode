package tj.mirboboev.util;

public class Out {
    public static <T> void array(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("");
    }
}
