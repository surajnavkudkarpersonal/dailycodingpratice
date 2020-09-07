/**
https://leetcode.com/problems/coin-change-2/
**/


class Day10 {
    public int change(int amount, int[] coins) {
       
    }
    
    private int coinCount(int amount, int length,int[] coins){
       
        if(amount==0)
            return 1;
        
        if(amount<=0 || (length<=0 && amount>=1))
            return 0;
        
        return coinCount(amount,length-1,coins) + coinCount(amount-coins[length-1],length,coins);
    }

     public int changeDp2D(int amount, int[] coins) {
       int n = coins.length; 
       int[][] dp = new int[n+1][amount+1];
        
        for(int i=0;i<=amount;i++)
            dp[0][i]=0;
        
        for(int i=0;i<=n;i++)
            dp[i][0]=1;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(j>=coins[i-1]){
                	// icluded and exluding current 
                   dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j]; 
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        return dp[n][amount];
    }

    public int changeDp1D(int amount, int[] coins) {
       Arrays.sort(coins); 
       int n = coins.length; 
       int dp[]=new int[amount+1]; 
  
      dp[0] = 1; 
  
    for(int i=0; i<n; i++) 
        for(int j=coins[i]; j<=amount; j++) 
            dp[j] += dp[j-coins[i]]; 
  
    return dp[amount]; 
    }
}