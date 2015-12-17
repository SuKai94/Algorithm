
public class Solution {

    public static void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean row=false, column=false;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        row=true;
                    } else if (j == 0) {
                        column = true;
                    } else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if ((i==0 && row==true) || (j==0 && column==true) || matrix[i][0]==0 || matrix[0][j]==0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,40}};
        setZeroes(matrix);
    }

}