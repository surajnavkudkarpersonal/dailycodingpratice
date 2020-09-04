import java.math.BigInteger;

public class Day9 {
    public static int permutationCoeff(int n, int k) {

        int[] fact = new int[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = i * fact[i - 1];
        }
        return fact[n] / fact[n - k];
    }

    public static int permutationCoeffV2(int n, int k) {
        int fk = 1;
        int fn = 1;

        for (int i = 1; i <= n; i++) {
            fn *= i;
            if (i == (n - k)) fk = fn;
        }
        return fn / fk;
    }

    public static int binomialCoeff(int n, int k) {

        int[] fact = new int[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = i * fact[i - 1];
        }
        return fact[n] / (fact[n - k] * fact[k]);
    }

    public static int binomialCoeffV2(int n, int k) {
        int fnk = 1;
        int fn = 1;
        int fk = 1;

        for (int i = 1; i <= n; i++) {
            fn *= i;
            if (i == k) fk = fn;
            if (i == (n - k)) fnk = fn;
        }
        return fn / (fnk * fk);
    }

    public int numTrees(int n) {
        BigInteger f2n = new BigInteger("1");
        BigInteger fn = new BigInteger("1");
        BigInteger fn1 = new BigInteger("1");

        for (int i = 1; i <= 2 * n; i++) {
            f2n = f2n.multiply(BigInteger.valueOf(i));
            if (i == n) fn = f2n;
            if (i == (n + 1)) fn1 = f2n;
        }



        return (f2n.divide(fn1.multiply(fn))).intValue();
    }


}

