/**
 * Problem: Container With Most Water
 *
 * Given an array 'height' of n non-negative integers, where each element represents a vertical line at index i
 * from (i, 0) to (i, height[i]), find two lines that together with the x-axis forms a container
 * such that the container holds the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * You cannot slant the container.
 *
 * Example:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * Approach: Use two-pointer technique to check all possible pairs efficiently.
 */
package Array;
public class LeetCode11_ContainerWithMostWater {

    /**
     * Placeholder method to find maximum area.
     * @param height an array representing heights of vertical lines
     * @return maximum area of water that can be contained
     */
    public static int maxArea(int[] height) {
        // The area is calculated as: area = width * height
        // Width → distance between two lines (along X-axis)
        // Height → shorter of the two lines (since water can't be higher than the shorter wall)

        int maxArea = 0;                  // To keep track of the maximum area found
        int leftIndex = 0;                // Pointer starting from the left end
        int rightIndex = height.length - 1; // Pointer starting from the right end

        // Keep moving pointers towards each other until they meet
        while (leftIndex < rightIndex) {
            int width = rightIndex - leftIndex; // Width between the two lines
            int tempHeight = Math.min(height[leftIndex], height[rightIndex]); // Height is determined by the shorter line
            int tempArea = width * tempHeight; // Calculate the area for the current pair of lines

            maxArea = Math.max(maxArea, tempArea); // Update maxArea if this area is bigger

            // Move the pointer pointing to the shorter line inward,
            // because moving the taller line won't help (area limited by shorter line)
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++; // Move left pointer rightward to find a potentially taller line
            } else {
                rightIndex--; // Move right pointer leftward to find a potentially taller line
            }
        }

        // Return the largest area found
        return maxArea;
    }


    public static void main(String[] args) {
        // Test cases
        int[] test1 = {1,8,6,2,5,4,8,3,7};
        int[] test2 = {1,1};
        int[] test3 = {4,3,2,1,4};
        int[] test4 = {1,2,1};
        int[] test5 = {2,3,4,5,18,17,6};

        System.out.println("Test 1 (Expected 49): " + maxArea(test1));
        System.out.println("Test 2 (Expected 1): " + maxArea(test2));
        System.out.println("Test 3 (Expected 16): " + maxArea(test3));
        System.out.println("Test 4 (Expected 2): " + maxArea(test4));
        System.out.println("Test 5 (Expected 17): " + maxArea(test5));
    }
}
