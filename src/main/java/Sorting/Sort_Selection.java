package Sorting;

public class Sort_Selection {
    public static void printArray(int[] arr){
        System.out.println("");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        System.out.println("Selection Sort - BigO(n^2)");

        int arr[] = {7,8,3,1,2};
        printArray(arr);
        int smallest_index = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("\n>>>>>>>>>>>>>>>>>>>for (int i = %d; i < %d; i++) -> i=%d",i,arr.length,i);
            smallest_index = i;
            System.out.printf("\n Smallest Index -> %d, " +
                    "arr[smallest_index]=%d, " +
                    "i=%d, " +
                    "arr[i]=%d, ",
                    smallest_index, arr[smallest_index], i, arr[i]);
            for (int j = i+1; j < arr.length; j++) {
                System.out.printf("\n>>>>for (int j = %d; j < %d; j++) -> j=%d",i+1,arr.length,j);
                System.out.printf("\nj=%d , smallest_index=%d, arr[smallest_index]=%d , '>', arr[j]=%d", j,smallest_index, arr[smallest_index],arr[j]);
                if(arr[smallest_index] > arr[j]){
                    smallest_index = j;
                    System.out.printf("\nUpdated Smallest Index as %d - the smallest value is : %d", j,arr[j]);
                }
            }
            int temp = arr[i];
            arr[i] =  arr[smallest_index];
            arr[smallest_index] = temp;

            printArray(arr);

        }
        printArray(arr);

    }



}
