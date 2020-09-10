class Day14 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] txt1=text1.toCharArray(); 
        char[] txt2=text2.toCharArray(); 
        
        int l1 = txt1.length; 
        int l2 = txt2.length; 
        int[][] dp = new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++) {
             for(int j=0;j<=l2;j++) {
                 if(i==0 || j==0) {
                     dp[i][j]=0;
                 } else if(txt1[i-1]==txt2[j-1]) {
                    dp[i][j]=1+dp[i-1][j-1]; 
                 } else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]); 
                 }
             }
        }
        
        return dp[l1][l2];
    }
}
