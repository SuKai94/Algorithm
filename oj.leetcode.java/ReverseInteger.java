
public class Solution {

    public static int reverse(int x) {
        String str = String.valueOf(x);
        String r_str = new StringBuffer(str).reverse().toString();
        int ans = 0, flag=0;
        if (str.charAt(0) == '-') {
            r_str = r_str.substring(0, r_str.length()-1);
            flag = 1;
        }
        try {
            ans = Integer.valueOf(r_str);
        } catch (Exception e) {
            ans = 0;
        }
        if (flag == 1) {
            ans = 0-ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
