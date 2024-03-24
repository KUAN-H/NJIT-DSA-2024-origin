package oy.tol.tra;

public class Algorithms {
    public static <T> void swap(T[] array, int first, int second) {
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static <T> void reverse(T[] array) {
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            swap(array, i, j);
        }
    }

    public static <T extends Comparable<T>> int binarySearch(T value, T[] array, int fromIndex, int toIndex) {
        while (fromIndex <= toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            int compareResult = value.compareTo(array[mid]);
            if (compareResult == 0) {
                return mid;
            } else if (compareResult < 0) {
                toIndex = mid - 1;
            } else {
                fromIndex = mid + 1;
            }
        }
        return -1;
    }

    public static <T extends Comparable<T>> void fastSort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }
}

