package Math;

/*
 * =========================================================================================
 * Problem Category: Math, Number Theory
 *
 * =========================================================================================
 * LeetCode Problem 1134 - "Armstrong Number" (Easy)
 *
 * =========================================================================================
 * Problem Description:
 * Given an integer `n`, return true if and only if it is an **Armstrong number**.
 *
 * An **Armstrong number** of `k` digits is an integer such that the sum of each digit raised
 * to the power `k` is equal to the number itself.
 *
 * For example, for `n = 153`, it has 3 digits:
 * => 1^3 + 5^3 + 3^3 = 153, so it is an Armstrong number.
 *
 * =========================================================================================
 * Example Test Cases:
 *
 * Input: n = 153
 * Output: true
 *
 * Input: n = 123
 * Output: false
 *
 * Input: n = 9474
 * Output: true
 *
 * =========================================================================================
 * Brute Force Approach:
 * 1. Convert number to string
 * 2. Get number of digits
 * 3. For each digit, raise to power of number of digits
 * 4. Sum them up and compare with original number
 *
 * Time Complexity: O(d) where d is number of digits
 *
 * =========================================================================================
 * Optimal Approach:
 * Same as brute force – it's already optimal for this constraint (1 <= n <= 10^8)
 *
 * =========================================================================================
 * Additional Hints:
 * - There are only a small number of Armstrong numbers below 1e9.
 * - Precomputing powers can speed it up marginally, but not needed for an interview setting.
 *
 * =========================================================================================
 */

public class LeetCode_1134_ArmstrongNumber_Easy {

    public static void main(String[] args) {
        runTests();
    }

    // === Placeholder for core implementation ===
    public static boolean isArmstrong(int n) {
        int originalNumber = n;
        int sumOfPower = 0;
        int totalDigits = numberOfDigits(originalNumber);

        n = originalNumber;
        System.out.printf("\nOriginal Number = %d\n", originalNumber);
        while(n > 0){
            int digit = n % 10;
            System.out.printf("\ndigit = %d", digit);
            sumOfPower = sumOfPower + powerofN(digit, totalDigits);
            System.out.printf(" powerofN = %d sumOfPower = %d",powerofN(digit, totalDigits), sumOfPower);
            n = n/10;
        }
        if(sumOfPower == originalNumber){
            return true;
        }
        else{
            return false;
        }
    }

    public static int numberOfDigits(int num){
        int  totalDigits = 0;
        while(num > 0){
            int digit = num % 10;
            totalDigits++;
            num = num/10;
        }
        return totalDigits;
    }
    public static int powerofN(int num, int power){
        int ans = 1;
        while(power > 0){
            ans = ans * num;
            power--;
        }
        return ans;
    }

    // === Utility method to run test cases ===
    public static void runTests() {
        int[] testInputs = {153, 123, 9474, 9475, 0, 370, 371, 407};
        boolean[] expectedOutputs = {true, false, true, false, true, true, true, true};

        System.out.println("Running Test Cases:\n------------------------");

        for (int i = 0; i < testInputs.length; i++) {
            int input = testInputs[i];
            boolean expected = expectedOutputs[i];
            boolean actual = isArmstrong(input);

            if (actual == expected) {
                System.out.printf("Input: %d | Expected: %s | Actual: %s | ✅ PASS%n", input, expected, actual);
            } else {
                System.out.printf("Input: %d | Expected: %s | Actual: %s | ❌ FAIL%n", input, expected, actual);
            }
        }
    }

    // === (Optional) Helper method to count digits ===
    private static int countDigits(int n) {
        return String.valueOf(n).length();
    }

    // === (Optional) Helper method to calculate digit power ===
    private static int power(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }
}

