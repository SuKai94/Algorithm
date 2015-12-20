
public class Solution {

    public int overlap(int A, int B, int C, int D, int E, int F, int G, int H) {
        int upx=Math.min(C, G);
        int upy=Math.min(D, H);
        int downx=Math.max(A, E);
        int downy=Math.max(B, F);
        if (upx < downx || upy < downy) {
            return 0;
        }
        return (upx-downx)*(upy-downy);
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (C-A)*(D-B) + (G-E)*(H-F) - overlap(A,B,C,D,E,F,G,H);
    }

    public static void main(String[] args) {

    }
}