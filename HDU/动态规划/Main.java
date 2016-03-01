import java.util.*;
import java.io.*;

public class Main {

    public static PrintWriter out = new PrintWriter(new PrintStream(System.out));
    //public static FastScanner cin = new FastScanner();
    public static Scanner cin = new Scanner(new BufferedInputStream(System.in));
    public static int MAXLEN = 100 + 10;
    public static int[][] c = new int[MAXLEN][MAXLEN];
    public static int[][] b = new int[MAXLEN][MAXLEN];

    public static void lscLength(String[] x, String[] y) {
        for (int i=0; i<=x.length; i++) {
            c[i][0] = 0;
        }
        for (int i=0; i<=y.length; i++) {
            c[0][i] = 0;
        }
        for (int i=1; i<=x.length; i++) {
            for (int j=1; j<=y.length; j++) {
                if (x[i-1].equals(y[j-1])) {
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = 0;
                } else if (c[i-1][j] >= c[i][j-1]) {
                    c[i][j] = c[i-1][j];
                    b[i][j] = 1;
                } else {
                    c[i][j] = c[i][j-1];
                    b[i][j] = -1;
                }
            }
        }
    }

    public static void printLCS(String[] x, int m, int n) {
        int i=m;
        int j=n;
        if (i==0 || j==0) {
            return;
        }
        if (b[i][j] == 0) {
            printLCS(x, i-1, j-1);
            out.print(x[i-1] + " ");
        } else if (b[i][j] == 1) {
            printLCS(x, i-1, j);
        } else {
            printLCS(x, i ,j-1);
        }
    }

    /**
     * LCS Problem
     */
    public static void main(String[] args) {
        while (cin.hasNext()) {
            String s1 = "", s2 = "";
            while (cin.hasNext()) {
                String s = cin.nextLine();
                if (s.startsWith("#")) {
                    break;
                }
                s.trim();
                s1 = s1 + s + " ";
            }
            while (cin.hasNext()) {
                String s = cin.nextLine();
                if (s.startsWith("#")) {
                    break;
                }
                s.trim();
                s2 = s2 + s + " ";
            }
            String[] ss1 = s1.trim().split(" ");
            String[] ss2 = s2.trim().split(" ");
            lscLength(ss1, ss2);
            printLCS(ss1, ss1.length, ss2.length);
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