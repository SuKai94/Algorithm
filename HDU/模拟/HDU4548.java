import java.util.*;
import java.io.*;

public class Main {

    public static PrintWriter out = new PrintWriter(new PrintStream(System.out));
    public static FastScanner cin = new FastScanner();
    public static int T, L, R;
    public static int MAXN = 1000000 + 10;
    public static int[] prime = new int[MAXN];
    public static int[] ans = new int[MAXN];

    /*
    素数数组 打表
     */
    public static void setPrime() {
        prime[0] = prime[1] = 1;
        for (int i=2; i<MAXN; i++) {
            if (prime[i] == 1) {
                continue;
            }
            for (int j=i+i; j<MAXN; j+=i) {
                prime[j] = 1;
            }
        }
    }

    /*
    dp思想 求答案
     */
    public static void setAns() {
        ans[0] = ans[1] = 0;
        for (int i=2; i<MAXN; i++) {
            if (prime[i]==0 && prime[setSum(i)]==0) {
                ans[i] = ans[i-1] +1;
            } else {
                ans[i] = ans[i-1];
            }
        }
    }

    public static int setSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number%10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        T = cin.nextInt();
        int cases=1;
        Arrays.fill(prime, 0);
        Arrays.fill(ans, 0);
        setPrime();
        setAns();
        while (T-- != 0) {
            L = cin.nextInt();
            R = cin.nextInt();
            out.println("Case #" + cases++ + ": " + (ans[R]-ans[L-1]));
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