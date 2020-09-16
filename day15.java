import static java.lang.Math.*;
public class Day15 {
    public static void main(String args[]) {
     String X = "AGGT12"; 
        String Y = "12TXAYB"; 
        String Z = "12XBA"; 
      System.out.println("Length of LCS is " + 
                                lcsOf3(X, Y,Z)); 
    }
    
     public static int lcsOf3(String text1, String text2, String text3) {
        char[] txt1=text1.toCharArray(); 
        char[] txt2=text2.toCharArray(); 
        char[] txt3=text3.toCharArray(); 
        
        int l1 = txt1.length; 
        int l2 = txt2.length; 
        int l3 = txt3.length; 
        int[][][] dp = new int[l1+1][l2+1][l3+1];
        for(int i=0;i<=l1;i++) {
             for(int j=0;j<=l2;j++) {
                 for(int k=0;k<=l3;k++) {
                     if(i==0 || j==0 || k==0) {
                         dp[i][j][k]=0;
                     } else if(txt1[i-1]==txt2[j-1] && txt1[i-1]==txt3[k-1]) {
                        dp[i][j][k]=1+dp[i-1][j-1][k-1]; 
                     } else{
                        dp[i][j][k] = Math.max(dp[i][j-1][k],Math.max(dp[i-1][j][k],dp[i][j][k-1])); 
                     }
                }
            }
        }
        
        return dp[l1][l2][l3];
    }
}