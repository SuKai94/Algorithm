
/**
 * Created by sukai on 12/9/15.
 */
public class Main {


    public static int lengthOfLongestSubstring(String s) {
        int res=0, left=0;
        int[] map = new int[300];

        for (int i=0;i<300; i++) {
            map[i] = -1;
        }

        for (int i=0; i<s.length(); i++) {
            if (map[s.charAt(i)] >= left) {
                left = map[s.charAt(i)] + 1;
            }
            map[s.charAt(i)] = i;
            if (res <= i-left+1) {
                res = i-left+1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abdabcabcdbb"));
    }
}
