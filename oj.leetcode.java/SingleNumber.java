import java.util.Arrays;

public class Solution {

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int count=1, res=nums[0], pre=nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == pre) {
                count++;
            } else {
                if (count == 1) {
                    return pre;
                } else {
                    pre = nums[i];
                    count=1;
                }
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] nums={1,1,2,3,3};
        System.out.println(singleNumber(nums));
    }
}