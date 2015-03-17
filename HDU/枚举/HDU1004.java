import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static int n;
	public static Map<String, Integer> map = new HashMap<String, Integer>();

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (true) {
			n = cin.nextInt();
			if (n == 0) {
				break;
			}
			map.clear();
			for (int i = 0; i < n; i++) {
				String color = cin.next();
				try {
					int count = map.get(color);
					map.put(color, count + 1);
				} catch (NullPointerException e) {
					map.put(color, 1);
				}
			}
			String popularCol = null;
			int maxNums = 0;
			for (String color: map.keySet()) {
				int count = map.get(color);
				if (count > maxNums) {
					maxNums = count;
					popularCol = color;
				}
			}
			System.out.println(popularCol);
		}
	}
}