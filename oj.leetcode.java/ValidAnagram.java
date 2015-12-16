
/*
低位优先的字符串排序
 */
public class Solution {

    public static boolean isAnagram(String s, String t) {
        int[] allChars = new int[256];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i=0; i<s.length(); i++) {
            allChars[s.charAt(i)]++;
            allChars[t.charAt(i)]--;
        }
        for (int i=0; i<256; i++) {
            if (allChars[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("aab", "aba"));
    }

}