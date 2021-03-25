/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
package dev.boxz;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    public static String SolutionOne(String s){
        int len=s.length ();
        int[] res=new int[len];
        Arrays.fill (res,1);
        int max=1;
        for (int i=0;i<len;i++){
            int j=i+max;
            while (j<len){
                String sub=s.substring (i,j+1);
                String reverse=new StringBuffer (sub).reverse ().toString ();
                boolean b = sub.equals (reverse) && sub.length () > res[i];
                if (b){
                    res[i]=sub.length ();
                    max=Math.max (max,res[i]);
                }
                j++;
            }
        }
        int maxIndex=0;
        for (int i=0;i<len;i++){
            if (res[i]>res[maxIndex]){
                maxIndex=i;
            }
        }
        return s.substring (maxIndex,res[maxIndex]+maxIndex);
    }

    public static String SolutionTwo(String s){
        int len=s.length ();
        boolean[][] dp=new boolean[len][len];
        String ans="";
        for (int l=0;l<len;l++){
            for (int i=0;i+l<len;i++){
                int j=i+l;
                if (l==0){
                    dp[i][j]=true;
                }
                else if (l==1){
                    dp[i][j]=s.charAt (i)==s.charAt (j);
                }
                else {
                    dp[i][j]=(s.charAt (i)==s.charAt (j))&&dp[i+1][j-1];
                }
                if (dp[i][j]&&ans.length ()<l+1){
                    ans=s.substring (i,j+1);
                }
            }
        }
        return ans;
    }
}
