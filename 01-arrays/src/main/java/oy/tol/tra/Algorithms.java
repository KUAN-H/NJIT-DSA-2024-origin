package oy.tol.tra;


public class Algorithms {
    public static <T extends Comparable<T>> void sort(T [] array) {
        for (int x = 0; x < array.length-1; x++) {
            int i = array.length - 1;
            while (i > 0) {
                if (array[i].compareTo(array[i - 1]) < 0) {
                    T tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                }
                i--;
            }
        }
    }
    public static <T> void reverse(T [] array) {
        int i = 0;
        while (i < array.length / 2) {
            T temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
            i++;
        }
    }

    public static <T>void swap(T[] array,int a,int b){
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}


