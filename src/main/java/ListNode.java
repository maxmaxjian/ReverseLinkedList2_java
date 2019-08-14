public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        this(x, null);
    }

    ListNode(int x, ListNode nx) {
        val = x;
        next = nx;
    }
}
