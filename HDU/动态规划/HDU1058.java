import java.util.Scanner;

public class Main {
	public static int n, a, b, c, d;
	public static int[] dp = new int[6000];

	public static int min(int x, int y) {
		if (x < y) {
			return x;
		} else {
			return y;
		}
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		a = b = c = d = 1;
		dp[1] = 1;
		for (int i = 2; i <= 5842; i++) {
			dp[i] = min(dp[a] * 2, min(dp[b] * 3, min(dp[c] * 5, dp[d] * 7)));
			if (dp[i] == dp[a] * 2) {
				a++;
			}
			if (dp[i] == dp[b] * 3) {
				b++;
			}
			if (dp[i] == dp[c] * 5) {
				c++;
			}
			if (dp[i] == dp[d] * 7) {
				d++;
			}
		}
		while (true) {
			n = cin.nextInt();
			if (n == 0) {
				break;
			}
			else if (n%10 == 1 && n%100 != 11) {
				System.out.println("The " + n + "st humble number is " + dp[n]
						+ ".");
			}
			else if (n%10 == 2 && n%100 != 12) {
				System.out.println("The " + n + "nd humble number is " + dp[n]
						+ ".");
			}
			else if (n%10 == 3 && n%100 != 13) {
				System.out.println("The " + n + "rd humble number is " + dp[n]
						+ ".");
			} else {
				System.out.println("The " + n + "th humble number is " + dp[n]
						+ ".");
			}
		}
	}
}