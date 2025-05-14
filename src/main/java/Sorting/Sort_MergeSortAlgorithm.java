package Sorting;
import java.util.Arrays;

public class Sort_MergeSortAlgorithm {
    public static void main(String[] args) {
        int array[] = {0, 3, 4, 31, 32, 33, 2};
        array = mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] mergeSort(int[] array) {
        return mergeSortHelper(array, 0, array.length);
    }

    public static int[] mergeSortHelper(int[] array, int start, int end) {
        if (end - start <= 1) {
            return new int[]{array[start]}; // base case: single element
        }

        int mid = start + (end - start) / 2;
        int[] left = mergeSortHelper(array, start, mid);
        int[] right = mergeSortHelper(array, mid, end);
        return mergeSortedArrays(left, right);
    }

    public static int[] mergeSortedArrays(int[] array1, int[] array2) {
        int[] array = new int[array1.length + array2.length];
        int index = 0, i = 0, j = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                array[index] = array1[i];
                i++;
            } else {
                array[index] = array2[j];
                j++;
            }
            index++;
        }

        while (i < array1.length) {
            array[index] = array1[i];
            index++;
            i++;
        }

        while (j < array2.length) {
            array[index] = array2[j];
            index++;
            j++;
        }

        return array;
    }
}
