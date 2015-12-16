
public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        ListNode t = node.next;
        node.next = node.next.next;
        t = null;
    }

    public static void main(String[] args) {

    }

}