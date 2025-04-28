package Sorting;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int array1[] = {0,3,4,31,32,33}; //Length = 4
        int array2[] = {4,6,30}; //Length = 3

        printArray(mergeSortedArrays(array1, array2));
    }
    public static void printArray(int array[]){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
    }

    public static int[] mergeSortedArrays(int array1[], int array2[]){

        int mergedArray[] = new int[array1.length+array2.length];

        //check empty inputs
        if(array1.length==0){
            return array2;
        }
        if(array2.length==0){
            return array1;
        }

        int currentIndex=0;
        int array1Index=0;
        int array2Index=0;

        while(array1Index < array1.length && array2Index < array2.length){
            if(array1[array1Index] <= array2[array2Index]){
                mergedArray[currentIndex++] = array1[array1Index++];
            }
            else {
                mergedArray[currentIndex++] = array2[array2Index++];
            }
        }

        while(array1Index < array1.length){
            mergedArray[currentIndex++] = array1[array1Index++];
        }

        while(array2Index < array2.length){
            mergedArray[currentIndex++] = array1[array2Index++];
        }


        return mergedArray;

    }
}
