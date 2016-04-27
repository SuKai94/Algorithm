
public class Solution {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergenum = new int[m+n];
        int i = 0, j = 0, t = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                mergenum[t++] = nums1[i];
                i++;
            } else {
                mergenum[t++] = nums2[j];
                j++;
            }
        }
        while (i < m) {
            mergenum[t++] = nums1[i++];
        }
        while (j < n) {
            mergenum[t++] = nums2[j++];
        }
        for (int h=0; h < mergenum.length; h++) {
            nums1[h] = mergenum[h];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,4,6};
        int[] nums2 = {2,3,7};
        merge(nums1, 3, nums2, 3);
        for (int i=0; i<nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}
