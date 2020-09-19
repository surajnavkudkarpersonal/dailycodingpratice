class Day17 {
    public int minPathSum(int[][] grid) {
        int m = grid.length-1;
        int n = grid[0].length-1;

        int i, j; 
        int dp[][]=new int[m+1][n+1]; 
  
        dp[0][0] = grid[0][0]; 
  
        
        for (i = 1; i <= m; i++) 
            dp[i][0] = dp[i-1][0] + grid[i][0]; 
  

        for (j = 1; j <= n; j++) 
            dp[0][j] = dp[0][j-1] + grid[0][j]; 
  
        
        for (i = 1; i <= m; i++)  {
            for (j = 1; j <= n; j++) {
            	// dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j], 
                 //              dp[i][j-1]) + grid[i][j]; 
                dp[i][j] = Math.min(dp[i-1][j], 
                               dp[i][j-1]) + grid[i][j]; 
            }
        }
  
        return dp[m][n]; 
    }

    public int minPathSumSingleloop(int[][] grid) {
        int m = grid.length-1;
        int n = grid[0].length-1;
 
        int dp[][]=new int[m+1][n+1];
  
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] +=grid[i][j];
                if(i>0 && j>0) {
                    dp[i][j]+=Math.min(dp[i-1][j], dp[i][j-1]) ;
                } else if(i>0) {
                    dp[i][j]+=dp[i-1][j];
                } else if(j>0) {
                    dp[i][j]+=dp[i][j-1];
                }  
            }
        }
  
        return dp[m][n]; 
    }

}
