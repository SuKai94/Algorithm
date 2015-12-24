

public class Solution {

    /*
    超时
     */
    /*
    public static int bulbSwitch(int n) {
        int[] bulbs=new int[n+1];
        for (int i=1; i<=n; i++) {
            bulbs[i]=1;
        }
        for (int iter=2; iter<=n; iter++) {
            int index = 0;
            for (int i=1; iter*i<=n; i++) {
                if (bulbs[iter*i] == 1) {
                    bulbs[iter*i] = 0;
                } else {
                    bulbs[iter*i] = 1;
                }
            }
        }
        int count=0;
        for (int i=1; i<=n; i++) {
            if (bulbs[i] == 1) {
                count++;
            }
        }
        return count;
    }*/

    public static int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args) {
        System.out.println(bulbSwitch(9));
    }
}