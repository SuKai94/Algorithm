import java.util.Scanner;
/**
 * HDU 1010
 * 解题报告：http://blog.csdn.net/kuaisuzhuceh/article/details/21370123
 * @author sukai
 *
 */
public class Main {
	public static char[][] maze = new char[7][7];
	public static boolean[][] visited = new boolean[7][7];
	public static int N, M, T;
	public static int start_i, start_j, end_i, end_j;

	/**
	 * 深度搜索，利用递归解题
	 * @param cur_pos_i
	 * @param cur_pos_j
	 * @param cur_time
	 * @return
	 */
	public static boolean DFS(int cur_pos_i, int cur_pos_j, int cur_time) {
		//判断是否越界
		if (cur_pos_i < 0 || cur_pos_i >= N || cur_pos_j < 0 || cur_pos_j >= M) {
			return false;
		}
		//判断时间是否符合条件
		if (cur_time > T) {
			return false;
		}
		//判断是否是围墙
		if (maze[cur_pos_i][cur_pos_j] == 'X') {
			return false;
		}
		//判断是否已经走过
		if (visited[cur_pos_i][cur_pos_j]) {
			return false;
		}
		//奇偶性剪枝
		if ((cur_pos_i + cur_pos_j + end_i + end_j + (T - cur_time)) % 2 == 1) {
			return false;
		}
		if (maze[cur_pos_i][cur_pos_j] == 'D') {
			if (cur_time == T) {
				return true;
			} else {
				return false;
			}
		}
		visited[cur_pos_i][cur_pos_j] = true;
		//递归
		boolean res = DFS(cur_pos_i + 1, cur_pos_j, cur_time + 1)
				|| DFS(cur_pos_i - 1, cur_pos_j, cur_time + 1)
				|| DFS(cur_pos_i, cur_pos_j + 1, cur_time + 1)
				|| DFS(cur_pos_i, cur_pos_j - 1, cur_time + 1);
		visited[cur_pos_i][cur_pos_j] = false;
		return res;
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (true) {
			N = cin.nextInt();
			M = cin.nextInt();
			T = cin.nextInt();

			if (N == 0 && M == 0 && T == 0) {
				break;
			}
			int blocks = 0;
			for (int i = 0; i < N; i++) {
				String str = cin.next();
				for (int j = 0; j < M; j++) {
					maze[i][j] = str.charAt(j);
					if (maze[i][j] == 'S') {
						start_i = i;
						start_j = j;
					} else if (maze[i][j] == 'D') {
						end_i = i;
						end_j = j;
					} else if (maze[i][j] == 'X') {
						blocks++;
					}
				}
			}
			//剪枝，如果可走位置数少于时间，是无法完成的
			if (M * N - blocks < T) {
				System.out.println("NO");
			} else {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						visited[i][j] = false;
					}
				}
				if (DFS(start_i, start_j, 0)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
}
