import java.util.Random;

/**
 * 509. Fibonacci Number. 
 * Problem from LeetCode https://leetcode.com/problems/fibonacci-number/
 * 
 * This problem is in the array section because it can be solved using an array
 * with the method Memoization, which is a method to save previous results if we
 * need them later, saving computing time.
 */
class FibonacciNumber {

    public static void main(String[] args) {
        /* Generate input. */
        int input = new Random().nextInt(31);
        System.out.println("N = " + input);
        int output = fib(input);
        System.out.println("F(N) = " + output);
    }

    public static int fib(int N) {
        int[] results = new int[N+1];
        results[0] = 0;
        results[1] = 1;
        return fibAux(N, results);
    }

    private static int fibAux(int N, int[] results) {
        if(N == 0) {
            return 0;
        }
        if(results[N] == 0) {
            int res = fibAux(N-1, results) + fibAux(N-2, results);
            results[N] = res;
            return res;
        } else {
            return results[N];
        }
    }
}