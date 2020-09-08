/**
https://www.geeksforgeeks.org/ugly-numbers/
https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
https://www.geeksforgeeks.org/program-nth-catalan-number/
**/
import java.lang.Math; 
class Day8 {
    public int fibRecur(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);

    }

    public int fibIterate(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }

     public int fib(int n) 
    { 
        int a = 0, b = 1, c; 
        if (n == 0) 
            return a; 
        for (int i = 2; i <= n; i++) 
        { 
            c = a + b; 
            a = b; 
            b = c; 
        } 
        return b; 
    } 

    public int numTreesRecur(int n) {
        int output = 0;
        if (n <= 1) return 1;

        for (int i = 0; i < n; i++) {
            output += numTrees(i) * numTrees(n - i - 1);
        }

        return output;
    }

    public int numTrees(int n) {
        int[] output = new int[n + 1;
        output[0] = 1;
        output[1] = 1;
        for (int i = 2; i <= n; i++) {
            output[i] = 0;
            for (int j = 0; j < i; j++) {
                output[i] += output[j] * output[i - j - 1];
            }
        }

        return output[n];
    }

     public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int ia = 0;
        int ib = 0;
        int ic = 0;
        int nextMutipleofA = 2;
        int nextMutipleofB = 3;
        int nextMutipleofC = 5;
        int nextUglyNo = 1;

        for (int i = 1; i < n; i++) {

            nextUglyNo = Math.min(nextMutipleofA, Math.min(nextMutipleofB, nextMutipleofC));
            dp[i] = nextUglyNo;

            if (nextUglyNo == nextMutipleofA) {
                ia++;
                nextMutipleofA = dp[ia] * 2;
            }
            if (nextUglyNo == nextMutipleofB) {
                ib++;
                nextMutipleofB = dp[ib] * 3;
            }
            if (nextUglyNo == nextMutipleofC) {
                ic++;
                nextMutipleofC = dp[ic] * 5;
            }

        }

        return nextUglyNo;
    }

}
