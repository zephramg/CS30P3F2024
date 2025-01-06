/* Explanation:

sumOfProperDivisors(int num):

This function calculates the sum of all proper divisors of a given number.
It iterates from 1 to num / 2 and checks if each number i is a divisor of num.
- If i is a divisor, it adds i to the sum.


findAmicablePairs(int limit):

This function finds all amicable pairs within the given limit.
It creates an array divisorSums to store the sum of proper divisors for each number up to the limit.
It iterates through numbers from 1 to limit:
For each number i, it retrieves the sum of its proper divisors (j) from the divisorSums array.
It checks if:
- j is within the limit.
- i and j are different numbers.
- The sum of proper divisors of j is equal to i (indicating an amicable pair).

If all conditions are met, it adds the pair {i, j} to the pairs list.


main(String[] args):

- Sets the limit for the search.
- Calls findAmicablePairs() to find the amicable pairs.
- Prints the found amicable pairs to the console.

Key Improvements:
- Efficient Divisor Sum Calculation: The divisorSums array significantly improves performance by pre-calculating and storing divisor sums, avoiding redundant calculations.
 
*/ 
package other;

import java.util.ArrayList;
import java.util.List;

public class AmicableNumbers {

    public static int sumOfProperDivisors(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static List<int[]> findAmicablePairs(int limit) {
        List<int[]> pairs = new ArrayList<>();
        int[] divisorSums = new int[limit + 1]; 

        for (int i = 1; i <= limit; i++) {
            divisorSums[i] = sumOfProperDivisors(i);
        }

        for (int i = 1; i <= limit; i++) {
            int j = divisorSums[i];
            if (j <= limit && i != j && divisorSums[j] == i) {
                pairs.add(new int[]{i, j});
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        int limit = 10000; // Adjust the limit as needed
        List<int[]> amicablePairs = findAmicablePairs(limit);

        System.out.println("Amicable Pairs within " + limit + ":");
        for (int[] pair : amicablePairs) {
            System.out.println(pair[0] + " - " + pair[1]);
        }
    }
}