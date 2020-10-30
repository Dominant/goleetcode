package tj.mirboboev.sort;

import tj.mirboboev.util.Out;

class InsertionSort {

    public static void main(String[] args) {
        Out.array(sort(new Integer[]{6, 7, 8, 1, 4}));
        Out.array(sort(new Integer[]{}));
        Out.array(sort(new Integer[]{6}));
    }

    private static Integer[] sort(Integer[] unsorted) {
        for (int i = 1; i < unsorted.length; i++) {
            int j = i;

            while (j > 0 && (unsorted[j] < unsorted[j - 1])) {
                swap(unsorted, j, j - 1);

                j = j - 1;
            }
        }

        return unsorted;
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
