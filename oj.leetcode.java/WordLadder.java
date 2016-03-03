import java.util.*;

/**
 * Created by sukai on 3/3/16.
 */
public class Solution {

    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        HashMap<String, Integer> lens = new HashMap<String, Integer>();
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        lens.put(beginWord, 1);
        while (!q.isEmpty()) {
            String wordStr = q.poll();
            char[] word = wordStr.toCharArray();
            for (int i=0; i<word.length; i++) {
                char temp = word[i];
                for (char c='a'; c!='z'; c++) {
                    int step = lens.get(wordStr)+1;
                    if (temp == c) {
                        continue;
                    } else {
                        word[i] = c;
                        String str = new String(word);
                        if (str.equals(endWord)) {
                            return step;
                        }
                        if (wordList.contains(str) && !lens.containsKey(str)) {
                            q.offer(str);
                            lens.put(str, step);
                        }
                        word[i] = temp;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        Set<String> wordList = new HashSet<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
