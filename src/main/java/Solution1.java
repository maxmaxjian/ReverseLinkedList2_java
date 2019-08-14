import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution1 implements Solution {
    @Override
    public ListNode reverseBetween(ListNode head, int m, int n) {

        Queue<ListNode> beforeM = new LinkedList<>(), afterN = new LinkedList<>();
        Stack<ListNode> stack = new Stack<>();

        ListNode p = head;
        int i = 1;
        while (i < m && p != null) {
            beforeM.add(p);
            p = p.next;
            i++;
        }

        while (i <= n && p != null) {
            stack.push(p);
            p = p.next;
            i++;
        }

        while (p != null) {
            afterN.add(p);
            p = p.next;
        }

        ListNode newHead;
        if (beforeM.isEmpty()) {
            newHead = stack.pop();
        } else {
            newHead = beforeM.remove();
        }
        p = newHead;
        while (!beforeM.isEmpty()) {
            p.next = beforeM.remove();
            p = p.next;
        }
        while (!stack.isEmpty()) {
            p.next = stack.pop();
            p = p.next;
        }
        while (!afterN.isEmpty()) {
            p.next = afterN.remove();
            p = p.next;
        }
        p.next = null;

        return newHead;
    }
}
