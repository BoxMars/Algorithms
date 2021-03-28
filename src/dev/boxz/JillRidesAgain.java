package dev.boxz;

import java.util.Scanner;

public class JillRidesAgain {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num=in.nextInt ();
        String answer="";
        for (int i=0;i<num;i++){
            int stopsNum=in.nextInt ();
            int[] niceSet=new int[stopsNum-1];
            for (int j=0;j<niceSet.length;j++){
                niceSet[j]=in.nextInt ();
            }
            answer+=Solution (niceSet,i);
        }
        System.out.println (answer);
    }
    /**
     *
     * @see <a href="https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=7&page=show_problem&problem=448">JillRidesAgain</a>
     */
    static String Solution(int[] niceSet,int no){
        int len=niceSet.length;
        int[][] dp=new int[len][len];

        for (int l=0;l<len;l++){
            for (int i=0;i+l<len;i++){
                if (l==0){
                    dp[i][i+l]=niceSet[i];
                }
                else dp[i][i+l]=dp[i][i+l-1]+dp[i+l][i+l];
            }
        }

        int max=niceSet[0];
        int x=0;
        int y=0;

        for (int i=0;i<len;i++){
            for (int j=i; j<len;j++){
                if (dp[i][j]>=max){
                    max=dp[i][j];
                    x=i;
                    y=j;
                }
            }
        }

        if (max<=0){
            return "Route "+(no+1)+" has no nice parts\n";
        }
        else return "The nicest part of route "+(no+1)+" is between stops "+(x+1)+" and "+(y+2)+"\n";
    }

}
