/**
https://www.geeksforgeeks.org/ugly-numbers/
https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
https://www.geeksforgeeks.org/program-nth-catalan-number/

**/
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

}
