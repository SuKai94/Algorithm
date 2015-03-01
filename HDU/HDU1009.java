import java.util.Arrays;
import java.util.Scanner;

class Cat implements Comparable<Cat> {

	public int j, f;
	public double p;

	public Cat(int j, int f) {
		this.j = j;
		this.f = f;
		initP();
	}

	public void initP() {
		p = j * 1.0 / f;
	}

	@Override
	public int compareTo(Cat o) {
		return (p < o.p) ? 1 : -1;
	}
}

public class Main {
	public static int m, n;
	public static double res;
	public static Cat[] cats;

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (true) {
			n = cin.nextInt();
			m = cin.nextInt();
			if (n == -1 || m == -1) {
				break;
			}
			res = 0;
			cats = new Cat[m];
			for (int i = 0; i < m; i++) {
				cats[i] = new Cat(cin.nextInt(), cin.nextInt());
			}
			Arrays.sort(cats);
			for (int i = 0; i < m && n > 0; i++) {
				if (n > cats[i].f) {
					n -= cats[i].f;
					res += cats[i].j;
				} else {
					res += n * 1.0 / cats[i].f * cats[i].j;
					n = 0;
				}
			}
			System.out.printf("%.3f", res);
			System.out.println();
		}
	}
}