/**
This problem was asked by Stripe.
Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
You can modify the input array in-place.
https://leetcode.com/problems/first-missing-positive/
https://www.youtube.com/watch?v=9SnkdYXNIzM
**/

class Day4 {
    // Set splution
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> positiveNumbers = new HashSet<Integer>();
        for(int i=0 ;i<nums.length;i++){
            if(nums[i]>0)
                positiveNumbers.add(nums[i]);
        }
        
       for(int i=1 ;i<=nums.length;i++){
            if(!positiveNumbers.contains(i))
                return i;
        }
        
        return nums.length+1;   
    }


    // Array solution
     public int firstMissingPositiveArray(int[] nums) {
      boolean[] isNumberPresent = new boolean[nums.length+1];
        for(int i=0; i<nums.length; i++) {
            if(nums[i]>0 && nums[i]<=nums.length) 
                isNumberPresent[nums[i]] = true;
        }
        
        for(int i=1; i<=nums.length;i++){
            if(!isNumberPresent[i])
                return i;
        }
        
        return nums.length+1;
        
    }

     public int firstMissingPositiveBest(int[] nums) {
     if(nums==null || nums.length==0)
         return 1;
        
      int n = nums.length;
        
      boolean containsOne = false;
      
      for(int i=0; i<n ;i++) {
          if(nums[i]==1)
              containsOne=true;
          else if(nums[i]<=0 || nums[i]>n)
              nums[i] = 1;
      }  
      
      if(!containsOne)
          return 1;
        
      for(int i=0; i<n; i++) {
          int index = Math.abs(nums[i])-1;
          if(nums[index]>0)
              nums[index]*=-1;
      }
        
       for(int i=0; i<n; i++) {
           if(nums[i]>0)
               return i+1;
       }
            
      return n+1;      
        
    }
}
