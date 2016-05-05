import java.util.*;
import java.io.*;

/*
Shortest Path
Floyd
 */
public class Main {

    public static PrintWriter out = new PrintWriter(new PrintStream(System.out));
    public static FastScanner cin = new FastScanner();
    public static int n, m;
    public static int[][] edges;

    public static void main(String[] args) {
        while (cin.hasNext()) {
            n = cin.nextInt();
            m = cin.nextInt();
            edges = new int[n+1][n+1];

            int u, v, len;
            for (int i=1; i<=n ;i++) {
                for (int j=1; j<=n; j++) {
                    if (i!=j) {
                        edges[i][j] = 100000;
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
            /*for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    System.out.print(edges[i][j] + " ");
                }
                System.out.println();
            }
            return;*/
            /*
            begin floyd
             */
            for (int k=1; k<=n; k++) {
                for (int i=1; i<=n; i++) {
                    for (int j=1; j<=n; j++) {
                        edges[i][j] = Math.min(edges[i][j], edges[i][k]+edges[k][j]);
                    }
                }
            }
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    System.out.print(edges[i][j] + " ");
                }
                System.out.println();
            }
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