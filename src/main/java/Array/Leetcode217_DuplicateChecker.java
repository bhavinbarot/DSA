package Array;

import java.util.HashMap;
import java.util.HashSet;

public class Leetcode217_DuplicateChecker {

    /**
     * Returns true if any value appears at least twice in the array; otherwise false.
     * @param nums The input integer array
     * @return true if duplicate exists, false otherwise
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i : nums){
            if(hashSet.contains(i)){
                return true;
            }
            else{
                hashSet.add(i);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode217_DuplicateChecker checker = new Leetcode217_DuplicateChecker();

        int[][] testCases = {
                {1, 2, 3, 1},                      // Expected: true
                {1, 2, 3, 4},                      // Expected: false
                {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}     // Expected: true
        };

        boolean[] expectedResults = {true, false, true};

        for (int i = 0; i < testCases.length; i++) {
            boolean result = checker.containsDuplicate(testCases[i]);
            System.out.println("Test Case " + (i + 1) + ": Result = " + result +
                    ", Expected = " + expectedResults[i]);
        }
    }
}
