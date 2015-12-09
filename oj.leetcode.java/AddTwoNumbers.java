
/**
 * Created by sukai on 12/9/15.
 */
public class Main {

     public static class ListNode {
         int val;
         ListNode next;

         ListNode(int x) {
             val = x;
         }
     }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0, flag=0;
        ListNode h = new ListNode(0);
        ListNode current = h;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + flag;
            flag = 0;
            if (sum >= 10) {
                sum -= 10;
                flag = 1;
            }
            ListNode temp = new ListNode(sum);
            current.next = temp;
            current = temp;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = l1.val + flag;
            flag = 0;
            if (sum >= 10) {
                sum -= 10;
                flag = 1;
            }
            ListNode temp = new ListNode(sum);
            current.next = temp;
            current = temp;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val + flag;
            flag = 0;
            if (sum >= 10) {
                sum -= 10;
                flag = 1;
            }
            ListNode temp = new ListNode(sum);
            current.next = temp;
            current = temp;
            l2 = l2.next;
        }

        if (flag == 1) {
            ListNode temp = new ListNode(flag);
            current.next = temp;
        }

        return h.next;
    }


    public static void main(String[] args) {
        //ListNode res = addTwoNumbers();
    }
}
