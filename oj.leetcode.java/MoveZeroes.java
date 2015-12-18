
public class Solution {

    public static void print(int[] nums) {
        for (int i=0 ;i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void moveZeroes(int[] nums) {
        int count=0,j=0;
        for (int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                count++;
                if (i==0) {
                    continue;
                }
                for (j=i-1; j>=0; j--) {
                    if (nums[j]!=0 && nums[j]!= -1) {
                        break;
                    }
                }
                if (j==0 && nums[j]==0) {
                    nums[j]=nums[i];
                    if (i!=j) {
                        nums[i] = -1;
                    }
                } else {
                    nums[j+1] = nums[i];
                    if (j+1 != i) {
                        nums[i] = -1;
                    }
                }
            }
        }

        for (int i=count; i<nums.length; i++) {
            nums[i]=0;
        }
    }

    /*
    public void moveZeroes(int[] nums) {
        int n = nums.length, i=0,j=0;
        while(true){
            for(;i<n && nums[i]!=0;i++); //find next zero
            for(;j<n && nums[j]==0;j++); //find next non-zero

            if(i==n || j==n) return;

            if(j>i){      // if zero before non-zero then swap it
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }else   j++;  // if zero after non-zero then non-zero is in appropritate place, just increment non-zero index
        }
    }
    */

    public static void main(String[] args) {
        int[] nums = {0,1,2,3};
        moveZeroes(nums);
        print(nums);
    }

}