import java.util.*;

/**
 * Created by sukai on 3/3/16.
 */
public class Solution {

    /*
    Return: ["0->2","4->5","7"]
     */
    public static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<String>();
        if (nums.length == 0) {
            return ranges;
        }
        int index, left;
        index = left = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (index == nums[i]-1) {
                index++;
            } else if (left == index) {
                ranges.add(left + "");
                left = index = nums[i];
            } else {
                ranges.add(left + "->" + index);
                left = index = nums[i];
            }
        }
        if (index == left) {
            ranges.add(left + "");
        } else {
            ranges.add(left + "->" + index);
        }
        return ranges;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1,2, 4, 5, 7};
        List<String> ranges = summaryRanges(nums);
        for (int i=0; i<ranges.size(); i++) {
            System.out.println(ranges.get(i));
        }
    }
}
