import java.util.*;
import java.io.*;

public class Main {

    public static PrintWriter out = new PrintWriter(new PrintStream(System.out));
    public static FastScanner cin = new FastScanner();
    public static int MAXLEN = 10000 + 10;
    public static int[] nums = new int[MAXLEN];
    public static int k, currentSum, maxSum, begin, end, newBegin, negatives;

    /*
    最大连续子序列
    参考: http://www.cnblogs.com/zhangchaoyang/articles/2012070.html
     */
    public static void main(String[] args) {
        while (cin.hasNext()) {
            k = cin.nextInt();
            if (k == 0) {
                break;
            }
            Arrays.fill(nums, 0);
            currentSum = begin = end = newBegin = 0;
            maxSum = -1;
            negatives = 0;
            for (int i=0; i<k; i++) {
                nums[i] = cin.nextInt();
                if (nums[i] < 0) {
                    negatives++;
                }
            }
            if (negatives == k) {
                out.println(0 + " " + nums[0] + " " + nums[k-1]);
                continue;
            }
            for (int i=0; i<k; i++) {
                currentSum += nums[i];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    begin = newBegin;
                    end = i;
                }
                if (currentSum < 0) {
                    currentSum = 0;
                    newBegin = i+1;
                }
            }
            out.println(maxSum + " " + nums[begin] + " " + nums[end]);
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

    public String nextString() {
        return String.valueOf(nextToken());
    }
}