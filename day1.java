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
