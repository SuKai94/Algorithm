import java.util.Scanner;

public class Main {
	public static int n, res;
	public static char[][] map;

	public static boolean judge(int x, int y) {
		for (int i = x; i >= 0; i--) {
			if (map[i][y] == '0') {
				return false;
			}
			if (map[i][y] == 'X') {
				break;
			}
		}

		for (int j = y; j >= 0; j--) {
			if (map[x][j] == '0') {
				return false;
			}
			if (map[x][j] == 'X') {
				break;
			}
		}
		return true;
	}

	public static void DFS(int i, int count) {
		if (i == n * n) {
			if (count > res) {
				res = count;
			}
			return;
		}
		int x = i / n;
		int y = i % n;
		if(map[x][y] == '.' && judge(x, y)) {
			map[x][y] = '0';
			DFS(i+1, count+1);
			map[x][y] = '.';
		}
		DFS(i+1, count);
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (true) {
			n = cin.nextInt();
			if (n == 0) {
				break;
			}
			map = new char[n][n];
			for (int i = 0; i < n; i++) {
				String str = cin.next();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			res = 0;
			DFS(0, 0);
			System.out.println(res);
		}
	}
}