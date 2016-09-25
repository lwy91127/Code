package List;

public class AddTwoNum {
    public static ListNode addTwoNum(ListNode l1, ListNode l2) {
        int carry = 0;
        int val;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                val = l2.val + carry;
                l2 = l2.next;
            } else if (l2 == null) {
                val = l1.val + carry;
                l1 = l1.next;
            } else {
                val = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            carry = val / 10;
            int i = val % 10;
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNum(l1, l2);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }

    }
}
