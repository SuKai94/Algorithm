import java.util.Arrays;

/**
 * Created by sukai on 12/9/15.
 */
public class Main {

    static class Pair implements Comparable<Pair> {
        public int value, index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int compareTo(Pair b) {
            return this.value - b.value;
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Pair[] pairs = new Pair[len];
        int i, j, sum;
        for (i=0; i<len; i++) {
            pairs[i] = new Pair(nums[i], i+1);
        }
        Arrays.sort(pairs);
        int[] indexs = new int[2];

        for (i=0, j=len-1; i<j; ) {
            sum = pairs[i].value + pairs[j].value;
            if (sum == target) {
                indexs[0] = pairs[i].index;
                indexs[1] = pairs[j].index;
                if (indexs[0] > indexs[1]) {
                    indexs[0] ^= indexs[1];
                    indexs[1] ^= indexs[0];
                    indexs[0] ^= indexs[1];
                }
                break;
            } else if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            }
        }

        return indexs;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        int target = -8;
        int[] indexs = twoSum(nums, target);
        System.out.println(indexs[0] + " " + indexs[1]);
    }
}
