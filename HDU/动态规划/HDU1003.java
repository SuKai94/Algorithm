import java.util.Scanner;

public class Main {
	public static int t, n, sum, a, max, start, end, k;

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		t = cin.nextInt();
		for (int count = 1; count <= t; count++) {
			n = cin.nextInt();
			sum = 0;
			max = -9999;
			start = end = k = 1;
			for (int i = 1; i <= n; i++) {
				a = cin.nextInt();
				sum += a;
				if (sum > max) {
					max = sum;
					start = k;
					end = i;
				}
				if (sum < 0) {
					sum = 0;
					k = i + 1;
				}
			}
			System.out.println("Case " + count + ":");
			System.out.println(max + " " + start + " " + end);
			if (count != t) {
				System.out.println();
			}
		}
	}
}