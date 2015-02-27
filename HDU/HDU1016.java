import java.util.Scanner;

public class Main {
	public static int n;
	public static int[] prime = new int[] { 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0,
			1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0,
			0, 0, 0, 0, 1, 0, 0 };;
	public static boolean[] used;
	public static int[] result;

	public static void DFS(int num) {
		if (num == n && prime[result[num - 1] + result[0]] == 1) {
			for (int i = 0; i < n - 1; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println(result[n - 1]);
		} else {
			for (int i = 2; i <= n; i++) {
				if (!used[i-1] && prime[result[num - 1] + i] == 1) {
					used[i-1] = true;
					result[num] = i;
					num++;
					DFS(num);
					used[i-1] = false;
					num--;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int cases = 1;
		while (cin.hasNext()) {
			n = cin.nextInt();
			used = new boolean[n];
			result = new int[n];
			System.out.println("Case " + cases + ":");
			cases++;
			for (int i = 0; i < n; i++) {
				used[i] = false;
			}
			result[0] = 1;
			used[0] = true;
			DFS(1);
			System.out.println();
		}
	}
}