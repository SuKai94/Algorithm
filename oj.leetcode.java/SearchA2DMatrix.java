
public class Solution {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        for (int i=0; i<matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length-1]) {
                row = i;
                break;
            }
        }
        int n=matrix[row].length;
        int i=0, j=n-1;
        while (i<=j) {
            if (target > matrix[row][(i+j)/2]) {
                i = (i+j)/2 + 1;
            } else if (target < matrix[row][(i+j)/2]) {
                j = (i+j)/2 - 1;
            } else {
                return true;
            }
        }
        return  false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,40}};
        System.out.println(searchMatrix(matrix, 11));
    }

}