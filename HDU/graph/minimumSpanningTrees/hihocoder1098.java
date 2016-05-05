import java.util.*;
import java.io.*;

/*
MinimumSpanningTrees
Kruskal
 */
class edge implements Comparable<edge> {
    public int u;
    public int v;
    public int len;

    public edge(int u, int v, int len) {
        this.u = u;
        this.v = v;
        this.len = len;
    }

    public int compareTo(edge o) {
        return this.len>o.len ? 1 : -1;
    }
}

public class Main {
    public static PrintWriter out = new PrintWriter(new PrintStream(System.out));
    public static FastScanner cin = new FastScanner();
    public static int n, m;
    public static edge[] edges;
    public static int[] parents;

    public static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    public static void union(int a, int b) {
        if (find(a) != find(b)) {
            parents[find(a)] = find(b);
        }
    }

    public static void main(String[] args) {
        while (cin.hasNext()) {
            n = cin.nextInt();
            m = cin.nextInt();
            edges = new edge[m];
            parents = new int[n+1];
            for (int i=0; i<m; i++) {
                edges[i] = new edge(cin.nextInt(), cin.nextInt(), cin.nextInt());
            }
            Arrays.sort(edges);
            int sumDis = 0;
            for (int i=1; i<=n; i++) {
                parents[i] = i;
            }
            for (int i=0; i<m; i++) {
                //System.out.println(edges[i].u + " " + edges[i].v + " " + edges[i].len);
                if (find(edges[i].u) != find(edges[i].v)) {
                    union(edges[i].u, edges[i].v);
                    sumDis += edges[i].len;
                }
            }
            System.out.println(sumDis);
        }
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