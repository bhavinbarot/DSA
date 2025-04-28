package Sorting;

public class Sort_Bubble {

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        //int arr[] = new int[5];
        int arr[] = {7,8,3,1,2};

        //Time Complexity - O(n^2)
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                //System.out.printf("\narr.length-1-i -> %d \n", arr.length-1-i);
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                //printArray(arr);
            }
        }
        System.out.println("\nSorted Array:");
        printArray(arr);


    }
}
