import java.util.Scanner;

public class Main {
	public static int n, res;
	public static int[] a;

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			n = cin.nextInt();
			int m, j;
			res = 0;
			a = new int[n];
			for (int i = 0; i < n; i++) {
				m = cin.nextInt();
				for (j = 0; j < res; j++) {
					if (m < a[j]) {
						a[j] = m;
						break;
					}
				}
				if (j == res) {
					a[res++] = m;
				}
			}
			System.out.println(res);
		}
	}
}