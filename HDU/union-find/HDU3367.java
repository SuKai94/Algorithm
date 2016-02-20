import java.util.*;
import java.io.*;

class edge implements Comparable<edge> {
    public int u;
    public int v;
    public int c;

    public edge(int u, int v, int c) {
        this.u = u;
        this.v = v;
        this.c = c;
    }

    public int compareTo(edge e) {
        return e.c - c;
    }
}

public class Main {

    public static int[] parents = new int[10000 + 10];
    public static int[] cir = new int[1000000 + 10];

    public static int find(int p) {
        while (p != parents[p]) {
            parents[p] = parents[parents[p]];
            p = parents[p];
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
            if (n==0 && m==0) {
                break;
            }
            edge[] edges = new edge[m];
            Arrays.fill(cir, 0);
            // input edges
            for (int i=0; i<m; i++) {
                edges[i] = new edge(cin.nextInt(), cin.nextInt(), cin.nextInt());
            }
            // union-find init
            for (int i=0; i<n; i++) {
                parents[i] = i;
            }
            Arrays.sort(edges);
            int res = 0;
            for (int i=0; i<m; i++) {
                int uf = find(edges[i].u);
                int vf = find(edges[i].v);
                if (uf==vf) {
                    if (cir[uf]==0 && cir[vf]==0) {
                        parents[uf] = vf;
                        cir[uf] = cir[vf] = 1;
                        res += edges[i].c;
                    } else {
                        continue;
                    }
                } else {
                    if (cir[uf]==1 && cir[vf]==1) {
                        continue;
                    } else if (cir[uf]==1 || cir[vf]==1){
                        cir[uf]=cir[vf]=1;
                    }
                    parents[uf] = vf;
                    res += edges[i].c;
                }
            }
            //System.out.println(res);
            out.println(res);
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