import java.util.*;
import java.io.*;

/*
Shortest Path
Dijkstra
 */
public class Main {

    public static PrintWriter out = new PrintWriter(new PrintStream(System.out));
    public static FastScanner cin = new FastScanner();
    public static int n, m, s, t;
    public static int[][] edges;
    public static int[] dist;
    public static boolean[] visited;

    public static void main(String[] args) {
        while (cin.hasNext()) {
            n = cin.nextInt();
            m = cin.nextInt();
            s = cin.nextInt();
            t = cin.nextInt();
            edges = new int[n+1][n+1];
            dist = new int[n+1];
            visited = new boolean[n+1];
            int u, v, len;
            for (int i=1; i<=n ;i++) {
                for (int j=1; j<=n; j++) {
                    if (i!=j) {
                        edges[i][j] = Integer.MAX_VALUE;
                    } else {
                        edges[i][j] = 0;
                    }
                }
            }
            for (int i=0; i<m; i++) {
                u = cin.nextInt();
                v = cin.nextInt();
                len = cin.nextInt();
                edges[u][v] = edges[v][u] = Math.min(edges[u][v], len);
            }
            for (int i=1;i <=n; i++) {
                dist[i] = edges[s][i];
                if (i != s) {
                    visited[i] = false;
                } else {
                    visited[i] = true;
                }
            }
            int nTrees = 1;
            /*
            begin dijkstra
             */
            while (nTrees < n) {
                int minDist = Integer.MAX_VALUE;
                int minIndex = s;
                for (int i=1; i<=n; i++) {
                    if (!visited[i] && dist[i]<minDist) {
                        minDist = dist[i];
                        minIndex = i;
                    }
                }
                visited[minIndex] = true;
                for (int i=1; i<=n; i++) {
                    if (!visited[i] && edges[minIndex][i]<Integer.MAX_VALUE) {
                        dist[i] = Math.min(dist[i], dist[minIndex]+edges[minIndex][i]);
                    }
                }
                nTrees++;
            }
            System.out.println(dist[t]);
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