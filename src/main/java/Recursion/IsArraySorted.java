package Recursion;

public class IsArraySorted {
    public static void main(String[] args){
        int array1[] = {1,2,3,4,5};
        System.out.println(isArraySorted(array1, array1.length));

        int array2[] = {1,22,3,4,5};
        System.out.println(isArraySorted(array2, array2.length));
    }
    public static boolean isArraySorted(int array[], int n){
        if(n<2){
            return true;
        }
        return (array[n-1] >= array[n-2]) && isArraySorted(array, n-1);

    }
}
