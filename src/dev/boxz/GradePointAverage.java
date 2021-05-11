package dev.boxz;

import java.util.ArrayList;
import java.util.Scanner;

public class GradePointAverage {

    public static void main (String[] args) {
        Scanner scanner=new Scanner (System.in);
        int n=scanner.nextInt ();
        int k=scanner.nextInt ();
        int total=0;
        for (int i = 0; i < n; i++) {
            total+=scanner.nextInt ();
        }
        System.out.println (solution (total,n,k));
    }

    static String solution(int total, int n, int k){
        int res=total%n;
        String ans=Integer.toString (total/n)+".";
        for (int i = 0; i < k; i++) {
            int num=res*10;
            res=num%n;
            ans+=num/n;

        }
        return ans;
    }
}
