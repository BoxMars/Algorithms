/**
 * https://leetcode-cn.com/problems/decode-ways/
 */

package dev.boxz;

public class DecodeWays {
    public static int Solution(String s){
        int[] dp=new int[s.length ()];
        if (s.charAt (0)=='0'){
            return 0;
        }
        dp[0]=1;

        for (int i=1;i<s.length ();i++){
            if (s.charAt (i)=='0'){
                if (s.charAt (i-1)!='1' && s.charAt (i-1)!='2'){
                    return 0;
                }
                dp[i]=i==1?i:dp[i-2];
            }
            else if (s.charAt (i-1)=='1'|| (s.charAt (i-1)=='2' && (int)s.charAt (i)-48<=6)){
                dp[i]=i==1?dp[i-1]:dp[i-1]+dp[i-2];
            }
            else {
                dp[i]=i==1?1:dp[i-1];
            }
        }

        return dp[s.length ()-1];
    }
}
