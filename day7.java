/**
This problem was asked by Facebook.
Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
You can assume that the messages are decodable. For example, '001' is not allowed.
https://leetcode.com/problems/decode-ways/
**/

class Day7 {
    public int numDecodingsIteration(String s) {

        int dw[] = new int[s.length() + 1];
        dw[0] = 1;
        dw[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1)
                dw[i] += dw[i - 1];

            if (twoDigit >= 10 && twoDigit <= 26)
                dw[i] += dw[i - 2];
        }

        return dw[s.length()];
    }

    public int numDecodingsRecursion(String s) {

        return countDecoding(s.toCharArray(), s.length());
    }

    int countDecoding(char[] digits, int n) {

        if (digits[0] == '0')
            return 0;

        if (n == 0 || n == 1)
            return 1;


        int count = 0;


        if (digits[n - 1] > '0')
            count = countDecoding(digits, n - 1);


        if (digits[n - 2] == '1' ||
            (digits[n - 2] == '2' && digits[n - 1] < '7'))
            count += countDecoding(digits, n - 2);

        return count;

    }
}