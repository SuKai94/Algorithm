import java.util.*;
import java.io.*;

public class Main {

    public static PrintWriter out = new PrintWriter(new PrintStream(System.out));
    public static FastScanner cin = new FastScanner();
    public static int MAXN = 20 + 10;
    public static int MAXK = 20 + 10;
    public static int MAXW = 1000 + 10;
    public static int[][] dp = new int[MAXK][MAXW];
    public static int[] a = new int[MAXN];
    public static int[] b = new int[MAXN];
    public static int n, k, cases, w;

    /**
     * 完全背包问题(注意和 0/1背包的区别)
     * @param args
     */
    public static void main(String[] args) {
        cases = cin.nextInt();
        while (cases-- != 0) {
            n = cin.nextInt();
            k = cin.nextInt();
            for (int x=0; x<MAXK; x++) {
                for (int y=0; y<MAXW; y++) {
                    dp[x][y] = 0;
                }
            }
            for (int i=0; i<n ;i++) {
                a[i] = cin.nextInt();
                b[i] = cin.nextInt();
            }
            w = cin.nextInt();
            for (int i=0; i<n; i++) {
                for (int x=k; x>=0; x--) {
                    for (int y=w; y>=0; y--) {
                        if (x-1>=0 && y-b[i]>=0) {
                            dp[x][y] = Math.max(dp[x][y], dp[x-1][y-b[i]]+a[i]);
                        }
                    }
                }
            }
            out.println(dp[k][w]);
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