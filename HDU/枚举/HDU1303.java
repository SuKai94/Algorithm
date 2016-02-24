import java.util.*;
import java.io.*;

public class Main {

    public static PrintWriter out = new PrintWriter(new PrintStream(System.out));
    public static FastScanner cin = new FastScanner();
    public static int MAXN = 15 + 5;
    public static int[] numbers = new int[MAXN];
    public static int ans;

    public static int solution() {
        ans = 0;
        int count=0, n;
        while (cin.hasNext()) {
            n = cin.nextInt();
            if (n == 0) {
                break;
            }
            if (n == -1) {
                return 0;
            }
            numbers[count++] = n;
        }
        for (int i=0; i<count; i++) {
            for (int j=0; j<count; j++) {
                if (numbers[j] == numbers[i]*2) {
                    ans++;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {

        while (solution() == 1) {
            out.println(ans);
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