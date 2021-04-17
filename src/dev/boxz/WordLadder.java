package dev.boxz;

import java.util.*;

/**
 * @author Box
 * @see <a href="https://leetcode.com/problems/word-ladder/">WordLadder</a>
 */
public class WordLadder {
    public static void main (String[] args) {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains (endWord)){
            return 0;
        }
        if (wordList.contains (beginWord)){
            wordList.remove (beginWord);
        }

        HashSet<String> visited=new HashSet<> ();
        Queue<String> queue=new LinkedList<> ();
        queue.add (beginWord);
        int depth=1;
        while (!queue.isEmpty ()){
            int length=queue.size ();
            for (int i=0;i<length;i++){
                String word=queue.poll ();
                if (isOneDiff (word,endWord)){
                    return depth+1;
                }
                for (int j=0;j<wordList.size ();j++) {
                    HashSet<String> temp = new HashSet<>();
                    temp.add (word);
                    temp.add (wordList.get (j));
                    if (!visited.contains (wordList.get (j))&&(isOneDiff (word,wordList.get (j)))){
                        queue.add (wordList.get (j));
                        visited.add (wordList.get (j));
                    }
                }

            }
            depth++;
        }

        return 0;
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
