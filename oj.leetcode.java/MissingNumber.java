import java.util.Arrays;

public class Solution {

    public static int[] primes = {2,3,5};

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int cur=0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]!=cur++) {
                break;
            }
        }
        if (cur-1 == nums[nums.length-1]) {
            return cur;
        }
        return cur-1;
    }

    public static void main(String[] args) {
        int[] nums={1};
        System.out.println(missingNumber(nums));
    }
}