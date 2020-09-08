import java.io.*;
import java.util.*;

public class Day12 {

    public static void main(String[] args) throws Exception {
         int n = 4; 
        System.out.println(countFriendsPairings(n)); 
    }
    
    static int countFriendsPair(int n) {
        int[] dp = new int[n+1];
        
        dp[0]=1;
        for(int i=1;i<=n;i++) {
            if(i<=2){
                dp[i]=i;
            }else{
                dp[i] = dp[i-1] + (i-1)*dp[i-2];
            }
        }
        return dp[n];
    }

    static int countFriendsPairOptimize(int n) {
        int a=1,b=1,c=0;
        
       if(n<=2)
         return n;
         
        for(int i=3;i<=n;i++) {
            
            c=a+((i-1)*b);
            a=b;
            b=c;
            
        }
        return c;
    }

}