import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        FastScanner cin = new FastScanner();
        PrintWriter out = new PrintWriter(new PrintStream(System.out));
        //Scanner cin = new Scanner(System.in);
        int n, m;

        while (cin.hasNext()) {
            n = cin.nextInt();
            m = cin.nextInt();
            if (n == 0) {
                break;
            }
            int[][] map = new int[n][n];
            int[] indegress = new int[n];
            int x, y;
            for (int i=0; i<m; i++) {
                x = cin.nextInt();
                y = cin.nextInt();
                if (map[x][y] == 0) {
                    map[x][y] = 1;
                    indegress[y]++;
                }
            }
            // 拓扑排序
            int flag = 0, count = 0;
            for (int j=0; j<n; j++) {
                int ok=0, t=0;
                for (int i=0; i<n; i++) {
                    if (indegress[i] == 0) {
                        ok = 1;
                        t = i;
                    }
                }
                if (ok == 0) {
                    break;
                }
                indegress[t] = -1;
                count++;
                if (count == n) {
                    flag = 1;
                    break;
                }
                for (int i=0; i<n; i++) {
                    if (map[t][i] == 1) {
                        map[t][i] = -1;
                        indegress[i]--;
                    }
                }
            }
            if (flag == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
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