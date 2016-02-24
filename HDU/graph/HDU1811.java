import java.util.*;
import java.io.*;

public class Main {

    public static int MAXN = 10000 + 10;
    public static int MAXM = 20000 + 10;
    public static int n, m, count, flag, sum;
    public static int[] u = new int[MAXM];
    public static int[] v = new int[MAXM];
    public static char[] c = new char[MAXN];
    public static int[] indegrees = new int[MAXN];
    public static int[] first = new int[MAXN];
    public static int[] next = new int[MAXM];
    public static int[] parents = new int[MAXN];

    public static int find(int p) {
        while (p != parents[p]) {
            parents[p] = parents[parents[p]];
            p = parents[p];
        }
        return p;
    }

    public static void topu() {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i=0; i<n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int t;
        while (queue.size() != 0) {
            if (queue.size() > 1) {
                flag = 1;
            }
            t = queue.poll();
            count++;
            for (int l=first[t]; l!=-1; l=next[l]) {
                if (--indegrees[find(v[l])] == 0) {
                    queue.offer(find(v[l]));
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
            Arrays.fill(first, -1);
            for (int i=0; i<n; i++) {
                parents[i] = i;
            }
            sum = n;
            for (int i=0; i<m; i++) {
                u[i] = cin.nextInt();
                c[i] = cin.nextToken().charAt(0);
                v[i] = cin.nextInt();
                if (c[i] == '=') {
                    int up = find(u[i]);
                    int vp = find(v[i]);
                    if (up != vp) {
                        parents[up] = vp;
                        indegrees[up] = -1;
                        sum--;
                    }
                }
            }
            for (int i=0; i<m; i++) {
                if (c[i] == '<') {
                    indegrees[find(v[i])]++;
                    next[i] = first[find(u[i])];
                    first[find(u[i])] = i;
                } else if (c[i] == '>') {
                    int t = u[i];
                    u[i] = v[i];
                    v[i] = t;
                    indegrees[find(v[i])]++;
                    next[i] = first[find(u[i])];
                    first[find(u[i])] = i;
                }
            }
            count = flag = 0;
            topu();
            if (count != sum) {
                out.println("CONFLICT");
            }
            else if (flag == 1) {
                out.println("UNCERTAIN");
            } else {
                out.println("OK");
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