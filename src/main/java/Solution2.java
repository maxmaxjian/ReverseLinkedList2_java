public class Solution2 implements Solution {
    @Override
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode prevM = newhead, first = newhead, second = newhead, p = newhead;
        int i = 0;
        while (i <= n) {
            if (i == m-1) {
                prevM = p;
            }
            if (i == m) {
                first = p;
            }
            if (i == m+1) {
                second = p;
            }
            p = p.next;
            i++;
        }

        for (i = 0; i < n-m; i++) {
            first.next = second.next;
            second.next = prevM.next;
            prevM.next = second;
            second = first.next;
        }

        return newhead.next;
    }

    private void print(ListNode head) {
        if (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print("->");
            }
            print(head.next);
        }
    }
}
