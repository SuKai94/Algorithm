public class Solution<Key extends Comparable<Key>> {
    /*
    基于堆的优先队列
     */
    public Key[] pq;
    public int N = 0;

    public void init(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public void exch(int i, int j) {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N++] = null;
        sink(1);
        return max;
    }

    public void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {

    }
}