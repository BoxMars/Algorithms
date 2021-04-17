package dev.boxz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Box
 * @see <a href="https://leetcode.com/problems/word-ladder-ii/">WordLadderII</a>
 */
public class WordLadderII {

    public static void main (String[] args) {

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans=new ArrayList<> ();
        if (!wordList.contains (endWord)){
            return null;
        }
        else {
            wordList.remove (endWord);
            wordList.add (endWord);
        }
        if (!wordList.contains (beginWord)){
            wordList.add (0,beginWord);
        }

        boolean[][] dp=new boolean[wordList.size ()][wordList.size ()];

        for (int i=0;i<wordList.size ()-1;i++){
            for (int j=i+1;j<wordList.size ();j++){
                if (isOneDiff (wordList.get (i),wordList.get (j))){
                    dp[i][j]=true;
//                    dp[j][i]=true;
                }
            }
        }

        for (int i=0;i<wordList.size ()-1;i++){
            for (int j=i+1;j<wordList.size ();j++){

            }
        }








        return null;
    }
    public boolean isOneDiff(String a, String b){
        int length=a.length ();
        int diff=0;
        for (int i=0;i<length;i++){
            if (a.charAt (i)!=b.charAt (i)){
                diff+=1;
            }
            if (diff>=2){
                return false;
            }
        }
        return diff==1;
    }

}
