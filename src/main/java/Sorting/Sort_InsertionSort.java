package Sorting;

public class Sort_InsertionSort {

    // Method to perform insertion sort - Shuffle Cards
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];       // Current element to be compared
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than key, to one position ahead
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;       // Insert the key at correct position
        }
    }

    // Method to print the array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] data = { 29, 10, 14, 37, 14 };

        System.out.println("Original Array:");
        printArray(data);

        insertionSort(data);

        System.out.println("Sorted Array:");
        printArray(data);
    }
}
