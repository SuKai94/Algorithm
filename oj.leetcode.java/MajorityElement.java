import java.util.Arrays;

public class Solution {

    /*
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    */

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count=1, res=nums[0], flag=nums[0], maxCount=-1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i]==flag) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    res=flag;
                    if (maxCount > nums.length/2) {
                        return res;
                    }
                }
                flag=nums[i];
                count=1;
            }
        }
        if (count > maxCount) {
            res = flag;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }

}