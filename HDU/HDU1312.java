import java.util.Scanner;

public class Main {
	public static int W, H, start_i, start_j, count;
	public static char[][] rectan;
	public static int[][] to = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 },
			{ 0, -1 } };

	public static void DFS(int cur_pos_i, int cur_pos_j) {
		count++;
		rectan[cur_pos_i][cur_pos_j] = '#';
		for (int k = 0; k < 4; k++) {
			int x = cur_pos_i + to[k][0];
			int y = cur_pos_j + to[k][1];
			if (x < H && x >= 0 && y < W && y >= 0 && rectan[x][y] == '.') {
				DFS(x, y);
			}
		}
		return;
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (true) {
			W = cin.nextInt();
			H = cin.nextInt();
			if (W == 0 && H == 0) {
				break;
			}
			rectan = new char[H][W];
			for (int i = 0; i < H; i++) {
				String str = cin.next();
				for (int j = 0; j < W; j++) {
					rectan[i][j] = str.charAt(j);
					if (rectan[i][j] == '@') {
						start_i = i;
						start_j = j;
					}
				}
			}
			count = 0;
			DFS(start_i, start_j);
			System.out.println(count);
		}
	}
}