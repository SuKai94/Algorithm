import java.util.*;
import java.io.*;

public class Main {

    public static PrintWriter out = new PrintWriter(new PrintStream(System.out));
    public static FastScanner cin = new FastScanner();
    public static int MAXN = 100 + 10;
    public static int MAXM = 100000 + 10;
    public static int[] dp = new int[MAXM];
    public static int[] v = new int[MAXN];
    public static int[] w = new int[MAXN];
    public static int n, m;

    /**
     * 完全背包问题(注意和 0/1背包的区别)
     * @param args
     */
    public static void main(String[] args) {

        while (cin.hasNext()) {
            n  = cin.nextInt();
            Arrays.fill(dp, 0);
            for (int i=0; i<n ;i++) {
                v[i] = cin.nextInt();
                w[i] = cin.nextInt();
            }
            m = cin.nextInt();
            for (int i=0; i<n; i++) {
                for (int j=0; j<=m; j++) {
                    if (j >= w[i]) {
                        dp[j] = Math.max(dp[j-w[i]]+v[i], dp[j]);
                    }
                }
            }
            out.println(dp[m]);
        }
        out.close();
    }
}

class FastScanner {

    public BufferedReader br;
    public StringTokenizer st;

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastScanner(String name) {
        try {
            br = new BufferedReader(new FileReader(name));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean hasNext() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public String nextToken() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() {
        return Double.parseDouble(nextToken());
    }
}