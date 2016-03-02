import java.util.*;
import java.io.*;

class A implements Comparable<A> {
    long c, d;

    public A(long c, long d) {
        this.c = c;
        this.d = d;
    }

    public int compareTo(A o) {
        // 先按照d从小到大, 若相等按照c从小到大
        if (this.d == o.d) {
            //return this.c - o.c;
            return (this.c > o.c) ? 1: -1;
        }
        return (this.d > o.d) ? 1 : -1;
    }
}

public class Main {

    public static PrintWriter out = new PrintWriter(new PrintStream(System.out));
    public static FastScanner cin = new FastScanner();
    //public static Scanner cin = new Scanner(new BufferedInputStream(System.in));
    public static int MAXN = 100000 + 10;
    public static int T, N, cases;
    public static A[] as = new A[MAXN];
    public static long ans, time;

    /**
     * LCS Problem
     */
    public static void main(String[] args) {
        T = cin.nextInt();
        cases=1;
        while (T-- != 0) {
            N = cin.nextInt();
            ans = time = 0;
            for (int i=0; i<N; i++) {
                as[i] = new A(cin.nextLong(), cin.nextLong());
            }
            /*
            贪心策略：每次先安排截止时间小的活动。
            对于两个活动1、2，假设D1<D2，以起始时间为0为例。
            如果先安排活动1，则扣分最大值为max(C1-D1,C1+C2-D2)。
            如果先安排活动2，则扣分最大值为max(C2-D2,C1+C2-D1)。
            显然第二个式子中的C1+C2-D1既大于C1-D1，又大于C1+C2-D2，则选择活动1是明智的。
            */
            Arrays.sort(as, 0, N);
            for (int i=0; i<N; i++) {
                time += as[i].c;
                if (time - as[i].d > ans) {
                    ans = time - as[i].d;
                }
            }
            out.println("Case " + cases++ + ": " + ans);
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