

public class Solution {

    public static int titleToNumber(String s) {
        int number=0;
        /*
        A 1
        Z 26
        AA 26+1
        AB 26+2
        AZ 26+26=52
         */
        for (char c: s.toCharArray()) {
            number = number*26+(c-'A'+1);
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("BA"));
    }
}