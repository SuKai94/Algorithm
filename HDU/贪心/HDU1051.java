import java.util.Arrays;
import java.util.Scanner;

class Stick implements Comparable<Stick> {

	public int l, w;
	public boolean vis;

	public Stick(int l, int w) {
		this.l = l;
		this.w = w;
		this.vis = false;
	}

	@Override
	public int compareTo(Stick o) {
		if (o.l != this.l) {
			return (this.l > o.l) ? 1 : -1;
		} else {
			return (this.w > o.w) ? 1 : -1;
		}
	}

}

public class Main {
	public static int t, n, l, w, sum;
	public static Stick[] sticks;

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		t = cin.nextInt();
		while (t != 0) {
			n = cin.nextInt();
			sticks = new Stick[n];
			sum = 0;
			for (int i = 0; i < n; i++) {
				sticks[i] = new Stick(cin.nextInt(), cin.nextInt());
			}
			Arrays.sort(sticks);
			for (int i = 0; i < n; i++) {
				if (!sticks[i].vis) {
					sticks[i].vis = true;
					sum++;
					int weight = sticks[i].w;
					for (int j = i + 1; j < n; j++) {
						if (!sticks[j].vis && sticks[j].w >= weight) {
							sticks[j].vis = true;
							weight = sticks[j].w;
						}
					}
				}
			}
			System.out.println(sum);
			t--;
		}
	}
}