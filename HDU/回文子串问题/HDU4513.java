import java.util.*;
import java.io.*;

public class Main {

    public static PrintWriter out = new PrintWriter(new PrintStream(System.out));
    public static FastScanner cin = new FastScanner();
    public static int MAXLEN = 100010;
    public static int k=1, mx=0, id=0, ans=0, T, n;
    public static int[] str = new int[MAXLEN*2];
    public static int[] h = new int[MAXLEN];
    public static int[] p = new int[MAXLEN*2];

    /*
    最长回文子串, manacher算法的应用
    题目连接: http://acm.hdu.edu.cn/showproblem.php?pid=4513
    参考: http://www.felix021.com/blog/read.php?2040
     */
    public static void main(String[] args) {
        T = cin.nextInt();
        while (T-- != 0) {
            n = cin.nextInt();
            Arrays.fill(h, 0);
            Arrays.fill(p ,0);
            Arrays.fill(str, 0);
            for (int i=0; i<n; i++) {
                h[i] = cin.nextInt();
            }
            str[0] = -2;
            k=1;
            mx = id = ans = 0;
            for (int i=0; i<n; i++) {
                str[k++] = -1;
                str[k++] = h[i];
            }
            str[k++] = -1;
            for (int i=1; i<k; i++) {
                p[i] = mx>i ? Math.min(p[2*id-i], mx-i) : 1;
                // 注意这里的循环条件, 比普通的manacher多一个条件: str[i-p[i]]<=str[i-p[i]+2]
                while (str[i+p[i]] == str[i-p[i]] && str[i-p[i]]<=str[i-p[i]+2]) {
                    p[i]++;
                }
                if (i+p[i] > mx) {
                    mx = i+p[i];
                    id = i;
                }
                if (ans < p[i]) {
                    ans = p[i];
                }
            }
            out.println(ans-1);
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

    public String nextString() {
        return String.valueOf(nextToken());
    }
}
