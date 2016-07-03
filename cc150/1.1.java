
public class Solution {

    public static boolean check(String str) {
        /*
        利用位操作可节省空间
        利用整数的32位记录str中字符是否出现过
        256 ASCII字符只需要8个整数即可,不需要256 size的整数数组了
         */
        int[] bits = new int[8];
        boolean ok = true;
        for (int i=0; i<str.length(); i++) {
            int v = (int)(str.charAt(i));
            int idx = v/32;
            int shift = v%32;
            if ((bits[idx] & (1 << shift)) != 0) {
                ok = false;
                break;
            } else {
                bits[idx] |= (1 << shift);
            }
        }
        return ok;
    }

    public static void main(String[] args) {
        System.out.println(check("adc"));
    }
}