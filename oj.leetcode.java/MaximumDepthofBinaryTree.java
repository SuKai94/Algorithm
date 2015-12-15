
public class Solution {

    private int depth = 0;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = 1+maxDepth(root.left);
        int right = 1+maxDepth(root.right);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

}