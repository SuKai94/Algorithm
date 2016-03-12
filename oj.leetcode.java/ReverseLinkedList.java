
/**
 * Created by sukai on 3/3/16.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    /*
    递归版本
     */
    public ListNode reverseListRecursion(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newhead = head;
        while(newhead.next != null)
            newhead = newhead.next;
        reverse(head);
        return newhead;
    }

    public ListNode reverse(ListNode head) {
        if(head.next == null)
            return head;
        else
        {
            ListNode tail = reverse(head.next);
            tail.next = head;
            tail = tail.next;
            tail.next = null;
            return tail;
        }
    }

    /*
    非递归版本
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else if (head.next.next == null) {
            ListNode newhead = head.next;
            newhead.next = head;
            head.next = null;
            return newhead;
        } else {
            ListNode pre = head;
            ListNode cur = pre.next;
            ListNode post = cur.next;
            pre.next = null;
            while (post != null) {
                cur.next = pre;
                pre = cur;
                cur = post;
                post = post.next;
            }
            cur.next = pre;
            return cur;
        }
    }

    public static void main(String[] args) {

    }
}
