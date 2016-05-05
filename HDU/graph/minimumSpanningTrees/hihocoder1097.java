import java.util.*;
import java.io.*;

/*
MinimumSpanningTrees
Prim
 */
public class Main {

    public static PrintWriter out = new PrintWriter(new PrintStream(System.out));
    public static FastScanner cin = new FastScanner();
    public static int n;
    public static int[][] edges;
    public static boolean[] visited;
    public static int[] dis;

    public static void main(String[] args) {
        while (cin.hasNext()) {
            n = cin.nextInt();
            edges = new int[n+1][n+1];
            visited = new boolean[n+1];
            dis = new int[n+1];
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    edges[i][j] = cin.nextInt();
                }
            }
            for (int i=1; i<=n; i++) {
                visited[i] = false;
                dis[i] = edges[1][i];
            }
            /*
            begin prim
             */
            int nTrees=1, sumDis=0;
            visited[1] = true;
            while (nTrees < n) {
                int minDis = Integer.MAX_VALUE;
                int minIndex = 1;
                for (int i=1; i<=n; i++) {
                    if (!visited[i] && dis[i]<minDis) {
                        minDis = dis[i];
                        minIndex = i;
                    }
                }
                visited[minIndex] = true;
                sumDis += minDis;
                for (int i=1; i<=n; i++) {
                    if (!visited[i]) {
                        dis[i] = Math.min(dis[i], edges[minIndex][i]);
                    }
                }
                nTrees++;
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