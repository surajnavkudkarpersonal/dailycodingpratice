/**
This problem was asked by Stripe.
Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
You can modify the input array in-place.
https://leetcode.com/problems/first-missing-positive/
**/

class Day4 {
    public int firstMissingPositive(int[] nums) {
        HashSet < Integer > positiveNumbers = new HashSet < Integer > ();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                positiveNumbers.add(nums[i]);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!positiveNumbers.contains(i + 1))
                return i + 1;
        }

        return -1;
    }
}
