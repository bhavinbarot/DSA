package Sorting;

public class Sort_InsertionSort {
    public static void printArray(int[] arr){
        System.out.println("");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Selection Sort - BigO(n^2)");

        int arr[] = {7, 8, 3, 1, 2};
        printArray(arr);
        for (int i = 1; i < arr.length ; i++) {
            int current = arr[i];
            int j = i-1;
            while(j>=0 && current < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
        }
    }
}
