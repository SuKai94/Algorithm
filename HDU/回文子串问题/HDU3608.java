import java.util.*;
import java.io.*;

public class Main {

    public static PrintWriter out = new PrintWriter(new PrintStream(System.out));
    public static FastScanner cin = new FastScanner();
    public static int MAXLEN = 110000 * 2;
    public static int k=1, mx=0, id=0, ans=0;
    public static char[] str = new char[MAXLEN];
    public static int[] p = new int[MAXLEN];

    /*
    最长回文子串
    manacher算法
    参考: http://www.felix021.com/blog/read.php?2040
     */
    public static void main(String[] args) {
        while (cin.hasNext()) {
            String s = cin.nextString();
            Arrays.fill(p ,0);
            str[0] = '$';
            k=1;
            mx = id = ans = 0;
            for (int i=0; i<s.length(); i++) {
                str[k++] = '#';
                str[k++] = s.charAt(i);
            }
            str[k++] = '#';
            for (int i=1; i<k; i++) {
                p[i] = mx>i ? Math.min(p[2*id-i], mx-i) : 1;
                while (str[i+p[i]] == str[i-p[i]]) {
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
            System.out.println(ans-1);
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