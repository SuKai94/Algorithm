import java.util.Scanner;

public class Main {

	public static int[][] dp;
	public static int MAX = 122;
	public static int n;

	public static int initDP(int n, int k) {
		if (dp[n][k] != -1) {
			return dp[n][k];
		}
		if (n == -1 || k == -1) {
			dp[n][k] = 0;
			return dp[n][k];
		}
		if (n == 1 || k == 1) {
			dp[n][k] = 1;
			return dp[n][k];
		}
		if (n < k) {
			dp[n][k] = initDP(n, n);
			return dp[n][k];
		}
		if (n == k) {
			dp[n][k] = 1 + initDP(n, k - 1);
			return dp[n][k];
		} else {
			dp[n][k] = initDP(n - k, k) + initDP(n, k - 1);
			return dp[n][k];
		}
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		dp = new int[MAX][MAX];
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				dp[i][j] = -1;
			}
		}
		while (cin.hasNext()) {
			n = cin.nextInt();
			System.out.println(initDP(n, n));
		}
	}

}