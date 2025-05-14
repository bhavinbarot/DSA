package Array_String;

/**
 * LeetCode Problem 12: Integer to Roman
 *
 * Problem Statement:
 * Given an integer, convert it to a Roman numeral.
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 *   I            1
 *   V            5
 *   X           10
 *   L           50
 *   C          100
 *   D          500
 *   M         1000
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * The number nine is written as IX. There are six instances where subtraction is used:
 * - I can be placed before V (5) and X (10) to make 4 and 9.
 * - X can be placed before L (50) and C (100) to make 40 and 90.
 * - C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Constraints:
 * 1 <= num <= 3999
 *
 * Examples:
 * Input: 3        Output: "III"
 * Input: 58       Output: "LVIII"   (50 + 5 + 3)
 * Input: 1994     Output: "MCMXCIV" (1000 + 900 + 90 + 4)
 *
 * Approach:
 * Use a greedy algorithm, mapping known Roman numeral values to their respective strings,
 * and subtract the largest possible value repeatedly from the number while appending
 * the corresponding Roman numeral string to the result.
 */

public class LeetCode_12_IntegerToRoman_Medium {

    public String intToRoman(int num) {
        // Arrays holding the Roman numeral values and their corresponding symbols
        // These are ordered from smallest to largest (you iterate from end to start)
        int nums[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String letters[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        // StringBuilder is used for efficient string concatenation
        StringBuilder roman = new StringBuilder();

        // Start from the end of the arrays, which contains the largest values
        for (int i = nums.length - 1; i >= 0; i--) {
            // Repeat while the current value can be subtracted from num
            while (num >= nums[i]) {
                // Debug print to track the step-by-step process
                System.out.printf("i=%d, num=%d, nums[i]=%d\n", i, num, nums[i]);

                // Subtract the current value from num
                num = num - nums[i];

                // Append the corresponding Roman numeral symbol
                roman.append(letters[i]);
            }
        }

        // Return the constructed Roman numeral string
        return roman.toString();
    }




    // Sample test cases to validate the implementation
    public static void main(String[] args) {
        LeetCode_12_IntegerToRoman_Medium converter = new LeetCode_12_IntegerToRoman_Medium();

        test(converter, 3, "III");
        test(converter, 4, "IV");
        test(converter, 9, "IX");
        test(converter, 58, "LVIII");
        test(converter, 1994, "MCMXCIV");
        test(converter, 3999, "MMMCMXCIX");
    }

    private static void test(LeetCode_12_IntegerToRoman_Medium converter, int input, String expected) {
        String result = converter.intToRoman(input);
        System.out.println("Input: " + input);
        System.out.println("Expected: " + expected);
        System.out.println("Output: " + result);
        System.out.println(result.equals(expected) ? "✅ Passed" : "❌ Failed");
        System.out.println("--------------");
    }
}

