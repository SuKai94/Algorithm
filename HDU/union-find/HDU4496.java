import java.util.*;
import java.io.*;

class edge {
    public int u;
    public int v;

    public edge(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

public class Main {

    public static int[] points = new int[10000 + 10];
    public static int[] ans = new int[1000000 + 10];
    public static edge[] edges = new edge[1000000 + 10];

    public static int father(int p) {
        while (p != points[p]) {
            points[p] = points[points[p]];
            p = points[p];
        }
        return p;
    }

    public static void main(String[] args) {
        FastScanner cin = new FastScanner();
        PrintWriter out = new PrintWriter(new PrintStream(System.out));
        //Scanner cin = new Scanner(System.in);
        int n, m;

        while (cin.hasNext()) {
            n = cin.nextInt();
            m = cin.nextInt();

            // input edges
            for (int i=1; i<=m; i++) {
                edges[i] = new edge(cin.nextInt(), cin.nextInt());
            }
            // union-find init
            for (int i=0; i<n; i++) {
                points[i] = i;
            }
            // cal
            ans[m] = n;
            for (int i=m; i>1; i--) {
                int uf = father(edges[i].u);
                int vf = father(edges[i].v);
                if (uf != vf) {
                    ans[i-1] = ans[i] - 1;
                    points[uf] = vf;
                } else {
                    ans[i-1] = ans[i];
                }
            }
            for (int i=1; i<=m; i++) {
                out.println(ans[i]);
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