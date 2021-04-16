package dev.boxz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
public class Test {

    public static void main (String[] args) {
        String S="WWRWWWRWR";
        int ans=1000000000;
        int[] a=new int[S.length ()];
        for (int i=0;i<S.length ();i++){
            if (S.charAt (i)=='W'){
                a[i]=0;
            }
            else {
                a[i]=1;
            }
        }
        int[] dp=new int[S.length ()];
//        ArrayList<Integer> maxIndex= new ArrayList<> ();
        int maxIndex=0;
        int maxLength=1;
        if (a[0]==1){
            dp[0]=1;
        }
        else {
            dp[0]=0;
        }
        for (int i=1;i<S.length ();i++){
            if (a[i]==1){
                dp[i]=1;
            }
            else {
                dp[i]=0;
            }

            if (a[i]==1&&a[i-1]==1){
                dp[i]=dp[i-1]+1;
            }
            if (maxLength<dp[i]){
                maxIndex=i;
                maxLength=dp[i];
            }

        }
            int tans=0;
            for (int i=0;i<S.length ();i++){
            if (a[i]==1 && (i<maxIndex-maxLength+1)){
                tans+=maxIndex-maxLength-i;
                maxLength+=1;
            }
            if (a[i]==1&&(i>maxIndex)){
                tans+=i-maxIndex-1;
                maxIndex+=1;
                maxLength+=1;
            }

        }


//        for (int i=0;i<S.length ();i++){
//            if (a[i]==1 && (i<maxIndex-maxLength+1)){
//                ans+=maxIndex-maxLength-i;
//                maxLength+=1;
//            }
//            if (a[i]==1&&(i>maxIndex)){
//                ans+=i-maxIndex-1;
//                maxIndex+=1;
//                maxLength+=1;
//            }
//        }

        System.out.println (ans);
    }


}
