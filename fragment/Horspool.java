public class Solution {
    /**
     * 字符串匹配Horspool算法
     * 平均复杂度O(n)，最差O(nm)
     */

    public String P, T;
    public int[] table = new int[256];

    public Solution(String P, String T) {
        this.P = P;
        this.T = T;
        ShiftTable();
    }

    public void ShiftTable() {
        for (int i = 0; i < table.length; i++) {
            table[i] = P.length();
        }
        for (int j = 0; j < P.length() - 1; j++) {
            table[P.charAt(j)] = P.length() - j - 1;
        }
    }

    public int HorspoolMatching() {
        int m = P.length();
        int n = T.length();
        int i = m - 1;
        while (i <= n - 1) {
            int k = 0;
            while (k <= m - 1 && P.charAt(m - 1 -k) == T.charAt(i- k)) {
                k += 1;
            }
            if (k == m) {
                return i - m + 1;
            } else {
                i = i + table[T.charAt(i)];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String P = "DJKG";
        String T = "ABDFDJKGSDP";
        Solution oo = new Solution(P, T);
        System.out.println(oo.HorspoolMatching());
    }
}
