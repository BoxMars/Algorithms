package dev.boxz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Box
 * @see <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">Letter Combinations of a Phone Number</a>
 */
public class LetterCombinationsOfaPhoneNumber {

    public static void main (String[] args) {

        String digits = "23";

        System.out.println (new LetterCombinationsOfaPhoneNumber ().letterCombinations (digits));
    }

    String digits;

    List<String> ans=new ArrayList<> ();
    String tAns="";

    public List<String> letterCombinations(String digits) {
        this.digits=digits;
        if (digits==null){
            return ans;
        }
        dfs (0,"");
        return ans;
    }

    void dfs(int index,String ans){
        if (index==digits.length ()){
            this.ans.add (ans);
        }
        else {
            String alphabet=getAlphabet ((( int ) digits.charAt (index)-'0'));
            for (int i = 0; i < alphabet.length (); i++) {
                char c=alphabet.charAt (i);
                dfs (index+1,ans+c);
            }
        }
    }

    String getAlphabet(int num){
        if (num==2){
            return "abc";
        }
        if (num==3){
            return "dfe";
        }
        if (num==4){
            return "ghi";
        }
        if (num==5){
            return "jkl";
        }
        if (num==6){
            return "mno";
        }
        if (num==7){
            return "pqrs";
        }
        if (num==8){
            return "tuv";
        }
        if (num==9){
            return "wxyz";
        }
        return "";
    }
}
