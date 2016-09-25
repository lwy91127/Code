package List;

/**
 * Created by lwy on 2016/9/17.
 * 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 * 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
 * 测试样例：
 * 1->2->2->1
 * 返回：true
 */
public class PalindromeList {
    private static boolean chkPalindrome(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = slow.next;
        ListNode next = p.next;
        slow.next.next = null;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = p;
            p = next;
            next = tmp;
        }
        while (p.next != null) {
            if (A.val != p.val)
                return false;
            p = p.next;
            A = A.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(1);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        System.out.println(chkPalindrome(head));
    }
}
