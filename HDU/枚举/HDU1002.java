import java.util.Scanner;

public class Main {

	public static int n;
	public static int[] s1, s2;
	public static String A, B;

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		for (int count = 1; count <= n; count++) {
			A = cin.next();
			B = cin.next();
			s1 = new int[1002];
			s2 = new int[1002];
			int len1 = A.length();
			int len2 = B.length();
			int c, i;
			c = 0;
			for (i = len1 - 1; i >= 0; i--) {
				s1[c++] = A.charAt(i) - '0';
			}
			c = 0;
			for (i = len2 - 1; i >= 0; i--) {
				s2[c++] = B.charAt(i) - '0';
			}
			for (i = 0; i < 1002; i++) {
				s1[i] += s2[i];
				if (s1[i] >= 10) {
					s1[i] -= 10;
					s1[i+1]++;
				}
			}
			System.out.println("Case " + count + ":");
			System.out.print(A + " + " + B + " = ");
			for (i=1001; i >= 0; i--) {
				if (s1[i] != 0) {
					break;
				}
			}
			for (int j = i; j >=0; j--) {
				System.out.print(s1[j]);
			}
			System.out.println();
			if (count != n) {
				System.out.println();
			}
		}
	}
}