/**
This problem was recently asked by Google.
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
Bonus: Can you do this in one pass?
https://leetcode.com/problems/two-sum/
**/
import java.util.*;

class Day1 {

public int[] twoSumBrute(int[] nums, int target) {
	for (int i = 0; i < nums.length - 1; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                return new int[] {i,j};    
            }
    	}
	}	

	return null;

}

 public int[] twoSum(int[] nums, int target) {
     Map<Integer,Integer> searchMap= new HashMap();
     
     for(int i=0 ; i<nums.length; i++) {
        int diff = target-nums[i];
         
        if(searchMap.containsKey(diff)) 
             return new int[] {searchMap.get(diff),  i };
         searchMap.put(nums[i],i);
     }
     
     return null;
 }

public int[] twoSumSorted(int[] nums, int target) {
	int i= 0 ;
        int j = nums.length-1; 
        while(i < j) {
            if(nums[i]+nums[j]==target)
                return new int[]{++i,++j};
            else if(nums[i]+nums[j]<target)
                i++;
            else
				j--;
    }

	return null;
}

    
}
