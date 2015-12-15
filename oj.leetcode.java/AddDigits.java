/**
 * Created by sukai on 12/15/15.
 */
public class Solution {

    public static int[] nums = {1,2,3};

    public static int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        if (num%9 == 0) {
            return 9;
        }
        return num%9;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(2));
    }
}
