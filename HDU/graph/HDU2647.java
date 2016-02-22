import java.util.*;
import java.io.*;

public class Main {

    public static int MAXN = 10000 + 10;
    public static int MAXM = 20000 + 10;
    public static int n, m, sum, count;
    public static int[] u = new int[MAXM];
    public static int[] v = new int[MAXM];
    public static int[] indegrees = new int[MAXN];
    public static int[] first = new int[MAXN];
    public static int[] next = new int[MAXM];
    public static int[] moneys = new int[MAXN];

    public static void topu() {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i=1; i<=n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int t;
        while (queue.size() != 0) {
            t = queue.poll();
            sum += moneys[t];
            count++;
            for (int l=first[t]; l!=-1; l=next[l]) {
                if (--indegrees[v[l]] == 0) {
                    queue.offer(v[l]);
                    moneys[v[l]] = moneys[t]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        FastScanner cin = new FastScanner();
        PrintWriter out = new PrintWriter(new PrintStream(System.out));

        while (cin.hasNext()) {
            n = cin.nextInt();
            m = cin.nextInt();
            Arrays.fill(indegrees, 0);
            Arrays.fill(moneys, 888);
            Arrays.fill(first, -1);
            int a, b;
            for (int i=0; i<m; i++) {
                a = cin.nextInt();
                b = cin.nextInt();
                u[i] = b;
                v[i] = a;
                indegrees[v[i]]++;
                next[i] = first[u[i]];
                first[u[i]] = i;
            }
            sum = count = 0;
            topu();
            if (count != n) {
                //System.out.println(-1);
                out.println(-1);
            } else {
                //System.out.println(sum);
                out.println(sum);
            }
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