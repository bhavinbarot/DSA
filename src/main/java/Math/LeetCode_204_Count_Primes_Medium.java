package Math;

/**
 * 1) DSA Problem Category:
 *    - Mathematics
 *    - Prime Numbers
 *    - Sieve of Eratosthenes
 *
 * 2) Problem Statement:
 *    Count the number of prime numbers less than a non-negative number, n.
 *    A prime number is a natural number greater than 1 that is not a product of two smaller natural numbers.
 *
 * 3) Examples:
 *    Input: n = 10
 *    Output: 4
 *    Explanation: There are 4 prime numbers less than 10: 2, 3, 5, 7
 *
 *    Input: n = 0
 *    Output: 0
 *
 *    Input: n = 1
 *    Output: 0
 *
 * 4) Brute-force Approach:
 *    - Iterate from 2 to n-1
 *    - For each number, check if it is prime by testing divisibility from 2 to sqrt(i)
 *    - Time Complexity: O(n√n)
 *
 * 5) Optimized Approach:
 *    - Use the Sieve of Eratosthenes to precompute all prime numbers < n
 *    - Mark all multiples of each prime starting from 2
 *    - Time Complexity: O(n log log n)
 *
 * 6) Additional Hints:
 *    - Optimization starts with understanding that you don't need to check up to n for every number
 *    - Sieve drastically reduces repeated work
 *    - Use boolean arrays to mark non-prime numbers
 *
 * 7) Actual answers and expected answers should be printed in the console with PASS or FAIL status.
 */

public class LeetCode_204_Count_Primes_Medium {

    public static void main(String[] args) {
        runTests();
    }

    /**
     * Placeholder for your implementation.
     * Implement this method in a real-world coding interview scenario.
     *
     * @param n Non-negative integer
     * @return Count of prime numbers less than n
     */
    public static int countPrimes(int n) {
        //if N is 0 or 1 or 2, then return 0, because 0 and 1 and 2 are Non-Prime Numbers
        if (n <= 2) return 0; //if we pass 2, then there are 0 Prime numbers that are less than 2

        //Create a boolean array and initialize it with true
        boolean isPrime[] = new boolean[n];
        for(int i=2;i<n;i++){
            isPrime[i] = true;
        }

        //Start with 2 and make all multiples of 2 as Non-Prime
        //then i++, start with 3, and make all multiple of 3 non-prime
        int primeCount=0;
        for(int i=2;i<n;i++){
            if(isPrime[i]){ //if current number is prime
                primeCount++;
                //then find out all multiples of i, and make them non-prime
                //2 4 6 8 10..  (2*mul)
                //3 6 9 12... (3*a
                int mulFactor = 1;
                while(i*mulFactor < n){
                    isPrime[i*mulFactor] = false;
                    mulFactor++;
                }
            }
        }
        return primeCount; // placeholder return
    }

    /**
     * Runs predefined test cases and prints results with PASS/FAIL status
     */
    public static void runTests() {
        test(10, 4);
        test(0, 0);
        test(1, 0);
        test(20, 8);
        test(100, 25);
    }

    /**
     * Utility method to compare actual vs expected and print status
     */
    public static void test(int input, int expected) {
        int actual = countPrimes(input);
        if (actual == expected) {
            System.out.printf("Input: %d | Expected: %d | Actual: %d | PASS ✅\n", input, expected, actual);
        } else {
            System.out.printf("Input: %d | Expected: %d | Actual: %d | FAIL ❌\n", input, expected, actual);
        }
    }

    /**
     * Brute-force approach (for learning purposes)
     */
    public static int countPrimesBruteForce(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    /**
     * Helper method to check if a number is prime
     */
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    /**
     * Optimized approach using Sieve of Eratosthenes
     */
    public static int countPrimesOptimized(int n) {
        if (n <= 2) return 0;
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean prime : isPrime) {
            if (prime) count++;
        }
        return count;
    }
}
