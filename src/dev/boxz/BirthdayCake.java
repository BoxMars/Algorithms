package dev.boxz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class BirthdayCake {

    public static void main (String[] args) {

        long startTime=System.currentTimeMillis();
        Scanner scanner=new Scanner (System.in);
//        int n=scanner.nextInt ();
        int n=40000;
        ArrayList<String> arrayList=new ArrayList<> ();
        for (int i = 0; i < n; i++) {
//            arrayList.add (scanner.next ());
            arrayList.add ("adsad");
        }
        int ans=0;
        HashSet<String> ansSet=new HashSet ();
        for (int i = 0; i < arrayList.size ()-1; i++) {
            for (int j = i+1; j < arrayList.size (); j++) {
                String newStr= arrayList.get (i)+arrayList.get (j);
                if (ansSet.contains (newStr)){
                    ans+=1;
                }
                else if (isHalf (newStr)){
                    ans+=1;
                    ansSet.add (newStr);
                }
            }
        }
        System.out.println (ans);
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

    }
    static boolean isHalf(String str){
        if (str.length ()%2!=0){
            return false;
        }
        String newStr=str.substring (str.length ()/2);
        boolean res=(str.equals (newStr+newStr));
        return res;
    }
}
