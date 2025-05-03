package Array;

public class ArrayRotator {

    /**
     * Rotates the given array to the right by k steps.
     * @param nums The input array
     * @param k The number of steps to rotate
     */
    public void rotate(int[] nums, int k) {
        int start = 0;
        int end = 0;

        //Rotate First Group
        start = 0;
        end = nums.length - k -1;
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        //Rotate Second Group
        start = nums.length - k;
        end = nums.length-1;
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        //Rotate whole Group
        start = 0;
        end = nums.length-1;
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ArrayRotator rotator = new ArrayRotator();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Original array:");
        printArray(nums);

        rotator.rotate(nums, k);

        System.out.println("Rotated array:");
        printArray(nums);
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
