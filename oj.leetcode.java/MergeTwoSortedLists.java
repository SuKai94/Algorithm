
public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) {
            return l2;
        }
        if (l2==null) {
            return l1;
        }
        ListNode head = l1.val<=l2.val ? l1:l2;
        ListNode other = head==l1? l2:l1;
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.val < other.val) {
                pre=cur;
                cur=pre.next;
            } else {
                pre.next=other;
                pre=pre.next;
                other=cur;
                cur=pre.next;

            }
        }
        pre.next=other;
        return head;
    }

    public static void main(String[] args) {

    }
}