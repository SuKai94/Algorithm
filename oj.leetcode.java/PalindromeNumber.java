

public class Solution {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String num = String.valueOf(x);
        int i=0, j=num.length()-1;
        boolean res = true;
        while (i <= j) {
            if (num.charAt(i) != num.charAt(j)) {
                res=false;
                break;
            }
            i++;
            j--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-2147447412));
    }
}